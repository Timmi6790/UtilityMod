package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S48PacketResourcePackSend;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S48PacketResourcePackSendMapper extends ServerPacketMapper<S48PacketResourcePackSend>
{
	public S48PacketResourcePackSendMapper()
	{
		super(S48PacketResourcePackSend.class);
	}

	@Override
	public void parsePacketToMap(final S48PacketResourcePackSend packet, final Map<String, String> valueMap)
	{
		valueMap.put("Url", packet.getURL());
		valueMap.put("Hash", packet.getHash());
	}
}
