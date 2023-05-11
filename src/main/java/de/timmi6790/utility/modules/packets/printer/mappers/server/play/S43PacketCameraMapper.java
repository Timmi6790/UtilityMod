package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S43PacketCamera;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S43PacketCameraMapper extends ServerPacketMapper<S43PacketCamera>
{
	public S43PacketCameraMapper()
	{
		super(S43PacketCamera.class);
	}

	@Override
	public void parsePacketToMap(final S43PacketCamera packet, final Map<String, String> valueMap)
	{
		valueMap.put("EntityId", String.valueOf(packet.entityId));
	}
}
