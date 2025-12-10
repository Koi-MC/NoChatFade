package koi.pond.nochatfade.mixin;

import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.gui.hud.ChatHud.OpacityRule;
//import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChatHud.OpacityRule.class)
public interface ChatHudMixin {
    /**
     * Disables any chat fading behavior
     */
    @Inject(method = "timeBased", at = @At("HEAD"), cancellable = true)
    private static void timeBased(int currentTick, CallbackInfoReturnable<OpacityRule> cir) {
        /* Vanilla behavior
        return (line) -> {
            int j = currentTick - line.addedTime();
            double d = (double)j / (double)200.0F;
            d = (double)1.0F - d;
            d *= (double)10.0F;
            d = MathHelper.clamp(d, (double)0.0F, (double)1.0F);
            d *= d;
            return (float)d;
        };
        */

        //Instead of calculating opacity based on time/tick, ignore time and force full visibility always
        //(The "line" object is: net.minecraft.client.gui.hud.ChatHudLine.Visible line)
        cir.setReturnValue((line) -> 1.0F);
    }
}
