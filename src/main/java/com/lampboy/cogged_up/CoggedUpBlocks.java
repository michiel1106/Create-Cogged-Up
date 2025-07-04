package com.lampboy.cogged_up;

import com.lampboy.cogged_up.content.custom_cogwheel.CogwheelVariant;
import com.lampboy.cogged_up.content.custom_cogwheel.CustomCogwheelBlock;
import com.lampboy.cogged_up.content.custom_cogwheel.encased.CustomEncasedCogwheelBlock;
import com.lampboy.cogged_up.content.custom_cogwheel.encased.CustomEncasedShaftBlock;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.content.decoration.encasing.EncasingRegistry;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogCTBehaviour;
import com.simibubi.create.foundation.data.*;
import com.simibubi.create.foundation.utility.Couple;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;

public class CoggedUpBlocks {

    public static final BlockEntry<Block> SAMPLE_BLOCK = CoggedUp.REGISTRATE.block("sample_block", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .item()
            .build()
            .register();

    public static final BlockEntry<CustomCogwheelBlock> ANDESITE_COGWHEEL = CoggedUp.REGISTRATE.block("andesite_cogwheel", (p) -> new CustomCogwheelBlock(false, p, CogwheelVariant.ANDESITE))
            .transform(CoggedUpBuilderTransformers.customCogwheel(CogwheelVariant.ANDESITE))
            .register();

    public static final BlockEntry<CustomCogwheelBlock> LARGE_ANDESITE_COGWHEEL = CoggedUp.REGISTRATE.block("large_andesite_cogwheel", (p) -> new CustomCogwheelBlock(true, p, CogwheelVariant.ANDESITE))
            .transform(CoggedUpBuilderTransformers.customCogwheel(CogwheelVariant.ANDESITE))
            .register();

    public static final BlockEntry<CustomCogwheelBlock> BRASS_COGWHEEL = CoggedUp.REGISTRATE.block("brass_cogwheel", (p) -> new CustomCogwheelBlock(false, p, CogwheelVariant.BRASS))
            .transform(CoggedUpBuilderTransformers.customCogwheel(CogwheelVariant.BRASS))
            .register();

    public static final BlockEntry<CustomCogwheelBlock> LARGE_BRASS_COGWHEEL = CoggedUp.REGISTRATE.block("large_brass_cogwheel", (p) -> new CustomCogwheelBlock(true, p, CogwheelVariant.BRASS))
            .transform(CoggedUpBuilderTransformers.customCogwheel(CogwheelVariant.BRASS))
            .register();

    public static final BlockEntry<CustomCogwheelBlock> COPPER_COGWHEEL = CoggedUp.REGISTRATE.block("copper_cogwheel", (p) -> new CustomCogwheelBlock(false, p, CogwheelVariant.COPPER))
            .transform(CoggedUpBuilderTransformers.customCogwheel(CogwheelVariant.COPPER))
            .register();

    public static final BlockEntry<CustomCogwheelBlock> LARGE_COPPER_COGWHEEL = CoggedUp.REGISTRATE.block("large_copper_cogwheel", (p) -> new CustomCogwheelBlock(true, p, CogwheelVariant.COPPER))
            .transform(CoggedUpBuilderTransformers.customCogwheel(CogwheelVariant.COPPER))
            .register();

    public static final BlockEntry<CustomCogwheelBlock> INDUSTRIAL_IRON_COGWHEEL = CoggedUp.REGISTRATE.block("industrial_iron_cogwheel", (p) -> new CustomCogwheelBlock(false, p, CogwheelVariant.INDUSTRIAL_IRON))
            .transform(CoggedUpBuilderTransformers.customCogwheel(CogwheelVariant.INDUSTRIAL_IRON))
            .register();

    public static final BlockEntry<CustomCogwheelBlock> LARGE_INDUSTRIAL_IRON_COGWHEEL = CoggedUp.REGISTRATE.block("large_industrial_iron_cogwheel", (p) -> new CustomCogwheelBlock(true, p, CogwheelVariant.INDUSTRIAL_IRON))
            .transform(CoggedUpBuilderTransformers.customCogwheel(CogwheelVariant.INDUSTRIAL_IRON))
            .register();

    //Encased Variants:

    public static final BlockEntry<CustomEncasedCogwheelBlock> ANDESITE_ENCASED_ANDESITE_COGWHEEL = CoggedUp.REGISTRATE.block
            ("andesite_encased_andesite_cogwheel", p -> new CustomEncasedCogwheelBlock(p, false, AllBlocks.ANDESITE_CASING::get, CogwheelVariant.ANDESITE))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.ANDESITE_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("andesite", () -> AllSpriteShifts.ANDESITE_CASING, CogwheelVariant.ANDESITE))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.ANDESITE_CASING,
                    Couple.create(AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    public static final BlockEntry<CustomEncasedCogwheelBlock> ANDESITE_ENCASED_LARGE_ANDESITE_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("andesite_encased_large_andesite_cogwheel", p -> new CustomEncasedCogwheelBlock(p, true, AllBlocks.ANDESITE_CASING::get, CogwheelVariant.ANDESITE))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.LARGE_ANDESITE_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("andesite", () -> AllSpriteShifts.ANDESITE_CASING, CogwheelVariant.ANDESITE))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.ANDESITE_CASING,
                    Couple.create(AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();



    public static final BlockEntry<CustomEncasedCogwheelBlock> ANDESITE_ENCASED_BRASS_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("andesite_encased_brass_cogwheel", p -> new CustomEncasedCogwheelBlock(p, false, AllBlocks.ANDESITE_CASING::get, CogwheelVariant.BRASS))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.BRASS_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("andesite", () -> AllSpriteShifts.ANDESITE_CASING, CogwheelVariant.BRASS))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.ANDESITE_CASING,
                    Couple.create(AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    public static final BlockEntry<CustomEncasedCogwheelBlock> ANDESITE_ENCASED_LARGE_BRASS_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("andesite_encased_large_brass_cogwheel", p -> new CustomEncasedCogwheelBlock(p, true, AllBlocks.ANDESITE_CASING::get, CogwheelVariant.BRASS))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.LARGE_BRASS_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("andesite", () -> AllSpriteShifts.ANDESITE_CASING, CogwheelVariant.BRASS))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.ANDESITE_CASING,
                    Couple.create(AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    //

    public static final BlockEntry<CustomEncasedCogwheelBlock> ANDESITE_ENCASED_COPPER_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("andesite_encased_copper_cogwheel", p -> new CustomEncasedCogwheelBlock(p, false, AllBlocks.ANDESITE_CASING::get, CogwheelVariant.COPPER))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.COPPER_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("andesite", () -> AllSpriteShifts.ANDESITE_CASING, CogwheelVariant.COPPER))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.ANDESITE_CASING,
                    Couple.create(AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    public static final BlockEntry<CustomEncasedCogwheelBlock> ANDESITE_ENCASED_LARGE_COPPER_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("andesite_encased_large_copper_cogwheel", p -> new CustomEncasedCogwheelBlock(p, true, AllBlocks.ANDESITE_CASING::get, CogwheelVariant.COPPER))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.LARGE_COPPER_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("andesite", () -> AllSpriteShifts.ANDESITE_CASING, CogwheelVariant.COPPER))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.ANDESITE_CASING,
                    Couple.create(AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.ANDESITE_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    //

    // Brass Encasing

    public static final BlockEntry<CustomEncasedCogwheelBlock> BRASS_ENCASED_ANDESITE_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("brass_encased_andesite_cogwheel", p -> new CustomEncasedCogwheelBlock(p, false, AllBlocks.BRASS_CASING::get, CogwheelVariant.ANDESITE))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.ANDESITE_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("brass", () -> AllSpriteShifts.BRASS_CASING, CogwheelVariant.ANDESITE))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.BRASS_CASING,
                    Couple.create(AllSpriteShifts.BRASS_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.BRASS_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    public static final BlockEntry<CustomEncasedCogwheelBlock> BRASS_ENCASED_LARGE_ANDESITE_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("brass_encased_large_andesite_cogwheel", p -> new CustomEncasedCogwheelBlock(p, true, AllBlocks.BRASS_CASING::get, CogwheelVariant.ANDESITE))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.LARGE_ANDESITE_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("brass", () -> AllSpriteShifts.BRASS_CASING, CogwheelVariant.ANDESITE))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.BRASS_CASING,
                    Couple.create(AllSpriteShifts.BRASS_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.BRASS_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    //

    public static final BlockEntry<CustomEncasedCogwheelBlock> BRASS_ENCASED_BRASS_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("brass_encased_brass_cogwheel", p -> new CustomEncasedCogwheelBlock(p, false, AllBlocks.BRASS_CASING::get, CogwheelVariant.BRASS))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.BRASS_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("brass", () -> AllSpriteShifts.BRASS_CASING, CogwheelVariant.BRASS))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.BRASS_CASING,
                    Couple.create(AllSpriteShifts.BRASS_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.BRASS_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    public static final BlockEntry<CustomEncasedCogwheelBlock> BRASS_ENCASED_LARGE_BRASS_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("brass_encased_large_brass_cogwheel", p -> new CustomEncasedCogwheelBlock(p, true, AllBlocks.BRASS_CASING::get, CogwheelVariant.BRASS))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.LARGE_BRASS_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("brass", () -> AllSpriteShifts.BRASS_CASING, CogwheelVariant.BRASS))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.BRASS_CASING,
                    Couple.create(AllSpriteShifts.BRASS_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.BRASS_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    //

    public static final BlockEntry<CustomEncasedCogwheelBlock> BRASS_ENCASED_COPPER_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("brass_encased_copper_cogwheel", p -> new CustomEncasedCogwheelBlock(p, false, AllBlocks.BRASS_CASING::get, CogwheelVariant.COPPER))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.COPPER_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("brass", () -> AllSpriteShifts.BRASS_CASING, CogwheelVariant.COPPER))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.BRASS_CASING,
                    Couple.create(AllSpriteShifts.BRASS_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.BRASS_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    public static final BlockEntry<CustomEncasedCogwheelBlock> BRASS_ENCASED_LARGE_COPPER_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("brass_encased_large_copper_cogwheel", p -> new CustomEncasedCogwheelBlock(p, true, AllBlocks.BRASS_CASING::get, CogwheelVariant.COPPER))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.LARGE_COPPER_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("brass", () -> AllSpriteShifts.BRASS_CASING, CogwheelVariant.COPPER))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.BRASS_CASING,
                    Couple.create(AllSpriteShifts.BRASS_ENCASED_COGWHEEL_SIDE,
                            AllSpriteShifts.BRASS_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    //

    // Copper Encasing

    public static final BlockEntry<CustomEncasedCogwheelBlock> COPPER_ENCASED_ANDESITE_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("copper_encased_andesite_cogwheel", p -> new CustomEncasedCogwheelBlock(p, false, AllBlocks.COPPER_CASING::get, CogwheelVariant.ANDESITE))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.ANDESITE_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("copper", () -> AllSpriteShifts.COPPER_CASING, CogwheelVariant.ANDESITE))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.COPPER_CASING,
                    Couple.create(CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_SIDE,
                            CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    public static final BlockEntry<CustomEncasedCogwheelBlock> COPPER_ENCASED_LARGE_ANDESITE_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("copper_encased_large_andesite_cogwheel", p -> new CustomEncasedCogwheelBlock(p, true, AllBlocks.COPPER_CASING::get, CogwheelVariant.ANDESITE))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.LARGE_ANDESITE_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("copper", () -> AllSpriteShifts.COPPER_CASING, CogwheelVariant.ANDESITE))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.COPPER_CASING,
                    Couple.create(CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_SIDE,
                            CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    //

    public static final BlockEntry<CustomEncasedCogwheelBlock> COPPER_ENCASED_BRASS_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("copper_encased_brass_cogwheel", p -> new CustomEncasedCogwheelBlock(p, false, AllBlocks.COPPER_CASING::get, CogwheelVariant.BRASS))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.BRASS_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("copper", () -> AllSpriteShifts.COPPER_CASING, CogwheelVariant.BRASS))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.COPPER_CASING,
                    Couple.create(CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_SIDE,
                            CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    public static final BlockEntry<CustomEncasedCogwheelBlock> COPPER_ENCASED_LARGE_BRASS_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("copper_encased_large_brass_cogwheel", p -> new CustomEncasedCogwheelBlock(p, true, AllBlocks.COPPER_CASING::get, CogwheelVariant.BRASS))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.LARGE_BRASS_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("copper", () -> AllSpriteShifts.COPPER_CASING, CogwheelVariant.BRASS))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.COPPER_CASING,
                    Couple.create(CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_SIDE,
                            CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    //

    public static final BlockEntry<CustomEncasedCogwheelBlock> COPPER_ENCASED_COPPER_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("copper_encased_copper_cogwheel", p -> new CustomEncasedCogwheelBlock(p, false, AllBlocks.COPPER_CASING::get, CogwheelVariant.COPPER))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.COPPER_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("copper", () -> AllSpriteShifts.COPPER_CASING, CogwheelVariant.COPPER))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.COPPER_CASING,
                    Couple.create(CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_SIDE,
                            CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    public static final BlockEntry<CustomEncasedCogwheelBlock> COPPER_ENCASED_LARGE_COPPER_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("copper_encased_large_copper_cogwheel", p -> new CustomEncasedCogwheelBlock(p, true, AllBlocks.COPPER_CASING::get, CogwheelVariant.COPPER))
            .transform(EncasingRegistry.addVariantTo(CoggedUpBlocks.LARGE_COPPER_COGWHEEL))
            .transform(CoggedUpBuilderTransformers.encasedCogwheel("copper", () -> AllSpriteShifts.COPPER_CASING, CogwheelVariant.COPPER))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.COPPER_CASING,
                    Couple.create(CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_SIDE,
                            CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    // Copper encased variants of vanilla Create's cogs

    public static final BlockEntry<CustomEncasedShaftBlock> COPPER_ENCASED_SHAFT = CoggedUp.REGISTRATE.block
                    ("copper_encased_shaft", p -> new CustomEncasedShaftBlock(p, AllBlocks.COPPER_CASING::get))
            .transform(BuilderTransformers.encasedShaft("copper", () -> AllSpriteShifts.COPPER_CASING))
            .transform(axeOrPickaxe())
            .register();

    public static final BlockEntry<CustomEncasedCogwheelBlock> COPPER_ENCASED_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("copper_encased_cogwheel", p -> new CustomEncasedCogwheelBlock(p, false, AllBlocks.COPPER_CASING::get, CogwheelVariant.WOOD))
            .transform(BuilderTransformers.encasedCogwheel("copper", () -> AllSpriteShifts.COPPER_CASING))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.COPPER_CASING,
                    Couple.create(CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_SIDE,
                            CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    public static final BlockEntry<CustomEncasedCogwheelBlock> COPPER_ENCASED_LARGE_COGWHEEL = CoggedUp.REGISTRATE.block
                    ("copper_encased_large_cogwheel", p -> new CustomEncasedCogwheelBlock(p, true, AllBlocks.COPPER_CASING::get, CogwheelVariant.WOOD))
            .transform(BuilderTransformers.encasedCogwheel("copper", () -> AllSpriteShifts.COPPER_CASING))
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCogCTBehaviour(AllSpriteShifts.COPPER_CASING,
                    Couple.create(CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_SIDE,
                            CoggedUpSpriteShifts.COPPER_ENCASED_COGWHEEL_OTHERSIDE))))
            .register();

    //

    public static void register() {
        CoggedUp.LOGGER.info("Blocks have been registered!");
    }
}
