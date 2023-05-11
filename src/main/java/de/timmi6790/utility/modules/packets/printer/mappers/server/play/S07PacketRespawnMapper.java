package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S07PacketRespawn;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;

public class S07PacketRespawnMapper extends ServerPacketMapper<S07PacketRespawn>
{
	public S07PacketRespawnMapper()
	{
		super(S07PacketRespawn.class);
	}

	@Override
	public void parsePacketToMap(final S07PacketRespawn packet, final Map<String, String> valueMap)
	{
		valueMap.put("DimensionId", String.valueOf(packet.getDimensionID()));
		valueMap.put("Difficulty", EnumUtils.getPrettyName(packet.getDifficulty()));
		valueMap.put("GameType", EnumUtils.getPrettyName(packet.getGameType()));
		valueMap.put("WorldType", packet.getWorldType().getWorldTypeName());
	}
}
