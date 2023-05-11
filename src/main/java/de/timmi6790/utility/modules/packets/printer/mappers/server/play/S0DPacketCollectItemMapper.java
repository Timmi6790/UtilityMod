package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S0DPacketCollectItem;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S0DPacketCollectItemMapper extends ServerPacketMapper<S0DPacketCollectItem>
{
	public S0DPacketCollectItemMapper()
	{
		super(S0DPacketCollectItem.class);
	}

	@Override
	public void parsePacketToMap(final S0DPacketCollectItem packet, final Map<String, String> valueMap)
	{
		valueMap.put("EntityId", String.valueOf(packet.getEntityID()));
		valueMap.put("ItemEntityId", String.valueOf(packet.getCollectedItemEntityID()));
	}
}
