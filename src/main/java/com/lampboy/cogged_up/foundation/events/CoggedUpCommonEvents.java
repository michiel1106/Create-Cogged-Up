package com.lampboy.cogged_up.foundation.events;

import com.lampboy.cogged_up.CoggedUp;
import com.lampboy.cogged_up.content.custom_cogwheel.StressReductionSavedData;
import com.lampboy.cogged_up.infrastructure.command.CoggedUpCommands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.storage.DimensionDataStorage;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CoggedUp.ADDON_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CoggedUpCommonEvents {

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event) {
        CoggedUpCommands.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onLoadWorld(LevelEvent.Load event) {
        MinecraftServer server = event.getLevel().getServer();
        if (server == null) return;
        DimensionDataStorage dataStorage = server.overworld().getDataStorage();

        StressReductionSavedData savedData
                = dataStorage.computeIfAbsent(StressReductionSavedData::load, StressReductionSavedData::new, "cogged_up_stress_reduction");

        if (savedData.isFirstTime) {
            savedData.setToDefault();
            savedData.isFirstTime = false;
            savedData.setDirty();
        }
    }
}
