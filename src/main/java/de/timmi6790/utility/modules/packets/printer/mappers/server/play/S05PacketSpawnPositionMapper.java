package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S05PacketSpawnPosition;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S05PacketSpawnPositionMapper extends ServerPacketMapper<S05PacketSpawnPosition>
{
	public S05PacketSpawnPositionMapper()
	{
		super(S05PacketSpawnPosition.class);
	}

	@Override
	public void parsePacketToMap(final S05PacketSpawnPosition packet, final Map<String, String> valueMap)
	{
		valueMap.put("Position", this.toString(packet.getSpawnPos()));
	}
}