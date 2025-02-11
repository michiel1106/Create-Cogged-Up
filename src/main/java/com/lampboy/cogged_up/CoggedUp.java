package com.lampboy.cogged_up;

import com.mojang.logging.LogUtils;
import com.simibubi.create.foundation.data.CreateRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(CoggedUp.ADDON_ID)
public class CoggedUp {
    public static final String ADDON_ID = "my_addon";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(ADDON_ID);

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

        AddonBlocks.register();
        AddonCreativeTabs.register(modEventBus);
        AddonBETypes.register();
        AddonPartialModels.register();
    }
}
