package com.lampboy.cogged_up.content.custom_cogwheel.encased;

import com.lampboy.cogged_up.AddonBETypes;
import com.simibubi.create.content.contraptions.ITransformableBlock;
import com.simibubi.create.content.decoration.encasing.EncasedBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import com.simibubi.create.content.schematics.requirement.ISpecialBlockItemRequirement;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class CustomEncasedCogwheelBlock extends EncasedCogwheelBlock
        implements ICogWheel, IBE<SimpleKineticBlockEntity>, ISpecialBlockItemRequirement, ITransformableBlock, EncasedBlock {
    public CustomEncasedCogwheelBlock(Properties properties, boolean large, Supplier<Block> casing) {
        super(properties, large, casing);
    }

    @Override
    public BlockEntityType<? extends SimpleKineticBlockEntity> getBlockEntityType() {
        return AddonBETypes.CUSTOM_ENCASED_COGWHEEL_BE.get();
    }
}
