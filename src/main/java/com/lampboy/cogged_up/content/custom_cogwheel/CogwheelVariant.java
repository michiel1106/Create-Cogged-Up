package com.lampboy.cogged_up.content.custom_cogwheel;

import com.jozufozu.flywheel.core.PartialModel;
import com.lampboy.cogged_up.CoggedUpPartialModels;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public enum CogwheelVariant {
    WOOD(1, SharedProperties::wooden,
            p -> p.mapColor(MapColor.DIRT),
            AllPartialModels.SHAFTLESS_COGWHEEL,
            AllPartialModels.SHAFTLESS_LARGE_COGWHEEL,
            "wood"),

    ANDESITE(2, SharedProperties::stone,
            p -> p.mapColor(MapColor.STONE),
            CoggedUpPartialModels.ANDESITE_COGWHEEL_SHAFTLESS,
            CoggedUpPartialModels.LARGE_ANDESITE_COGWHEEL_SHAFTLESS,
            "andesite"),

    BRASS(5, SharedProperties::softMetal,
            p -> p.mapColor(MapColor.TERRACOTTA_YELLOW),
            CoggedUpPartialModels.BRASS_COGWHEEL_SHAFTLESS,
            CoggedUpPartialModels.LARGE_BRASS_COGWHEEL_SHAFTLESS,
            "brass"),

    COPPER(3, SharedProperties::copperMetal,
            p -> p.mapColor(MapColor.COLOR_ORANGE),
            CoggedUpPartialModels.COPPER_COGWHEEL_SHAFTLESS,
            CoggedUpPartialModels.LARGE_COPPER_COGWHEEL_SHAFTLESS,
            "copper"),

    INDUSTRIAL_IRON(4, SharedProperties::softMetal,
            p -> p.mapColor(MapColor.COLOR_GRAY)
            .sound(SoundType.NETHERITE_BLOCK)
            .requiresCorrectToolForDrops(),
            //since small shaftless partial model of industrial cog doesn't have any usage
            //I have set it to just Create default cogwheel shaftless model. Can't be bothered to set it to null.
            AllPartialModels.SHAFTLESS_COGWHEEL,
            CoggedUpPartialModels.LARGE_INDUSTRIAL_IRON_COGWHEEL_SHAFTLESS,
            "industrial"
    );

    public final float stressReductionFactor;
    public final NonNullSupplier<Block> initialProperties;
    public final NonNullUnaryOperator<BlockBehaviour.Properties> properties;
    public final PartialModel smallShaftlessPartialModel;
    public final PartialModel largeShaftlessPartialModel;
    public final String stringName;

    CogwheelVariant(float stressReductionFactor,
                    NonNullSupplier<Block> initialProperties, NonNullUnaryOperator<BlockBehaviour.Properties> properties,
                    PartialModel smallShaftlessPartialModel, PartialModel largeShaftlessPartialModel, String stringName) {
        this.initialProperties = initialProperties;
        this.stressReductionFactor = stressReductionFactor;
        this.properties = properties;
        this.smallShaftlessPartialModel = smallShaftlessPartialModel;
        this.largeShaftlessPartialModel = largeShaftlessPartialModel;
        this.stringName = stringName;
    }

    public NonNullSupplier<Block> getInitialProperties() {
        return initialProperties;
    }

    public NonNullUnaryOperator<BlockBehaviour.Properties> getProperties() {
        return properties;
    }

    public float getStressReductionFactor() {
        return stressReductionFactor;
    }

    public PartialModel getLargeShaftlessPartialModel() {
        return largeShaftlessPartialModel;
    }

    public PartialModel getSmallShaftlessPartialModel() {
        return smallShaftlessPartialModel;
    }

    public String getStringName() {
        return stringName;
    }
}
