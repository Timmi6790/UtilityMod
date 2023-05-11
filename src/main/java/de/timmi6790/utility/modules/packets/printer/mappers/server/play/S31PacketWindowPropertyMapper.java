package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S31PacketWindowProperty;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S31PacketWindowPropertyMapper extends ServerPacketMapper<S31PacketWindowProperty>
{
	public S31PacketWindowPropertyMapper()
	{
		super(S31PacketWindowProperty.class);
	}

	@Override
	public void parsePacketToMap(final S31PacketWindowProperty packet, final Map<String, String> valueMap)
	{
		valueMap.put("WindowId", String.valueOf(packet.getWindowId()));
		valueMap.put("Index", String.valueOf(packet.getVarIndex()));
		valueMap.put("Value", String.valueOf(packet.getVarValue()));
	}
}
