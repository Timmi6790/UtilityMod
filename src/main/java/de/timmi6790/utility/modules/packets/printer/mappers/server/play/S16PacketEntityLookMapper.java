package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S14PacketEntity;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S16PacketEntityLookMapper extends ServerPacketMapper<S14PacketEntity.S16PacketEntityLook>
{
	public S16PacketEntityLookMapper()
	{
		super(S14PacketEntity.S16PacketEntityLook.class);
	}

	@Override
	public void parsePacketToMap(final S14PacketEntity.S16PacketEntityLook packet, final Map<String, String> valueMap)
	{
		this.addEntityToMap(packet.getEntity(this.getWorld()), valueMap);
		valueMap.put("Look", this.join(packet.func_149066_f(), packet.func_149063_g()));
		valueMap.put("OnGround", String.valueOf(packet.getOnGround()));
		valueMap.put("Field", String.valueOf(packet.func_149063_g()));
	}
}
