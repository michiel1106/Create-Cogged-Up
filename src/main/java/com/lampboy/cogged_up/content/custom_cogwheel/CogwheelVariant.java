package com.lampboy.cogged_up.content.custom_cogwheel;

public enum CogwheelVariant {
    ANDESITE(2),
    BRASS(4),
    COPPER(3),
    INDUSTRIAL_IRON(6);

    public float stressReductionFactor;

    CogwheelVariant(float stressReductionFactor) {
        this.stressReductionFactor = stressReductionFactor;
    }
}
