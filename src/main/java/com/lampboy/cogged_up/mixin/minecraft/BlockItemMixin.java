package com.lampboy.cogged_up.mixin.minecraft;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public class BlockItemMixin {
//    @Inject(method = "place", at = @At("HEAD"), cancellable = true)
//    private void coggedUp$fixDeployerPlacement(BlockPlaceContext pContext, CallbackInfoReturnable<InteractionResult> cir) {
//        Level level = pContext.getLevel();
//        if (level.isClientSide) return;
//
//        System.out.println("hello mixin!");
//    }
}
