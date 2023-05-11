package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import java.util.Map;

import net.minecraft.network.play.client.C09PacketHeldItemChange;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;


public class C09PacketHeldItemChangeMapper extends ClientPacketMapper<C09PacketHeldItemChange>
{
	public C09PacketHeldItemChangeMapper()
	{
		super(C09PacketHeldItemChange.class);
	}

	@Override
	public void parsePacketToMap(final C09PacketHeldItemChange packet, final Map<String, String> valueMap)
	{
		valueMap.put("SlotId", String.valueOf(packet.getSlotId()));
	}
}
