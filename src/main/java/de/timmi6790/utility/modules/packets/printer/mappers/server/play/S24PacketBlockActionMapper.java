package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S24PacketBlockAction;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S24PacketBlockActionMapper extends ServerPacketMapper<S24PacketBlockAction>
{
	public S24PacketBlockActionMapper()
	{
		super(S24PacketBlockAction.class);
	}

	@Override
	public void parsePacketToMap(final S24PacketBlockAction packet, final Map<String, String> valueMap)
	{
		valueMap.put("Position", this.toString(packet.getBlockPosition()));
		valueMap.put("Block", packet.getBlockType().getRegistryName());
		valueMap.put("Instrument", String.valueOf(packet.getData1()));
		valueMap.put("Pitch", String.valueOf(packet.getData2()));
	}
}
