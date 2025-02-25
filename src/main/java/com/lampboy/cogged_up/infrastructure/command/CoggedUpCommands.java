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
                                                                                    String material = StringArgumentType.getString(context, "material");

                                                                                    StressReductionSavedData savedData
                                                                                            = dataStorage.computeIfAbsent(StressReductionSavedData::load, StressReductionSavedData::new, "cogged_up_stress_reduction");

                                                                                    switch (material) {
                                                                                        default -> {
                                                                                            player.sendSystemMessage(Component.literal("Failed to specify material"));
                                                                                            return 0;
                                                                                        }
                                                                                        case "wood" -> savedData.wood = factor;
                                                                                        case "andesite" -> savedData.andesite = factor;
                                                                                        case "brass" -> savedData.brass = factor;
                                                                                        case "copper" -> savedData.copper = factor;
                                                                                        case "industrial" -> savedData.industrial = factor;
                                                                                    }

                                                                                    player.sendSystemMessage(Component.literal(
                                                                                            "Set the stress reduction factor of " + material + " cogwheels to " + factor
                                                                                    ));
                                                                                    savedData.setDirty();
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

                                                    StressReductionSavedData savedData
                                                            = dataStorage.computeIfAbsent(StressReductionSavedData::load, StressReductionSavedData::new, "cogged_up_stress_reduction");

                                                    player.sendSystemMessage(
                                                            Component.literal("The Current Stress Reduction: \n"
                                                                    + "Wood: " + savedData.wood + "\n"
                                                                    + "Andesite: " + savedData.andesite + "\n"
                                                                    + "Brass: " + savedData.brass + "\n"
                                                                    + "Copper: " + savedData.copper + "\n"
                                                                    + "Industrial: " + savedData.industrial
                                                            )
                                                    );

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
