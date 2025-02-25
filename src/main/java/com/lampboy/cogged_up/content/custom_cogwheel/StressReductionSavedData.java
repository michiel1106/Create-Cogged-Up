package com.lampboy.cogged_up.content.custom_cogwheel;

import com.simibubi.create.foundation.utility.NBTHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.*;

public class StressReductionSavedData extends SavedData {

    public StressReductionSavedData() {
        this.factors = new HashMap<>();
        this.isFirstTime = true;
    }

    public boolean isFirstTime;

    public Map<String, Float> factors;

    public Optional<Float> getFactor(String name) {
        if (factors.containsKey(name)) {
            return Optional.of(factors.get(name));
        }
        return Optional.empty();
    }

    public Map<String, Float> getFactors() {
        return factors;
    }

    public boolean setFactor(String name, float factor) {
        if (factors.containsKey(name)) {
            factors.put(name, factor);
            return true;
        }
        return false;
    }

    private static StressReductionSavedData of(Map<String, Float> factors, boolean isFirstTime) {
        StressReductionSavedData data = new StressReductionSavedData();
        data.factors = factors;


        data.isFirstTime = isFirstTime;

        return data;
    }

    public void setToDefault() {
        for (CogwheelVariant material: CogwheelVariant.values()) {
            factors.put(material.getStringName(), material.getStressReductionFactor());
        }
    }

    public void disable() {
        for (CogwheelVariant material: CogwheelVariant.values()) {
            factors.put(material.getStringName(), 1f);
        }
    }

    @Override
    public CompoundTag save(CompoundTag nbt) {
        CompoundTag factorsNbt = new CompoundTag();

        for (Map.Entry<String, Float> entry: factors.entrySet()) {
            String name = entry.getKey();
            Float factor = entry.getValue();

            factorsNbt.putFloat(name, factor);
        }

        nbt.put("factors", factorsNbt);

        nbt.putBoolean("isFirstTime", isFirstTime);
        return nbt;
    }

    public static StressReductionSavedData load(CompoundTag nbt) {
        CompoundTag factorsNbt = nbt.getCompound("factors");
        Map<String, Float> factors = new HashMap<>();

        for (String name: factorsNbt.getAllKeys()) {
            float factor = factorsNbt.getFloat(name);

            factors.put(name, factor);
        }

        boolean isFirstTime = nbt.getBoolean("isFirstTime");

        return StressReductionSavedData.of(factors, isFirstTime);
    }
}
