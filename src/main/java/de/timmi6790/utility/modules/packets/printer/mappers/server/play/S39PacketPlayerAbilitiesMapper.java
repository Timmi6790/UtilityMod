package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S39PacketPlayerAbilities;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S39PacketPlayerAbilitiesMapper extends ServerPacketMapper<S39PacketPlayerAbilities>
{
	public S39PacketPlayerAbilitiesMapper()
	{
		super(S39PacketPlayerAbilities.class);
	}

	@Override
	public void parsePacketToMap(final S39PacketPlayerAbilities packet, final Map<String, String> valueMap)
	{
		valueMap.put("Invulnerable", String.valueOf(packet.isInvulnerable()));
		valueMap.put("Flying", String.valueOf(packet.isFlying()));
		valueMap.put("AllowFlying", String.valueOf(packet.isAllowFlying()));
		valueMap.put("CreativeMode", String.valueOf(packet.isCreativeMode()));
		valueMap.put("FlySpeed", String.valueOf(packet.getFlySpeed()));
		valueMap.put("WalkSpeed", String.valueOf(packet.getWalkSpeed()));
	}
}
