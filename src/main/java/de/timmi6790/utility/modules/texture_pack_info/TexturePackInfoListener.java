package de.timmi6790.utility.modules.texture_pack_info;

import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.network.play.server.S48PacketResourcePackSend;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import de.timmi6790.utility.ListenerComponent;
import de.timmi6790.utility.modules.config.Config;
import de.timmi6790.utility.modules.config.reference.ConfigReference;
import de.timmi6790.utility.modules.core.events.PacketReceiveEvent;
import de.timmi6790.utility.utils.MessageBuilder;
import de.timmi6790.utility.utils.MinecraftTimeUnit;

public class TexturePackInfoListener implements ListenerComponent
{
	private final ConfigReference<Boolean> enabled = new ConfigReference<>(Config::isShowTexturePackInformation);

	@SubscribeEvent
	public void onTexturePackPacket(final PacketReceiveEvent.Pre event)
	{
		if (!(event.getPacket() instanceof S48PacketResourcePackSend))
		{
			return;
		}

		if (!this.enabled.getOrDefault(false))
		{
			return;
		}

		final S48PacketResourcePackSend packetResourcePackSend = (S48PacketResourcePackSend) event.getPacket();
		MessageBuilder.of("TpInfo> ", EnumChatFormatting.BLUE)
				.addMessage("Received texturepack from ", EnumChatFormatting.GRAY)
				.addMessage(
						MessageBuilder.of(packetResourcePackSend.getURL(), EnumChatFormatting.YELLOW)
								.addClickEvent(ClickEvent.Action.OPEN_URL, packetResourcePackSend.getURL())
								.addHoverEvent(HoverEvent.Action.SHOW_TEXT, MessageBuilder.of("Open URL", EnumChatFormatting.GRAY)))
				.addMessage(" with hash ", EnumChatFormatting.GRAY)
				.addMessage(packetResourcePackSend.getHash(), EnumChatFormatting.YELLOW)
				.sendToPlayerDelayed(0, MinecraftTimeUnit.TICKS);
	}
}
