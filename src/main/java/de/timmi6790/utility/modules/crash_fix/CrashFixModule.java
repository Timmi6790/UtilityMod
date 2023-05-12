package de.timmi6790.utility.modules.crash_fix;

import net.minecraft.util.EnumChatFormatting;

import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.modules.crash_fix.fixes.CrashPotionFix;
import de.timmi6790.utility.utils.MessageBuilder;

public class CrashFixModule extends BaseModule
{
	public CrashFixModule()
	{
		registerListenerComponents(
				new CrashPotionFix(this)
		);
	}

	public void sendPreventionMessage(MessageBuilder message)
	{
		MessageBuilder.of("AntiCrash> ", EnumChatFormatting.BLUE)
				.addMessage(message)
				.sendToPlayer();
	}
}
