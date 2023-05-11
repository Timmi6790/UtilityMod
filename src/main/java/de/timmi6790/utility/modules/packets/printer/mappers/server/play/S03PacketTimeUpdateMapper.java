package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S03PacketTimeUpdate;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S03PacketTimeUpdateMapper extends ServerPacketMapper<S03PacketTimeUpdate>
{
	public S03PacketTimeUpdateMapper()
	{
		super(S03PacketTimeUpdate.class);
	}

	@Override
	public void parsePacketToMap(final S03PacketTimeUpdate packet, final Map<String, String> valueMap)
	{
		valueMap.put("TotalWorldTime", String.valueOf(packet.getTotalWorldTime()));
		valueMap.put("WorldTime", String.valueOf(packet.getWorldTime()));
	}
}
