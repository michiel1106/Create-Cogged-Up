package com.lampboy.cogged_up.content.custom_cogwheel;

import com.lampboy.cogged_up.CoggedUpBETypes;
import com.simibubi.create.AllShapes;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.CogWheelBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CustomCogwheelBlock extends CogWheelBlock implements IHasMaterial {
    public CogwheelVariant material;

    public CustomCogwheelBlock(boolean large, Properties properties, CogwheelVariant material) {
        super(large, properties);



        this.material = material;
    }



    @Override
    public CogwheelVariant getMaterial() {
        return material;
    }

    @Override
    public BlockEntityType<? extends KineticBlockEntity> getBlockEntityType() {
        return CoggedUpBETypes.CUSTOM_COGWHEEL_BE.get();
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand,
                                 BlockHitResult ray) {
        if (player.isShiftKeyDown() || !player.mayBuild())
            return InteractionResult.PASS;

        ItemStack heldItem = player.getItemInHand(hand);
        InteractionResult result = tryEncase(state, world, pos, heldItem, player, hand, ray);
        if (result.consumesAction())
            return result;

        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        if (material != CogwheelVariant.INDUSTRIAL_IRON) {
            return super.getShape(state, worldIn, pos, context);
        }

        if (isLargeCog()) {
            return shape(cuboid(0, 2, 0, 16, 14, 16))
                    .add(AllShapes.SIX_VOXEL_POLE.get(Direction.Axis.Y))
                    .forAxis().get(state.getValue(AXIS));
        }

        return shape(cuboid(2, 2, 2, 14, 14, 14))
                .add(AllShapes.SIX_VOXEL_POLE.get(Direction.Axis.Y))
                .forAxis().get(state.getValue(AXIS));
    }


    /**
     * Methods below are copied from {@link AllShapes}
     * */
    private static AllShapes.Builder shape(VoxelShape shape) {

        return new AllShapes.Builder(shape);
    }

    private static AllShapes.Builder shape(double x1, double y1, double z1, double x2, double y2, double z2) {
        return shape(cuboid(x1, y1, z1, x2, y2, z2));
    }

    private static VoxelShape cuboid(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Block.box(x1, y1, z1, x2, y2, z2);
    }
}
