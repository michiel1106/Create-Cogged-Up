package com.lampboy.cogged_up.content.custom_cogwheel.encased;

import com.lampboy.cogged_up.CoggedUpBETypes;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedShaftBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class CustomEncasedShaftBlock extends EncasedShaftBlock {
    public CustomEncasedShaftBlock(Properties properties, Supplier<Block> casing) {
        super(properties, casing);
    }

    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return CoggedUpBETypes.CUSTOM_ENCASED_SHAFT_BE.get();
    }
}
