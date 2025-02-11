package com.lampboy.cogged_up.mixin.create;

import com.simibubi.create.content.kinetics.KineticNetwork;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(KineticNetwork.class)
public class KineticNetworkMixin {

//    @Inject(at = @At("TAIL"), method = "calculateStress")
//    private void coggedUp$calculateStress(CallbackInfoReturnable<Float> cir) {
//        System.out.println("Method Injected!");
//    }

}
