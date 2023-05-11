package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S3CPacketUpdateScore;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;

public class S3CPacketUpdateScoreMapper extends ServerPacketMapper<S3CPacketUpdateScore>
{
	public S3CPacketUpdateScoreMapper()
	{
		super(S3CPacketUpdateScore.class);
	}

	@Override
	public void parsePacketToMap(final S3CPacketUpdateScore packet, final Map<String, String> valueMap)
	{
		valueMap.put("PlayerName", packet.getPlayerName());
		valueMap.put("ObjectName", packet.getObjectiveName());
		valueMap.put("Value", String.valueOf(packet.getScoreValue()));
		valueMap.put("Action", EnumUtils.getPrettyName(packet.getScoreAction()));
	}
}
