package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S02PacketChat;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S02PacketChatMapper extends ServerPacketMapper<S02PacketChat>
{
	public S02PacketChatMapper()
	{
		super(S02PacketChat.class);
	}

	@Override
	public void parsePacketToMap(final S02PacketChat packet, final Map<String, String> valueMap)
	{
		valueMap.put("Type", String.valueOf(packet.getType()));
		valueMap.put("Chat", packet.getChatComponent().getUnformattedText());
	}
}
