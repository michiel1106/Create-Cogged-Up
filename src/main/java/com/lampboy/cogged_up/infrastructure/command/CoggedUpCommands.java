package com.lampboy.cogged_up.infrastructure.command;

import com.lampboy.cogged_up.content.custom_cogwheel.StressReductionSavedData;
import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.simibubi.create.foundation.damageTypes.CreateDamageSources;
import com.simibubi.create.foundation.utility.Components;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerEntity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;

import java.awt.*;
import java.util.Map;
import java.util.function.Predicate;

public class CoggedUpCommands {
    public static final Predicate<CommandSourceStack> SOURCE_IS_PLAYER = cs -> cs.getEntity() instanceof Player;

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {

        LiteralArgumentBuilder<CommandSourceStack> root = Commands.literal("coggedup")
                .then(
                        Commands.literal("stressReductionConfig")
                                .requires(SOURCE_IS_PLAYER)
                                .then(
                                        Commands.literal("set")
                                                .then(
                                                        Commands.argument("material", StringArgumentType.string())
                                                                .then(
                                                                        Commands.argument("factor", FloatArgumentType.floatArg(1))
                                                                                .executes(context -> {
                                                                                    MinecraftServer server = context.getSource().getServer();
                                                                                    ServerPlayer player = context.getSource().getPlayer();
                                                                                    DimensionDataStorage dataStorage = server.overworld().getDataStorage();

                                                                                    float factor = FloatArgumentType.getFloat(context, "factor");
                                                                                    String name = StringArgumentType.getString(context, "material");

                                                                                    StressReductionSavedData reductionSavedData
                                                                                            = dataStorage.computeIfAbsent(StressReductionSavedData::load, StressReductionSavedData::new, "cogged_up_stress_reduction");

                                                                                    boolean isMaterialPresent = reductionSavedData.setFactor(name, factor);

                                                                                    if (!isMaterialPresent) {
                                                                                        player.sendSystemMessage(Component.literal("Failed to specify material"));
                                                                                            return 0;
                                                                                    }

                                                                                    player.sendSystemMessage(Component.literal(
                                                                                            "Set the stress reduction factor of " + name + " cogwheels to " + factor
                                                                                    ));
                                                                                    reductionSavedData.setDirty();
                                                                                    return Command.SINGLE_SUCCESS;
                                                                                })
                                                                )
                                                )
                                )
                                .then(
                                        Commands.literal("get")
                                                .executes(context -> {
                                                    MinecraftServer server = context.getSource().getServer();
                                                    ServerPlayer player = context.getSource().getPlayer();
                                                    DimensionDataStorage dataStorage = server.overworld().getDataStorage();

                                                    StressReductionSavedData reductionSavedData
                                                            = dataStorage.computeIfAbsent(StressReductionSavedData::load, StressReductionSavedData::new, "cogged_up_stress_reduction");
                                                    Map<String, Float> factors = reductionSavedData.getFactors();

                                                    player.sendSystemMessage(Component.literal(
                                                            "Current stress reduction factors for cogwheels:"
                                                    ));

                                                    for (Map.Entry<String, Float> entry: factors.entrySet()) {
                                                        String name = entry.getKey();
                                                        Float factor = entry.getValue();

                                                        player.sendSystemMessage(Component.literal(
                                                                name + ": " + factor
                                                        ));
                                                    }

                                                    return Command.SINGLE_SUCCESS;
                                                })
                                )
                                .then(
                                        Commands.literal("disable")
                                                .executes(context -> {
                                                    MinecraftServer server = context.getSource().getServer();
                                                    ServerPlayer player = context.getSource().getPlayer();
                                                    DimensionDataStorage dataStorage = server.overworld().getDataStorage();

                                                    StressReductionSavedData savedData
                                                            = dataStorage.computeIfAbsent(StressReductionSavedData::load, StressReductionSavedData::new, "cogged_up_stress_reduction");

                                                    savedData.disable();
                                                    savedData.setDirty();

                                                    player.sendSystemMessage(Component.literal(
                                                            "Stress reduction for all cogwheel variants are set to 1"
                                                    ));

                                                    return Command.SINGLE_SUCCESS;
                                                })
                                )
                                .then(
                                        Commands.literal("default")
                                                .executes(context -> {
                                                    MinecraftServer server = context.getSource().getServer();
                                                    ServerPlayer player = context.getSource().getPlayer();
                                                    DimensionDataStorage dataStorage = server.overworld().getDataStorage();

                                                    StressReductionSavedData savedData
                                                            = dataStorage.computeIfAbsent(StressReductionSavedData::load, StressReductionSavedData::new, "cogged_up_stress_reduction");

                                                    savedData.setToDefault();
                                                    savedData.setDirty();

                                                    player.sendSystemMessage(Component.literal(
                                                            "Stress reduction for all cogwheel variants are set to default state"
                                                    ));

                                                    return Command.SINGLE_SUCCESS;
                                                })
                                )
                );

        dispatcher.register(root);
    }
}
