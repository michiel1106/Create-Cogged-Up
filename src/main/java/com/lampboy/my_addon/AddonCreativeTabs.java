package com.lampboy.my_addon;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class AddonCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MyAddon.ADDON_ID);

    public static final RegistryObject<CreativeModeTab> BASE_TAB = TABS.register("base",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.literal("Create: Mechanical Aesthetics"))
                    .icon(() -> new ItemStack(AddonBlocks.ANDESITE_COGWHEEL))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(AddonBlocks.ANDESITE_COGWHEEL.get());
                        output.accept(AddonBlocks.LARGE_ANDESITE_COGWHEEL.get());
                        output.accept(AddonBlocks.BRASS_COGWHEEL.get());
                        output.accept(AddonBlocks.LARGE_BRASS_COGWHEEL.get());
                        output.accept(AddonBlocks.COPPER_COGWHEEL.get());
                        output.accept(AddonBlocks.LARGE_COPPER_COGWHEEL.get());
                        output.accept(AddonBlocks.INDUSTRIAL_IRON_COGWHEEL.get());
                        output.accept(AddonBlocks.LARGE_INDUSTRIAL_IRON_COGWHEEL.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {TABS.register(eventBus);}
}
