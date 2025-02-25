package com.lampboy.cogged_up.content.custom_cogwheel.encased;

import com.jozufozu.flywheel.api.InstanceData;
import com.jozufozu.flywheel.api.Instancer;
import com.jozufozu.flywheel.api.Material;
import com.jozufozu.flywheel.api.MaterialManager;
import com.jozufozu.flywheel.core.PartialModel;
import com.jozufozu.flywheel.util.transform.TransformStack;
import com.lampboy.cogged_up.content.custom_cogwheel.CogwheelVariant;
import com.lampboy.cogged_up.content.custom_cogwheel.IHasMaterial;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityInstance;
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.foundation.render.AllMaterialSpecs;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Optional;

public class CustomEncasedCogwheelBEInstance extends KineticBlockEntityInstance<KineticBlockEntity> {
    public CustomEncasedCogwheelBEInstance(MaterialManager materialManager, KineticBlockEntity blockEntity) {
        super(materialManager, blockEntity);

        Block block = blockEntity.getBlockState().getBlock();

        large = ICogWheel.isLargeCog(block);

        if (block instanceof IHasMaterial hasMaterial) {
            material = hasMaterial.getMaterial();
            return;
        }

        //sets material as default in case it doesn't have material for some reason.
        material = CogwheelVariant.WOOD;
    }

    private final boolean large;
    private final CogwheelVariant material;

    protected RotatingData rotatingModel;
    protected Optional<RotatingData> rotatingTopShaft;
    protected Optional<RotatingData> rotatingBottomShaft;

    @Override
    public void init() {
        rotatingModel = setup(getCogModel().createInstance());

        Block block = blockState.getBlock();
        if (!(block instanceof IRotate))
            return;

        IRotate def = (IRotate) block;
        rotatingTopShaft = Optional.empty();
        rotatingBottomShaft = Optional.empty();

        for (Direction d : Iterate.directionsInAxis(axis)) {
            if (!def.hasShaftTowards(blockEntity.getLevel(), blockEntity.getBlockPos(), blockState, d))
                continue;
            RotatingData data = setup(getRotatingMaterial().getModel(AllPartialModels.SHAFT_HALF, blockState, d)
                    .createInstance());
            if (large)
                data.setRotationOffset(BracketedKineticBlockEntityRenderer.getShaftAngleOffset(axis, pos));
            if (d.getAxisDirection() == Direction.AxisDirection.POSITIVE)
                rotatingTopShaft = Optional.of(data);
            else
                rotatingBottomShaft = Optional.of(data);
        }
    }

    protected Instancer<RotatingData> getCogModel() {
        BlockState referenceState = blockEntity.getBlockState();
        Direction facing =
                Direction.fromAxisAndDirection(referenceState.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);

        PartialModel partial = large
                ? material.getLargeShaftlessPartialModel()
                : material.getSmallShaftlessPartialModel();
        Material<RotatingData> rotatingMaterial = material == CogwheelVariant.COPPER
                ? materialManager.defaultCutout().material(AllMaterialSpecs.ROTATING)
                : materialManager.defaultSolid().material(AllMaterialSpecs.ROTATING);

        return rotatingMaterial.getModel(partial, referenceState, facing, () -> {
            PoseStack poseStack = new PoseStack();
            TransformStack.cast(poseStack)
                    .centre()
                    .rotateToFace(facing)
                    .multiply(Axis.XN.rotationDegrees(90))
                    .unCentre();
            return poseStack;
        });
    }

    @Override
    public void update() {
        updateRotation(rotatingModel);
        rotatingTopShaft.ifPresent(this::updateRotation);
        rotatingBottomShaft.ifPresent(this::updateRotation);
    }

    @Override
    public void updateLight() {
        relight(pos, rotatingModel);
        rotatingTopShaft.ifPresent(d -> relight(pos, d));
        rotatingBottomShaft.ifPresent(d -> relight(pos, d));
    }

    @Override
    public void remove() {
        rotatingModel.delete();
        rotatingTopShaft.ifPresent(InstanceData::delete);
        rotatingBottomShaft.ifPresent(InstanceData::delete);
    }
}
