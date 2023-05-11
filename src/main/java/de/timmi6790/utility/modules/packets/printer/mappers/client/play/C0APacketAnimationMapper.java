package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import java.util.Map;

import net.minecraft.network.play.client.C0APacketAnimation;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;


public class C0APacketAnimationMapper extends ClientPacketMapper<C0APacketAnimation>
{
	public C0APacketAnimationMapper()
	{
		super(C0APacketAnimation.class);
	}

	@Override
	protected void parsePacketToMap(final C0APacketAnimation packet, final Map<String, String> valueMap)
	{
		// Not needed
	}
}
