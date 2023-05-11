package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S1EPacketRemoveEntityEffect;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S1EPacketRemoveEntityEffectMapper extends ServerPacketMapper<S1EPacketRemoveEntityEffect>
{
	public S1EPacketRemoveEntityEffectMapper()
	{
		super(S1EPacketRemoveEntityEffect.class);
	}

	@Override
	public void parsePacketToMap(final S1EPacketRemoveEntityEffect packet, final Map<String, String> valueMap)
	{
		valueMap.put("EntityId", String.valueOf(packet.getEntityId()));
		valueMap.put("EffectId", String.valueOf(packet.getEffectId()));
	}
}
