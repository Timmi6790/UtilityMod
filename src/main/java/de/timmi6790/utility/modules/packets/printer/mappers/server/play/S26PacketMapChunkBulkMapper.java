package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S26PacketMapChunkBulk;

public class S26PacketMapChunkBulkMapper extends ServerPacketMapper<S26PacketMapChunkBulk> {
    public S26PacketMapChunkBulkMapper() {
        super(S26PacketMapChunkBulk.class);
    }

    @Override
    public void parsePacketToMap(final S26PacketMapChunkBulk packet, final Map<String, String> valueMap) {
        valueMap.put("Info", "Not implemented");
    }
}
