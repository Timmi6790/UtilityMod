package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S11PacketSpawnExperienceOrb;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S11PacketSpawnExperienceOrbMapper extends ServerPacketMapper<S11PacketSpawnExperienceOrb>
{
	public S11PacketSpawnExperienceOrbMapper()
	{
		super(S11PacketSpawnExperienceOrb.class);
	}

	@Override
	public void parsePacketToMap(final S11PacketSpawnExperienceOrb packet, final Map<String, String> valueMap)
	{
		valueMap.put("EntityId", String.valueOf(packet.getEntityID()));
		valueMap.put("Position", this.join(packet.getX(), packet.getY(), packet.getZ()));
		valueMap.put("ExpValue", String.valueOf(packet.getXPValue()));
	}
}
