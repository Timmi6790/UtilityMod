package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S34PacketMaps;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S34PacketMapsMapper extends ServerPacketMapper<S34PacketMaps>
{
	public S34PacketMapsMapper()
	{
		super(S34PacketMaps.class);
	}

	@Override
	public void parsePacketToMap(final S34PacketMaps packet, final Map<String, String> valueMap)
	{
		valueMap.put("MapId", String.valueOf(packet.getMapId()));
		valueMap.put("Info", "Not fully implemented");
	}
}
