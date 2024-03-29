package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import java.util.Map;
import net.minecraft.network.play.client.C17PacketCustomPayload;

public class C17PacketCustomPayloadMapper extends ClientPacketMapper<C17PacketCustomPayload> {
    public C17PacketCustomPayloadMapper() {
        super(C17PacketCustomPayload.class);
    }

    @Override
    public void parsePacketToMap(final C17PacketCustomPayload packet, final Map<String, String> valueMap) {
        valueMap.put("Channel", packet.getChannelName());
    }
}
