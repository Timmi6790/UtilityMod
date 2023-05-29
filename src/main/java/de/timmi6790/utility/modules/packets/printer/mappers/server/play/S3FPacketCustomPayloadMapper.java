package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S3FPacketCustomPayload;

import java.util.Map;


public class S3FPacketCustomPayloadMapper extends ServerPacketMapper<S3FPacketCustomPayload> {
    public S3FPacketCustomPayloadMapper() {
        super(S3FPacketCustomPayload.class);
    }

    @Override
    public void parsePacketToMap(final S3FPacketCustomPayload packet, final Map<String, String> valueMap) {
        valueMap.put("Channel", packet.getChannelName());
    }
}
