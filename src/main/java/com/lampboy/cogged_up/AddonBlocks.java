package com.lampboy.cogged_up;

import com.lampboy.cogged_up.content.custom_cogwheel.CogwheelVariant;
import com.lampboy.cogged_up.content.custom_cogwheel.CustomCogwheelBlock;
import com.lampboy.cogged_up.content.custom_cogwheel.encased.CustomEncasedCogwheelBlock;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockModel;
import com.simibubi.create.content.kinetics.simpleRelays.CogwheelBlockItem;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogCTBehaviour;
import com.simibubi.create.foundation.data.*;
import com.simibubi.create.foundation.utility.Couple;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class AddonBlocks {

    public static final BlockEntry<Block> SAMPLE_BLOCK = CoggedUp.REGISTRATE.block("sample_block", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .item()
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> ANDESITE_COGWHEEL = CoggedUp.REGISTRATE.block("andesite_cogwheel", (p) -> new CustomCogwheelBlock(false, p, CogwheelVariant.ANDESITE))
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

    public static final BlockEntry<CustomCogwheelBlock> LARGE_ANDESITE_COGWHEEL = CoggedUp.REGISTRATE.block("large_andesite_cogwheel", (p) -> new CustomCogwheelBlock(true, p, CogwheelVariant.ANDESITE))
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.sound(SoundType.STONE).mapColor(MapColor.STONE))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> BRASS_COGWHEEL = CoggedUp.REGISTRATE.block("brass_cogwheel", (p) -> new CustomCogwheelBlock(false, p, CogwheelVariant.BRASS))
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.mapColor(MapColor.STONE))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> LARGE_BRASS_COGWHEEL = CoggedUp.REGISTRATE.block("large_brass_cogwheel", (p) -> new CustomCogwheelBlock(true, p, CogwheelVariant.BRASS))
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.mapColor(MapColor.STONE))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> COPPER_COGWHEEL = CoggedUp.REGISTRATE.block("copper_cogwheel", (p) -> new CustomCogwheelBlock(false, p, CogwheelVariant.COPPER))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.STONE))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> LARGE_COPPER_COGWHEEL = CoggedUp.REGISTRATE.block("large_copper_cogwheel", (p) -> new CustomCogwheelBlock(true, p, CogwheelVariant.COPPER))
            .initialProperties(SharedProperties::copperMetal)
            .properties(p -> p.mapColor(MapColor.DIRT))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> INDUSTRIAL_IRON_COGWHEEL = CoggedUp.REGISTRATE.block("industrial_iron_cogwheel", (p) -> new CustomCogwheelBlock(false, p, CogwheelVariant.INDUSTRIAL_IRON))
            .initialProperties(SharedProperties::netheriteMetal)
            .properties(p -> p.mapColor(MapColor.STONE))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> LARGE_INDUSTRIAL_IRON_COGWHEEL = CoggedUp.REGISTRATE.block("large_industrial_iron_cogwheel", (p) -> new CustomCogwheelBlock(true, p, CogwheelVariant.INDUSTRIAL_IRON))
            .initialProperties(SharedProperties::netheriteMetal)
            .properties(p -> p.mapColor(MapColor.DIRT))
            .transform(BlockStressDefaults.setNoImpact())
            .transform(TagGen.pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
            .item(CogwheelBlockItem::new)
            .build()
            .register();

    //Encased Variants:

    public static final BlockEntry<CustomEncasedCogwheelBlock> ANDESITE_ENCASED_ANDESITE_COGWHEEL = CoggedUp.REGISTRATE.block
            ("andesite_encased_andesite_cogwheel", p -> new CustomEncasedCogwheelBlock(p, false, AllBlocks.ANDESITE_CASING::get))
            .transform(EncasingRegistry.addVariantTo(AddonBlocks.ANDESITE_COGWHEEL))
            .transform(BuilderTransformers.encasedCogwheel("andesite", () -> AllSpriteShifts.ANDESITE_CASING))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.ANDESITE_CASING,
                    Couple.create(AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    public static void register() {
        CoggedUp.LOGGER.info("Blocks have been registered!");
    }
}
