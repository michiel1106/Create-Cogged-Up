package com.lampboy.cogged_up;


import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = CoggedUp.ADDON_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CoggedUpCreativeTabs {









    public static final CreativeModeTab BASE_TAB = new CreativeModeTab("cogged_up_base") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CoggedUpBlocks.ANDESITE_COGWHEEL.get());
        }

    };



//   public static final RegistryObject<CreativeModeTab> BASE_TAB = TABS.register("cogged_up_base",
//           () -> CreativeModeTab.builder()
//                   .withTabsBefore(CreativeModeTab.SPAWN_EGGS)
//                   .title(Component.literal("Create: Cogged Up"))
//                   .icon(() -> new ItemStack(CoggedUpBlocks.ANDESITE_COGWHEEL))
//                   .displayItems((p, output) -> {
//                       output.accept(CoggedUpBlocks.ANDESITE_COGWHEEL.get());
//                       output.accept(CoggedUpBlocks.LARGE_ANDESITE_COGWHEEL.get());
//                       output.accept(CoggedUpBlocks.BRASS_COGWHEEL.get());
//                       output.accept(CoggedUpBlocks.LARGE_BRASS_COGWHEEL.get());
//                       output.accept(CoggedUpBlocks.COPPER_COGWHEEL.get());
//                       output.accept(CoggedUpBlocks.LARGE_COPPER_COGWHEEL.get());
//                       output.accept(CoggedUpBlocks.INDUSTRIAL_IRON_COGWHEEL.get());
//                       output.accept(CoggedUpBlocks.LARGE_INDUSTRIAL_IRON_COGWHEEL.get());
//                   })
//                   .build());

    public static void register(IEventBus eventBus) {

    }















}
