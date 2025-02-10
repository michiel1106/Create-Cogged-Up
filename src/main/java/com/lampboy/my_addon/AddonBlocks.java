package com.lampboy.my_addon;

import com.lampboy.my_addon.content.custom_cogwheel.CogwheelVariant;
import com.lampboy.my_addon.content.custom_cogwheel.CustomCogwheelBlock;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockModel;
import com.simibubi.create.content.kinetics.simpleRelays.CogwheelBlockItem;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.foundation.data.TagGen;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class AddonBlocks {

    public static final BlockEntry<Block> SAMPLE_BLOCK = MyAddon.REGISTRATE.block("sample_block", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .item()
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> ANDESITE_COGWHEEL = MyAddon.REGISTRATE.block("andesite_cogwheel", (p) -> new CustomCogwheelBlock(false, p, CogwheelVariant.ANDESITE))
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.sound(SoundType.STONE).mapColor(MapColor.STONE))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(BlockStressDefaults.setCapacity(1.0d))
            .transform(pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> LARGE_ANDESITE_COGWHEEL = MyAddon.REGISTRATE.block("large_andesite_cogwheel", (p) -> new CustomCogwheelBlock(true, p, CogwheelVariant.ANDESITE))
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.sound(SoundType.STONE).mapColor(MapColor.STONE))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> BRASS_COGWHEEL = MyAddon.REGISTRATE.block("brass_cogwheel", (p) -> new CustomCogwheelBlock(false, p, CogwheelVariant.BRASS))
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.mapColor(MapColor.STONE))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> LARGE_BRASS_COGWHEEL = MyAddon.REGISTRATE.block("large_brass_cogwheel", (p) -> new CustomCogwheelBlock(true, p, CogwheelVariant.BRASS))
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.mapColor(MapColor.STONE))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> COPPER_COGWHEEL = MyAddon.REGISTRATE.block("copper_cogwheel", (p) -> new CustomCogwheelBlock(false, p, CogwheelVariant.COPPER))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.STONE))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> LARGE_COPPER_COGWHEEL = MyAddon.REGISTRATE.block("large_copper_cogwheel", (p) -> new CustomCogwheelBlock(true, p, CogwheelVariant.COPPER))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.DIRT))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> INDUSTRIAL_IRON_COGWHEEL = MyAddon.REGISTRATE.block("industrial_iron_cogwheel", (p) -> new CustomCogwheelBlock(false, p, CogwheelVariant.INDUSTRIAL_IRON))
            .initialProperties(SharedProperties::netheriteMetal)
            .properties(p -> p.mapColor(MapColor.STONE))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> LARGE_INDUSTRIAL_IRON_COGWHEEL = MyAddon.REGISTRATE.block("large_industrial_iron_cogwheel", (p) -> new CustomCogwheelBlock(true, p, CogwheelVariant.INDUSTRIAL_IRON))
            .initialProperties(SharedProperties::netheriteMetal)
            .properties(p -> p.mapColor(MapColor.DIRT))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static void register() {
        MyAddon.LOGGER.info("Blocks have been registered!");
    }
}
