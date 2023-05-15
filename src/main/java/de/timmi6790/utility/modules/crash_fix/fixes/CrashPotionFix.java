package de.timmi6790.utility.modules.crash_fix.fixes;

import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import de.timmi6790.utility.ListenerComponent;
import de.timmi6790.utility.modules.config.Config;
import de.timmi6790.utility.modules.config.reference.ConfigReference;
import de.timmi6790.utility.modules.core.events.PacketReceiveEvent;
import de.timmi6790.utility.modules.crash_fix.CrashFixModule;
import de.timmi6790.utility.utils.MessageBuilder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CrashPotionFix implements ListenerComponent
{
	private final CrashFixModule module;
	private final ConfigReference<Boolean> enabled = new ConfigReference<>(Config::isPotionIdCrashFix);

	@SubscribeEvent
	public void onPotionPacket(final PacketReceiveEvent.Pre event)
	{
		if (event.getPacket() instanceof S1DPacketEntityEffect && enabled.getOrDefault(false))
		{
			// Check if the server is sending an invalid potion effect that could crash the client
			final S1DPacketEntityEffect entityEffect = (S1DPacketEntityEffect) event.getPacket();
			final int potionId = (entityEffect.getEffectId() & 0xff);
			if (potionId > Potion.potionTypes.length || Potion.potionTypes[potionId] == null)
			{
				module.sendPreventionMessage(
						MessageBuilder.of("Canceled invalid potion packet. PotionID:", EnumChatFormatting.GRAY)
								.addMessage(String.valueOf(potionId), EnumChatFormatting.YELLOW)
				);
				event.setCanceled(true);
			}
		}
	}
}
