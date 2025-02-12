package com.lampboy.cogged_up.mixin.create;

import com.simibubi.create.content.kinetics.KineticNetwork;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(KineticNetwork.class)
public class KineticNetworkMixin {

    @Inject(at = @At("TAIL"), method = "calculateStress", remap = false, cancellable = true)
    private void coggedUp$calculateStress(CallbackInfoReturnable<Float> cir) {
//        cir.setReturnValue(cir.getReturnValue()/2);
        System.out.println(cir.getReturnValue());
    }
}
