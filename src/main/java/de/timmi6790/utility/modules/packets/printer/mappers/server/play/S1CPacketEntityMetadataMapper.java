package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S1CPacketEntityMetadata;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S1CPacketEntityMetadataMapper extends ServerPacketMapper<S1CPacketEntityMetadata>
{
	public S1CPacketEntityMetadataMapper()
	{
		super(S1CPacketEntityMetadata.class);
	}

	@Override
	public void parsePacketToMap(final S1CPacketEntityMetadata packet, final Map<String, String> valueMap)
	{
		valueMap.put("EntityId", String.valueOf(packet.getEntityId()));
		valueMap.put("WatchableObjects", this.toString(packet.func_149376_c()));
	}
}
