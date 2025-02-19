package com.lampboy.cogged_up.content.custom_cogwheel;

import com.jozufozu.flywheel.api.Instancer;
import com.jozufozu.flywheel.api.Material;
import com.jozufozu.flywheel.api.MaterialManager;
import com.jozufozu.flywheel.core.PartialModel;
import com.jozufozu.flywheel.util.transform.TransformStack;
import com.lampboy.cogged_up.CoggedUpPartialModels;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.base.SingleRotatingInstance;
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.foundation.render.AllMaterialSpecs;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;

public class CustomCogwheelBEInstance extends SingleRotatingInstance<BracketedKineticBlockEntity> {
    public CustomCogwheelBEInstance(MaterialManager materialManager, BracketedKineticBlockEntity blockEntity) {
        super(materialManager, blockEntity);
    }

    /**
     * Methods are copied and modified from {@link com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityInstance}
     * */
    protected RotatingData additionalShaft;

    @Override
    public void init() {
        super.init();

        //initializes when it is large cog.

        if (!ICogWheel.isLargeCog(blockEntity.getBlockState()))
            return;

        // Large cogs sometimes have to offset their teeth by 11.25 degrees in order to
        // mesh properly

        float speed = blockEntity.getSpeed();
        Direction.Axis axis = KineticBlockEntityRenderer.getRotationAxisOf(blockEntity);
        BlockPos pos = blockEntity.getBlockPos();
        float offset = BracketedKineticBlockEntityRenderer.getShaftAngleOffset(axis, pos);
        Direction facing = Direction.fromAxisAndDirection(axis, Direction.AxisDirection.POSITIVE);
        Instancer<RotatingData> half = getRotatingMaterial().getModel(AllPartialModels.COGWHEEL_SHAFT, blockState,
                facing, () -> this.rotateToAxis(axis));

        additionalShaft = setup(half.createInstance(), speed);
        additionalShaft.setRotationOffset(offset);
    }

    @Override
    protected Instancer<RotatingData> getModel() {
        if (!ICogWheel.isLargeCog(blockEntity.getBlockState()))
            return super.getModel();

        Direction.Axis axis = KineticBlockEntityRenderer.getRotationAxisOf(blockEntity);
        Direction facing = Direction.fromAxisAndDirection(axis, Direction.AxisDirection.POSITIVE);


        Block block = blockEntity.getBlockState().getBlock();

        //Gets default cogwheel model in case the instance is different
        if (!(block instanceof CustomCogwheelBlock)) {
            return getRotatingMaterial()
                    .getModel(AllPartialModels.SHAFTLESS_LARGE_COGWHEEL, blockState, facing, () -> this.rotateToAxis(axis));
        }

        CogwheelVariant material = ((CustomCogwheelBlock) block).getMaterial();

        if (material == null) {
            return getRotatingMaterial()
                    .getModel(AllPartialModels.SHAFTLESS_LARGE_COGWHEEL, blockState, facing, () -> this.rotateToAxis(axis));
        }

        PartialModel partialModel = ICogWheel.isLargeCog(block)
                ? material.getLargeShaftlessPartialModel()
                : material.getSmallShaftlessPartialModel();

        Material<RotatingData> rotatingMaterial = material == CogwheelVariant.COPPER
                ? materialManager.defaultCutout().material(AllMaterialSpecs.ROTATING)
                : materialManager.defaultSolid().material(AllMaterialSpecs.ROTATING);

        return rotatingMaterial.getModel(partialModel, blockState, facing, () -> this.rotateToAxis(axis));
    }

    private PoseStack rotateToAxis(Direction.Axis axis) {
        Direction facing = Direction.fromAxisAndDirection(axis, Direction.AxisDirection.POSITIVE);
        PoseStack poseStack = new PoseStack();
        TransformStack.cast(poseStack)
                .centre()
                .rotateToFace(facing)
                .multiply(Axis.XN.rotationDegrees(-90))
                .unCentre();
        return poseStack;
    }

    @Override
    public void update() {
        super.update();
        if (additionalShaft != null) {
            updateRotation(additionalShaft);
            additionalShaft.setRotationOffset(BracketedKineticBlockEntityRenderer.getShaftAngleOffset(axis, pos));
        }
    }

    @Override
    public void updateLight() {
        super.updateLight();
        if (additionalShaft != null)
            relight(pos, additionalShaft);
    }

    @Override
    public void remove() {
        super.remove();
        if (additionalShaft != null)
            additionalShaft.delete();
    }
}
