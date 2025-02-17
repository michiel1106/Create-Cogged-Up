package com.lampboy.cogged_up;

import com.simibubi.create.Create;
import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import com.simibubi.create.foundation.block.render.SpriteShiftEntry;
import com.simibubi.create.foundation.block.render.SpriteShifter;
import com.simibubi.create.foundation.utility.Couple;
import net.minecraft.world.level.block.state.properties.WoodType;

public class AddonSpriteShifts {

    public static final CTSpriteShiftEntry
    COPPER_ENCASED_COGWHEEL_SIDE = vertical("copper_encased_cogwheel_side"),
    COPPER_ENCASED_COGWHEEL_OTHERSIDE = horizontal("copper_encased_cogwheel_side");

    /**
     * Methods below are copied from {@link com.simibubi.create.AllSpriteShifts}
     * */

    private static CTSpriteShiftEntry horizontal(String name) {
        return getCT(AllCTTypes.HORIZONTAL, name);
    }

    private static CTSpriteShiftEntry vertical(String name) {
        return getCT(AllCTTypes.VERTICAL, name);
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
        return CTSpriteShifter.getCT(type, CoggedUp.asResource("block/" + blockTextureName),
                CoggedUp.asResource("block/" + connectedTextureName + "_connected"));
    }

    private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
        return getCT(type, blockTextureName, blockTextureName);
    }
}
