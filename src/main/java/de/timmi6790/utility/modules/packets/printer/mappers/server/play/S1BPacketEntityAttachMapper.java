package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S1BPacketEntityAttach;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S1BPacketEntityAttachMapper extends ServerPacketMapper<S1BPacketEntityAttach>
{
	public S1BPacketEntityAttachMapper()
	{
		super(S1BPacketEntityAttach.class);
	}

	@Override
	public void parsePacketToMap(final S1BPacketEntityAttach packet, final Map<String, String> valueMap)
	{
		valueMap.put("EntityId", String.valueOf(packet.getEntityId()));
		valueMap.put("VehicleEntityId", String.valueOf(packet.getVehicleEntityId()));
		valueMap.put("Leash", String.valueOf(packet.getLeash()));
	}
}
