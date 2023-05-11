package de.timmi6790.utility.modules.packets.printer.mappers.server.login;

import java.util.Map;

import net.minecraft.network.login.server.S03PacketEnableCompression;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S03PacketEnableCompressionMapper extends ServerPacketMapper<S03PacketEnableCompression>
{
	public S03PacketEnableCompressionMapper()
	{
		super(S03PacketEnableCompression.class);
	}

	@Override
	public void parsePacketToMap(final S03PacketEnableCompression packet, final Map<String, String> valueMap)
	{
		valueMap.put("CompressionThreshold", String.valueOf(packet.getCompressionTreshold()));
	}
}
