package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.network.play.server.S27PacketExplosion;
import net.minecraft.util.BlockPos;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S27PacketExplosionMapper extends ServerPacketMapper<S27PacketExplosion>
{
	public S27PacketExplosionMapper()
	{
		super(S27PacketExplosion.class);
	}

	@Override
	public void parsePacketToMap(final S27PacketExplosion packet, final Map<String, String> valueMap)
	{
		valueMap.put("Position", this.join(packet.getX(), packet.getY(), packet.getZ()));
		valueMap.put("Strength", String.valueOf(packet.getStrength()));

		final List<String> positions = new ArrayList<>();
		for (final BlockPos position : packet.getAffectedBlockPositions())
		{
			positions.add(this.toString(position));
		}
		valueMap.put("AffectedBlocks", this.join(positions));

		valueMap.put("Motion", this.join(packet.func_149149_c(), packet.func_149144_d(), packet.func_149147_e()));
	}
}
