package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import java.util.Map;

import net.minecraft.network.play.client.C11PacketEnchantItem;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;


public class C11PacketEnchantItemMapper extends ClientPacketMapper<C11PacketEnchantItem>
{
	public C11PacketEnchantItemMapper()
	{
		super(C11PacketEnchantItem.class);
	}

	@Override
	public void parsePacketToMap(final C11PacketEnchantItem packet, final Map<String, String> valueMap)
	{
		valueMap.put("WindowId", String.valueOf(packet.getWindowId()));
		valueMap.put("ButtonId", String.valueOf(packet.getButton()));
	}
}
