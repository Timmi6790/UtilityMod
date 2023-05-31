package de.timmi6790.utility.mixin.entity;

import de.timmi6790.utility.modules.config.Config;
import de.timmi6790.utility.modules.config.reference.ConfigReference;
import de.timmi6790.utility.utils.MessageBuilder;
import lombok.extern.log4j.Log4j2;
import net.minecraft.entity.DataWatcher;
import net.minecraft.util.EnumChatFormatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Log4j2
@Mixin(DataWatcher.class)
public abstract class MixinDataWatcher {
    private static final long ERROR_MESSAGE_COOLDOWN = TimeUnit.SECONDS.toMillis(20);
    private static final ConfigReference<Boolean> ENABLED = new ConfigReference<>(Config::isDataWatcherCrashFix);
    private static long lastErrorMessage = 0;

    private static void sendErrorMessage(final String exceptedType, final Object watchedObject) {
        final String stackTrace = Arrays.toString(new Throwable().getStackTrace()).replace(',', '\n');
        log.warn(
                "[DataWatcher] Expected {} but found {} with value \"{}\"\n{}",
                exceptedType,
                watchedObject.getClass(),
                watchedObject,
                stackTrace
        );

        if (System.currentTimeMillis() - lastErrorMessage >= ERROR_MESSAGE_COOLDOWN) {
            lastErrorMessage = System.currentTimeMillis();
            MessageBuilder.of("AntiCrash> ", EnumChatFormatting.BLUE)
                    .addMessage("Prevented a data watcher crash. Check your console for more information.", EnumChatFormatting.GRAY)
                    .sendToPlayer();
        }
    }

    private boolean isCorrectType(final Object watchedObject, final Class<?> expectedType) {
        if (!watchedObject.getClass().equals(expectedType)) {
            sendErrorMessage(expectedType.getTypeName(), watchedObject);
            return false;
        }

        return true;
    }

    @Shadow
    protected abstract DataWatcher.WatchableObject getWatchedObject(int id);


    /**
     * Tries to prevent client crashes on invalid data watcher types and print a warning.
     * Inject at the return of the method to allow other mods to inject before us.
     */
    @Inject(method = "getWatchableObjectInt", at = @At("RETURN"), cancellable = true)
    public void getWatchableObjectInt(final int id, final CallbackInfoReturnable<Integer> cir) {
        if (!ENABLED.getOrDefault(false)) {
            return;
        }

        final Object watchedObject = this.getWatchedObject(id).getObject();
        if (this.isCorrectType(watchedObject, Integer.class)) {
            return;
        }

        // Try to prevent crash on invalid data watcher types
        if (watchedObject instanceof Number) {
            cir.setReturnValue(((Number) watchedObject).intValue());
        } else {
            cir.setReturnValue(Integer.parseInt(watchedObject.toString()));
        }
    }

    /**
     * Tries to prevent client crashes on invalid data watcher types and print a warning.
     * Inject at the return of the method to allow other mods to inject before us.
     */
    @Inject(method = "getWatchableObjectFloat", at = @At("RETURN"), cancellable = true)
    public void getWatchableObjectFloat(final int id, final CallbackInfoReturnable<Float> cir) {
        if (!ENABLED.getOrDefault(false)) {
            return;
        }

        final Object watchedObject = this.getWatchedObject(id).getObject();
        if (this.isCorrectType(watchedObject, Float.class)) {
            return;
        }

        // Try to prevent crash on invalid data watcher types
        if (watchedObject instanceof Number) {
            cir.setReturnValue(((Number) watchedObject).floatValue());
        } else {
            cir.setReturnValue(Float.parseFloat(watchedObject.toString()));
        }
    }

    /**
     * Tries to prevent client crashes on invalid data watcher types and print a warning.
     * Inject at the return of the method to allow other mods to inject before us.
     */
    @Inject(method = "getWatchableObjectByte", at = @At("RETURN"), cancellable = true)
    public void getWatchableObjectByte(final int id, final CallbackInfoReturnable<Byte> cir) {
        if (!ENABLED.getOrDefault(false)) {
            return;
        }

        final Object watchedObject = this.getWatchedObject(id).getObject();
        if (this.isCorrectType(watchedObject, Byte.class)) {
            return;
        }

        // Try to prevent crash on invalid data watcher types
        if (watchedObject instanceof Number) {
            cir.setReturnValue(((Number) watchedObject).byteValue());
        } else {
            cir.setReturnValue(Byte.parseByte(watchedObject.toString()));
        }
    }

    /**
     * Tries to prevent client crashes on invalid data watcher types and print a warning.
     * Inject at the return of the method to allow other mods to inject before us.
     */
    @Inject(method = "getWatchableObjectShort", at = @At("RETURN"), cancellable = true)
    public void getWatchableObjectShort(final int id, final CallbackInfoReturnable<Short> cir) {
        if (!ENABLED.getOrDefault(false)) {
            return;
        }

        final Object watchedObject = this.getWatchedObject(id).getObject();
        if (this.isCorrectType(watchedObject, Short.class)) {
            return;
        }

        // Try to prevent crash on invalid data watcher types
        if (watchedObject instanceof Number) {
            cir.setReturnValue(((Number) watchedObject).shortValue());
        } else {
            cir.setReturnValue(Short.parseShort(watchedObject.toString()));
        }
    }

    /**
     * Tries to prevent client crashes on invalid data watcher types and print a warning.
     * Inject at the return of the method to allow other mods to inject before us.
     */
    @Inject(method = "getWatchableObjectString", at = @At("RETURN"), cancellable = true)
    public void getWatchableObjectString(final int id, final CallbackInfoReturnable<String> cir) {
        if (!ENABLED.getOrDefault(false)) {
            return;
        }

        final Object watchedObject = this.getWatchedObject(id).getObject();
        if (this.isCorrectType(watchedObject, String.class)) {
            return;
        }

        // Try to prevent crash on invalid data watcher types
        cir.setReturnValue(String.valueOf(watchedObject));
    }
}
