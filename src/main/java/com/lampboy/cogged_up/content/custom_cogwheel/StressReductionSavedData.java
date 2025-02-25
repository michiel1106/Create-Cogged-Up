package com.lampboy.cogged_up.content.custom_cogwheel;

import com.simibubi.create.foundation.utility.NBTHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.ArrayList;
import java.util.List;

public class StressReductionSavedData extends SavedData {

    public StressReductionSavedData() {
        this.isFirstTime = true;
    }

    public boolean isFirstTime;

    public float wood;
    public float andesite;
    public float brass;
    public float copper;
    public float industrial;

    private static StressReductionSavedData of(float wood, float andesite, float brass, float copper, float industrial, boolean isFirstTime) {
        StressReductionSavedData data = new StressReductionSavedData();
        data.wood = wood;
        data.andesite = andesite;
        data.brass = brass;
        data.copper = copper;
        data.industrial = industrial;
        data.isFirstTime = isFirstTime;

        return data;
    }

    public void setToDefault() {
        wood = CogwheelVariant.WOOD.getStressReductionFactor();
        andesite = CogwheelVariant.ANDESITE.getStressReductionFactor();
        brass = CogwheelVariant.BRASS.getStressReductionFactor();
        copper = CogwheelVariant.COPPER.getStressReductionFactor();
        industrial = CogwheelVariant.INDUSTRIAL_IRON.getStressReductionFactor();
    }

    public void disable() {
        wood = 1;
        andesite = 1;
        brass = 1;
        copper = 1;
        industrial = 1;
    }



    @Override
    public CompoundTag save(CompoundTag nbt) {
        CompoundTag stressReduction = new CompoundTag();
        stressReduction.putFloat("wood", wood);
        stressReduction.putFloat("andesite", andesite);
        stressReduction.putFloat("brass", brass);
        stressReduction.putFloat("copper", copper);
        stressReduction.putFloat("industrial", industrial);

        nbt.put("stressReduction", stressReduction);
        nbt.putBoolean("isFirstTime", isFirstTime);
        return nbt;
    }

    public static StressReductionSavedData load(CompoundTag nbt) {
        CompoundTag stressReduction = nbt.getCompound("stressReduction");
        StressReductionSavedData data = StressReductionSavedData.of(
                stressReduction.getFloat("wood"),
                stressReduction.getFloat("andesite"),
                stressReduction.getFloat("brass"),
                stressReduction.getFloat("copper"),
                stressReduction.getFloat("industrial"),
                nbt.getBoolean("isFirstTime")
        );
        return data;
    }
}
