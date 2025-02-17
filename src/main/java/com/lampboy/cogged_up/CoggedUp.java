package com.lampboy.cogged_up;

import com.mojang.logging.LogUtils;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.compat.Mods;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.client.gui.font.providers.UnihexProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.storage.DimensionDataStorage;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CoggedUp.ADDON_ID)
public class CoggedUp {
    public static final String ADDON_ID = "cogged_up";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ADDON_ID)
            //All the items will show up in SEARCH tab if this is not set.
            .defaultCreativeTab((ResourceKey<CreativeModeTab>) null);

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(ADDON_ID, path);
    };

    public CoggedUp() {
        onInit();
    }

    private void onInit() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        REGISTRATE.registerEventListeners(modEventBus);

        AddonCreativeTabs.register(modEventBus);
        AddonBlocks.register();
        AddonBETypes.register();
        AddonPartialModels.register();
    }
}
