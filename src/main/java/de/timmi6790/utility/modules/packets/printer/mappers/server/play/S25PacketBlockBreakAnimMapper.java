package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S25PacketBlockBreakAnim;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S25PacketBlockBreakAnimMapper extends ServerPacketMapper<S25PacketBlockBreakAnim>
{
	public S25PacketBlockBreakAnimMapper()
	{
		super(S25PacketBlockBreakAnim.class);
	}

	@Override
	public void parsePacketToMap(final S25PacketBlockBreakAnim packet, final Map<String, String> valueMap)
	{
		valueMap.put("EntityId", String.valueOf(packet.getBreakerId()));
		valueMap.put("Position", this.toString(packet.getPosition()));
		valueMap.put("Progress", String.valueOf(packet.getProgress()));
	}
}
