package com.lampboy.cogged_up;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CoggedUpCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CoggedUp.ADDON_ID);

    public static final RegistryObject<CreativeModeTab> BASE_TAB = TABS.register("cogged_up_base",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.literal("Create: Cogged Up"))
                    .icon(() -> new ItemStack(CoggedUpBlocks.ANDESITE_COGWHEEL))
                    .displayItems((p, output) -> {
                        output.accept(CoggedUpBlocks.ANDESITE_COGWHEEL.get());
                        output.accept(CoggedUpBlocks.LARGE_ANDESITE_COGWHEEL.get());
                        output.accept(CoggedUpBlocks.BRASS_COGWHEEL.get());
                        output.accept(CoggedUpBlocks.LARGE_BRASS_COGWHEEL.get());
                        output.accept(CoggedUpBlocks.COPPER_COGWHEEL.get());
                        output.accept(CoggedUpBlocks.LARGE_COPPER_COGWHEEL.get());
                        output.accept(CoggedUpBlocks.INDUSTRIAL_IRON_COGWHEEL.get());
                        output.accept(CoggedUpBlocks.LARGE_INDUSTRIAL_IRON_COGWHEEL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {TABS.register(eventBus);}
}
