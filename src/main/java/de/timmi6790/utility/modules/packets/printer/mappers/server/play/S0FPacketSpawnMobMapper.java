package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S0FPacketSpawnMob;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S0FPacketSpawnMobMapper extends ServerPacketMapper<S0FPacketSpawnMob>
{
	public S0FPacketSpawnMobMapper()
	{
		super(S0FPacketSpawnMob.class);
	}

	@Override
	public void parsePacketToMap(final S0FPacketSpawnMob packet, final Map<String, String> valueMap)
	{
		valueMap.put("EntityId", String.valueOf(packet.getEntityID()));
		valueMap.put("TypeId", String.valueOf(packet.getEntityType()));
		valueMap.put("HeadPitch", String.valueOf(packet.getHeadPitch()));
		valueMap.put("Position", this.join(packet.getX(), packet.getY(), packet.getZ()));
		valueMap.put("Look", this.join(packet.getYaw(), packet.getPitch()));
		valueMap.put("Speed", this.join(packet.getVelocityX(), packet.getVelocityY(), packet.getVelocityZ()));
	}
}
