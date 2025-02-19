package com.lampboy.cogged_up.mixin.create;

import com.lampboy.cogged_up.CoggedUpBlocks;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.kinetics.simpleRelays.CogWheelBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CogWheelBlock.class)
public abstract class CogWheelBlockMixin {

    @Shadow(remap = false)
    boolean isLarge;

    @Shadow(remap = false)
    public static CogWheelBlock large(BlockBehaviour.Properties properties) {
        return null;
    }

    @Inject(at = @At("HEAD"), method = "use", remap = false, cancellable = true)
    private void coggedUp$use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand,
                              BlockHitResult ray, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack heldItem = player.getItemInHand(hand);
        if (heldItem.getItem() == AllBlocks.COPPER_CASING.asItem()) {

            if (isLarge) {
                CoggedUpBlocks.COPPER_ENCASED_LARGE_COGWHEEL.get()
                        .handleEncasing(state, world, pos, heldItem, player, hand, ray);
            } else {
                CoggedUpBlocks.COPPER_ENCASED_COGWHEEL.get()
                        .handleEncasing(state, world, pos, heldItem, player, hand, ray);
            }

            coggedUp$playEncasingSound(world, pos);
            cir.setReturnValue(InteractionResult.SUCCESS);
        }
    }

    @Unique
    private void coggedUp$playEncasingSound(Level world, BlockPos pos) {
        BlockState newState = world.getBlockState(pos);
        SoundType soundType = newState.getSoundType();
        world.playSound(null, pos, soundType.getPlaceSound(), SoundSource.BLOCKS, (soundType.getVolume() + 1.0F) / 2.0F, soundType.getPitch() * 0.8F);
    }
}
