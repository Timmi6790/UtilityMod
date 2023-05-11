package de.timmi6790.utility.modules.packets.printer.mappers.server.status;

import java.util.Map;

import net.minecraft.network.status.server.S01PacketPong;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S01PacketPongMapper extends ServerPacketMapper<S01PacketPong>
{
	public S01PacketPongMapper()
	{
		super(S01PacketPong.class);
	}

	@Override
	public void parsePacketToMap(final S01PacketPong packet, final Map<String, String> valueMap)
	{
		valueMap.put("ServerTime", String.valueOf(packet.clientTime));
	}
}
