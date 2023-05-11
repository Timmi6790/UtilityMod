package de.timmi6790.utility.modules.packets.logger;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import de.timmi6790.utility.modules.core.events.PacketReceiveEvent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PacketLoggerListener
{
	private final PacketLoggerModule module;

	@SubscribeEvent
	public void packetReceiveDebug(final PacketReceiveEvent.Pre event)
	{
		module.getPacketLogInfos().computeIfAbsent(
				event.getPacket().getClass(),
				PacketLogInfo::new
		).logPacket(event.getPacket());
	}
}
