package de.timmi6790.utility.modules.packets.printer.mappers.client.status;

import java.util.Map;

import net.minecraft.network.status.client.C01PacketPing;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;


public class C01PacketPingMapper extends ClientPacketMapper<C01PacketPing>
{
	public C01PacketPingMapper()
	{
		super(C01PacketPing.class);
	}

	@Override
	public void parsePacketToMap(final C01PacketPing packet, final Map<String, String> valueMap)
	{
		valueMap.put("ClientTime", String.valueOf(packet.getClientTime()));
	}
}
