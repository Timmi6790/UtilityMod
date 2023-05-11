package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import java.util.Map;

import net.minecraft.network.play.client.C01PacketChatMessage;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;


public class C01PacketChatMessageMapper extends ClientPacketMapper<C01PacketChatMessage>
{
	public C01PacketChatMessageMapper()
	{
		super(C01PacketChatMessage.class);
	}

	@Override
	public void parsePacketToMap(final C01PacketChatMessage packet, final Map<String, String> valueMap)
	{
		valueMap.put("Message", packet.getMessage());
	}
}
