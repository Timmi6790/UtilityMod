package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S10PacketSpawnPainting;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;

public class S10PacketSpawnPaintingMapper extends ServerPacketMapper<S10PacketSpawnPainting>
{
	public S10PacketSpawnPaintingMapper()
	{
		super(S10PacketSpawnPainting.class);
	}

	@Override
	public void parsePacketToMap(final S10PacketSpawnPainting packet, final Map<String, String> valueMap)
	{
		valueMap.put("EntityId", String.valueOf(packet.getEntityID()));
		valueMap.put("Position", this.toString(packet.getPosition()));
		valueMap.put("Facing", EnumUtils.getPrettyName(packet.getFacing()));
		valueMap.put("Title", packet.getTitle());
	}
}
