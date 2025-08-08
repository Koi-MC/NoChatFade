package koi.pond.nochatfade.mixin;

import net.minecraft.client.gui.hud.ChatHud;
//import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatHud.class)
public class ChatHudMixin {
    /**
     * Disables any chat fading behavior
     */
    @Inject(method = "getMessageOpacityMultiplier", at = @At("HEAD"), cancellable = true)
    private static void getMessageOpacityMultiplier(int age, CallbackInfoReturnable<Double> cir) {
        /* Vanilla behavior
        double d = (double)age / (double)200.0F;
        d = (double)1.0F - d;
        d *= (double)10.0F;
        d = MathHelper.clamp(d, (double)0.0F, (double)1.0F);
        d *= d;
         */

        double d = 1.0D; //Always force full opacity

        cir.setReturnValue(d);
        //return d;
    }
}
