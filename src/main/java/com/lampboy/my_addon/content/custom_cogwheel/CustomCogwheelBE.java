package com.lampboy.my_addon.content.custom_cogwheel;

import com.simibubi.create.content.contraptions.StructureTransform;
import com.simibubi.create.content.kinetics.KineticNetwork;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CustomCogwheelBE extends BracketedKineticBlockEntity {
    public CustomCogwheelBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void transform(StructureTransform transform) {
        super.transform(transform);
    }

    public void printNetwork() {
        if (level == null) return;

        if (level.isClientSide) return;

        KineticNetwork network = getOrCreateNetwork();

        level.players().get(0).sendSystemMessage(Component.literal(
                "Current network size:" + network.getSize()
                + "\n Current network stress impact:" + network.calculateStress()
        ));

        System.out.println(network.members);
    }
}
