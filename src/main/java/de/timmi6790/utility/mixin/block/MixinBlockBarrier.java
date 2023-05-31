package de.timmi6790.utility.mixin.block;

import de.timmi6790.utility.modules.config.Config;
import de.timmi6790.utility.modules.config.reference.ConfigReference;
import net.minecraft.block.BlockBarrier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBarrier.class)
public class MixinBlockBarrier {
    private final ConfigReference<Boolean> enabled = new ConfigReference<>(Config::isVisibleBarrierBlock);

    @Inject(method = "getRenderType", at = @At("HEAD"), cancellable = true)
    public void getRenderType(final CallbackInfoReturnable<Integer> cir) {
        if (enabled.getOrDefault(false)) {
            cir.setReturnValue(3);
        }
    }
}
