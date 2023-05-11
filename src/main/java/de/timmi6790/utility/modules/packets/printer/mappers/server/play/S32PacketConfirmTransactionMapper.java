package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S32PacketConfirmTransaction;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S32PacketConfirmTransactionMapper extends ServerPacketMapper<S32PacketConfirmTransaction>
{
	public S32PacketConfirmTransactionMapper()
	{
		super(S32PacketConfirmTransaction.class);
	}

	@Override
	public void parsePacketToMap(final S32PacketConfirmTransaction packet, final Map<String, String> valueMap)
	{
		valueMap.put("WindowId", String.valueOf(packet.getWindowId()));
		valueMap.put("ActionNumber", String.valueOf(packet.getActionNumber()));
		valueMap.put("Accepted", String.valueOf(packet.func_148888_e()));
	}
}
