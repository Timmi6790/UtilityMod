package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S0EPacketSpawnObject;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S0EPacketSpawnObjectMapper extends ServerPacketMapper<S0EPacketSpawnObject>
{
	public S0EPacketSpawnObjectMapper()
	{
		super(S0EPacketSpawnObject.class);
	}

	@Override
	public void parsePacketToMap(final S0EPacketSpawnObject packet, final Map<String, String> valueMap)
	{
		valueMap.put("EntityId", String.valueOf(packet.getEntityID()));
		valueMap.put("TypeId", String.valueOf(packet.getType()));
		valueMap.put("Field", String.valueOf(packet.func_149009_m()));
		valueMap.put("Position", this.join(packet.getX(), packet.getY(), packet.getZ()));
		valueMap.put("Look", this.join(packet.getYaw(), packet.getPitch()));
		valueMap.put("Speed", this.join(packet.getSpeedX(), packet.getSpeedY(), packet.getSpeedZ()));
	}
}
