package com.lampboy.cogged_up.mixin.create;

import com.lampboy.cogged_up.content.custom_cogwheel.CustomCogwheelBlock;
import com.lampboy.cogged_up.content.custom_cogwheel.IHasMaterial;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.KineticNetwork;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.CogWheelBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogwheelBlock;
import com.simibubi.create.foundation.utility.Iterate;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.text.DecimalFormat;
import java.util.*;

@Mixin(KineticNetwork.class)
public class KineticNetworkMixin {

    @Shadow(remap = false) public Map<KineticBlockEntity, Float> members;

    /**
     * This method redirects the stress calculation result with stress reduction applied.
     * See {@link com.lampboy.cogged_up.content.custom_cogwheel.CogwheelVariant} for stress reduction factor for each variant.
     * */
    @Inject(at = @At("TAIL"), method = "calculateStress", remap = false, cancellable = true)
    private void coggedUp$calculateStress(CallbackInfoReturnable<Float> cir) {
        if (cir.getReturnValue() == 0.0f) return;

        float totalStressReductionFactor = 0;
        List<Object> cogList = new ArrayList<>();

        for (Map.Entry<KineticBlockEntity, Float> entry : this.members.entrySet()) {
            KineticBlockEntity be = entry.getKey();
            Block block = be.getBlockState().getBlock();

//            if (isDecorativeCog(((BracketedKineticBlockEntity) be))) continue;

            if ((block instanceof CogWheelBlock) || (block instanceof EncasedCogwheelBlock)) {
                cogList.add(block);
            }
        }

        if (cogList.isEmpty()) return;

        for (Object block : cogList) {
            int size = cogList.size();

            if (block instanceof IHasMaterial hasMaterial) {
                totalStressReductionFactor +=
                        hasMaterial.getMaterial().stressReductionFactor/size;
                continue;
            }

            totalStressReductionFactor += (float) 1 /size;
        }

        //Rounds number in case of float point precision issue.
        cir.setReturnValue(
                ((float) (Math.floor((cir.getReturnValue() / totalStressReductionFactor) * 100) / 100))
        );
    }

    //it sorts out cogwheel that are not connected to any cogwheels.
    private boolean isDecorativeCog(BracketedKineticBlockEntity be) {
        Level level = be.getLevel();
        if (level == null) return false;
        BlockState blockState = be.getBlockState();
        CogWheelBlock block = ((CogWheelBlock) be.getBlockState().getBlock());

        Set<BlockPos> adjacentPositions = new HashSet<>();
        Set<BlockPos> diagonalPositions = new HashSet<>();

        for (Direction direction: Direction.values()) {
            if (direction.getAxis() == blockState.getValue(RotatedPillarBlock.AXIS)) continue;

            adjacentPositions.add(be.getBlockPos().relative(direction));

            for (Direction direction2: Direction.values()) {
                if (direction.getAxis() == blockState.getValue(RotatedPillarBlock.AXIS)) continue;
                if (direction.getAxis() == direction2.getAxis()) continue;

                diagonalPositions.add(be.getBlockPos().relative(direction).relative(direction2));
            }
        }

        if (block.isSmallCog()) {
            for (BlockPos pos: adjacentPositions) {
                BlockState adjacentBlockState = level.getBlockState(pos);
                if (ICogWheel.isSmallCog(adjacentBlockState) &&
                        adjacentBlockState.getValue(RotatedPillarBlock.AXIS)
                                == blockState.getValue(RotatedPillarBlock.AXIS)) {
                    return false;
                }
            }
            for (BlockPos pos: diagonalPositions) {
                BlockState diagonalBlockState = level.getBlockState(pos);
                if (ICogWheel.isLargeCog(diagonalBlockState) &&
                        diagonalBlockState.getValue(RotatedPillarBlock.AXIS)
                                == blockState.getValue(RotatedPillarBlock.AXIS)) {
                    return false;
                }
            }
        }

        for (BlockPos pos: diagonalPositions) {
            BlockState diagonalBlockState = level.getBlockState(pos);
            if (ICogWheel.isSmallCog(diagonalBlockState) &&
                    diagonalBlockState.getValue(RotatedPillarBlock.AXIS)
                            == blockState.getValue(RotatedPillarBlock.AXIS)) {
                return false;
            }
        }

        return true;
    }
}
