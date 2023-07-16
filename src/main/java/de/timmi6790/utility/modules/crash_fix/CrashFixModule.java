package de.timmi6790.utility.modules.crash_fix;

import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.modules.crash_fix.fixes.CrashPotionFix;
import de.timmi6790.utility.utils.MessageBuilder;
import net.minecraft.util.EnumChatFormatting;

public class CrashFixModule extends BaseModule {
    public CrashFixModule() {
        this.registerListenerComponents(new CrashPotionFix(this));
    }

    public void sendPreventionMessage(final MessageBuilder message) {
        MessageBuilder.of("AntiCrash> ", EnumChatFormatting.BLUE)
                .addMessage(message)
                .sendToPlayer();
    }
}
