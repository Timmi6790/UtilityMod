package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;
import java.util.StringJoiner;

import net.minecraft.network.play.server.S08PacketPlayerPosLook;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;

public class S08PacketPlayerPosLookMapper extends ServerPacketMapper<S08PacketPlayerPosLook>
{
	public S08PacketPlayerPosLookMapper()
	{
		super(S08PacketPlayerPosLook.class);
	}

	@Override
	public void parsePacketToMap(final S08PacketPlayerPosLook packet, final Map<String, String> valueMap)
	{
		valueMap.put("Position", this.join(packet.getX(), packet.getY(), packet.getZ()));
		valueMap.put("Look", this.join(packet.getYaw(), packet.getPitch()));

		final StringJoiner enumJoiner = new StringJoiner("; ");
		for (final S08PacketPlayerPosLook.EnumFlags flag : packet.func_179834_f())
		{
			enumJoiner.add(EnumUtils.getPrettyName(flag));
		}
		valueMap.put("Flags", enumJoiner.toString());
	}
}
