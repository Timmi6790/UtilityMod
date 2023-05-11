package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import java.util.Map;

import net.minecraft.network.play.client.C00PacketKeepAlive;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;


public class C00PacketKeepAliveMapper extends ClientPacketMapper<C00PacketKeepAlive>
{
	public C00PacketKeepAliveMapper()
	{
		super(C00PacketKeepAlive.class);
	}

	@Override
	public void parsePacketToMap(final C00PacketKeepAlive packet, final Map<String, String> valueMap)
	{
		valueMap.put("Key", String.valueOf(packet.getKey()));
	}
}
