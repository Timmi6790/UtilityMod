package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S2BPacketChangeGameState;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S2BPacketChangeGameStateMapper extends ServerPacketMapper<S2BPacketChangeGameState>
{
	public S2BPacketChangeGameStateMapper()
	{
		super(S2BPacketChangeGameState.class);
	}

	@Override
	public void parsePacketToMap(final S2BPacketChangeGameState packet, final Map<String, String> valueMap)
	{
		valueMap.put("State", String.valueOf(packet.getGameState()));
		valueMap.put("Field", String.valueOf(packet.func_149137_d()));
	}
}
