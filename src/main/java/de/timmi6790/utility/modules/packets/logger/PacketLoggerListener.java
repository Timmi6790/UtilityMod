package de.timmi6790.utility.modules.packets.logger;

import de.timmi6790.utility.ListenerComponent;
import de.timmi6790.utility.modules.core.events.PacketReceiveEvent;
import lombok.RequiredArgsConstructor;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@RequiredArgsConstructor
public class PacketLoggerListener implements ListenerComponent {
    private final PacketLoggerModule module;

    @SubscribeEvent
    public void packetReceiveDebug(final PacketReceiveEvent.Pre event) {
        this.module
                .getPacketLogInfos()
                .computeIfAbsent(event.getPacket().getClass(), PacketLogInfo::new)
                .logPacket(event.getPacket());
    }
}
