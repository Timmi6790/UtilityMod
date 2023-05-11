package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S3FPacketCustomPayload;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S3FPacketCustomPayloadMapper extends ServerPacketMapper<S3FPacketCustomPayload>
{
	public S3FPacketCustomPayloadMapper()
	{
		super(S3FPacketCustomPayload.class);
	}

	@Override
	public void parsePacketToMap(final S3FPacketCustomPayload packet, final Map<String, String> valueMap)
	{
		valueMap.put("Channel", packet.getChannelName());
	}
}
