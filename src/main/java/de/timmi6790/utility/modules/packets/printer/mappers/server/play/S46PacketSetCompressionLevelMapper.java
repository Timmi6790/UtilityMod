package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S46PacketSetCompressionLevel;

public class S46PacketSetCompressionLevelMapper extends ServerPacketMapper<S46PacketSetCompressionLevel> {
    public S46PacketSetCompressionLevelMapper() {
        super(S46PacketSetCompressionLevel.class);
    }

    @Override
    public void parsePacketToMap(final S46PacketSetCompressionLevel packet, final Map<String, String> valueMap) {
        valueMap.put("Threshold", String.valueOf(packet.getThreshold()));
    }
}
