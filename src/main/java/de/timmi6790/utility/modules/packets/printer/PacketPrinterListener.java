package de.timmi6790.utility.modules.packets.printer;

import de.timmi6790.utility.ListenerComponent;
import de.timmi6790.utility.modules.core.events.PacketReceiveEvent;
import de.timmi6790.utility.modules.core.events.PacketSendEvent;
import de.timmi6790.utility.modules.packets.printer.mappers.PacketMapper;
import de.timmi6790.utility.utils.MessageBuilder;
import de.timmi6790.utility.utils.PlayerUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.minecraft.network.Packet;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
public class PacketPrinterListener implements ListenerComponent {
    private final PacketPrinterModule module;

    @SubscribeEvent
    public void onPacketSend(final PacketSendEvent.Post event) {
        this.handlePacket(event.getPacket());
    }

    @SubscribeEvent
    public void onPacketReceive(final PacketReceiveEvent.Post event) {
        this.handlePacket(event.getPacket());
    }

    private void handlePacket(final Packet packet) {
        if (!module.hasPacketLogger((Class<Packet<?>>) packet.getClass())) {
            return;
        }

        final Optional<? extends PacketMapper<? extends Packet>> packetMapperOpt = module.getPacketMapper(packet.getClass());
        if (!packetMapperOpt.isPresent()) {
            log.warn("No packet mapper found for " + packet.getClass());
            return;
        }

        final PacketMapper packetMapper = packetMapperOpt.get();
        final MessageBuilder messageBuilder = packetMapper.parsePacketToMessage(packet);
        if (messageBuilder != null) {
            // Always fall back to logs if the user is not present
            if (module.getPrintMode() == PrintMode.CHAT && PlayerUtils.getPlayer().isPresent()) {
                messageBuilder.sendToPlayer();
            } else {
                final IChatComponent chatComponent = messageBuilder.build();
                log.info(chatComponent.getUnformattedText());
            }
        }
    }
}
