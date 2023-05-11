package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S19PacketEntityHeadLook;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S19PacketEntityHeadLookMapper extends ServerPacketMapper<S19PacketEntityHeadLook>
{
	public S19PacketEntityHeadLookMapper()
	{
		super(S19PacketEntityHeadLook.class);
	}

	@Override
	public void parsePacketToMap(final S19PacketEntityHeadLook packet, final Map<String, String> valueMap)
	{
		this.addEntityToMap(packet.getEntity(this.getWorld()), valueMap);
		valueMap.put("Yaw", String.valueOf(packet.getYaw()));
	}
}
