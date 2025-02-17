package com.lampboy.cogged_up;

import com.jozufozu.flywheel.core.PartialModel;

public class AddonPartialModels {

    public static final PartialModel

    ANDESITE_COGWHEEL_SHAFTLESS = block("andesite_cogwheel/shaftless"),
    BRASS_COGWHEEL_SHAFTLESS = block("brass_cogwheel/shaftless"),
    COPPER_COGWHEEL_SHAFTLESS = block("copper_cogwheel/shaftless"),

    LARGE_ANDESITE_COGWHEEL_SHAFTLESS = block("large_andesite_cogwheel/shaftless"),
    LARGE_BRASS_COGWHEEL_SHAFTLESS = block("large_brass_cogwheel/shaftless"),
    LARGE_COPPER_COGWHEEL_SHAFTLESS = block("large_copper_cogwheel/shaftless"),
    LARGE_INDUSTRIAL_IRON_COGWHEEL_SHAFTLESS = block("large_industrial_iron_cogwheel/shaftless");

    private static PartialModel block(String path) {
        return new PartialModel(CoggedUp.asResource("block/"+path));
    }

    public static void register() {}
}
