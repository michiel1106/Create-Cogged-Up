package com.lampboy.cogged_up;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.simibubi.create.AllItems;
import com.simibubi.create.Create;
import com.simibubi.create.content.contraptions.actors.seat.SeatBlock;
import com.simibubi.create.content.equipment.armor.BacktankUtil;
import com.simibubi.create.content.equipment.toolbox.ToolboxBlock;
import com.simibubi.create.content.kinetics.crank.ValveHandleBlock;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.item.TagDependentIngredientItem;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.mutable.MutableObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class AddonCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CoggedUp.ADDON_ID);

    public static final RegistryObject<CreativeModeTab> BASE_TAB = TABS.register("cogged_up_base",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .title(Component.literal("Create: Cogged Up"))
                    .icon(() -> new ItemStack(AddonBlocks.ANDESITE_COGWHEEL))
                    .displayItems((p, output) -> {
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
