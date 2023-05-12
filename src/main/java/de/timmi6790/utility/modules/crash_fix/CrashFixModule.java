package de.timmi6790.utility.modules.crash_fix;

import net.minecraft.util.EnumChatFormatting;

import de.timmi6790.utility.Module;
import de.timmi6790.utility.modules.crash_fix.fixes.CrashPotionFix;
import de.timmi6790.utility.utils.EventUtils;
import de.timmi6790.utility.utils.MessageBuilder;

public class CrashFixModule implements Module
{
	private final CrashPotionFix potionFix;

	public CrashFixModule()
	{
		this.potionFix = new CrashPotionFix(this);
	}

	@Override
	public void registerEvents()
	{
		EventUtils.registerEvents(this.potionFix);
	}

	@Override
	public void disable()
	{
		EventUtils.unRegisterEvents(this.potionFix);
	}

	public void sendPreventionMessage(MessageBuilder message)
	{
		MessageBuilder.of("AntiCrash> ", EnumChatFormatting.BLUE)
				.addMessage(message)
				.sendToPlayer();
	}
}
