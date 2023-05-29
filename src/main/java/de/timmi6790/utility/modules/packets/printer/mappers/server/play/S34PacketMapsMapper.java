package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S34PacketMaps;

import java.util.Map;


public class S34PacketMapsMapper extends ServerPacketMapper<S34PacketMaps> {
    public S34PacketMapsMapper() {
        super(S34PacketMaps.class);
    }

    @Override
    public void parsePacketToMap(final S34PacketMaps packet, final Map<String, String> valueMap) {
        valueMap.put("MapId", String.valueOf(packet.getMapId()));
        valueMap.put("Info", "Not fully implemented");
    }
}
