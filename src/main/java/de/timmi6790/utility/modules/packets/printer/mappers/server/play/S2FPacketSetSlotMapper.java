package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S2FPacketSetSlot;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S2FPacketSetSlotMapper extends ServerPacketMapper<S2FPacketSetSlot>
{
	public S2FPacketSetSlotMapper()
	{
		super(S2FPacketSetSlot.class);
	}

	@Override
	public void parsePacketToMap(final S2FPacketSetSlot packet, final Map<String, String> valueMap)
	{
		valueMap.put("WindowId", String.valueOf(packet.func_149175_c()));
		valueMap.put("SlotId", String.valueOf(packet.func_149173_d()));
		valueMap.put("Item", packet.func_149174_e().getItem().getRegistryName());
	}
}
