package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S37PacketStatistics;
import net.minecraft.stats.StatBase;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S37PacketStatisticsMapper extends ServerPacketMapper<S37PacketStatistics>
{
	public S37PacketStatisticsMapper()
	{
		super(S37PacketStatistics.class);
	}

	@Override
	public void parsePacketToMap(final S37PacketStatistics packet, final Map<String, String> valueMap)
	{
		for (final Map.Entry<StatBase, Integer> entry : packet.func_148974_c().entrySet())
		{
			valueMap.put(String.valueOf(entry.getKey().statId), String.valueOf(entry.getValue()));
		}
	}
}
