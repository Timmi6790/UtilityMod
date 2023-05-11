package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import java.util.Map;

import net.minecraft.network.play.client.C0BPacketEntityAction;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;


public class C0BPacketEntityActionMapper extends ClientPacketMapper<C0BPacketEntityAction>
{
	public C0BPacketEntityActionMapper()
	{
		super(C0BPacketEntityAction.class);
	}

	@Override
	public void parsePacketToMap(final C0BPacketEntityAction packet, final Map<String, String> valueMap)
	{
		valueMap.put("EntityId", String.valueOf(packet.entityID));
		valueMap.put("Action", EnumUtils.getPrettyName(packet.getAction()));
		valueMap.put("AuxData", String.valueOf(packet.getAuxData()));
	}
}
