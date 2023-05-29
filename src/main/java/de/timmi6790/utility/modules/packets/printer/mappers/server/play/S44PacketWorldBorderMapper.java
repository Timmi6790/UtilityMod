package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S44PacketWorldBorder;

import java.util.Map;


public class S44PacketWorldBorderMapper extends ServerPacketMapper<S44PacketWorldBorder> {
    public S44PacketWorldBorderMapper() {
        super(S44PacketWorldBorder.class);
    }

    @Override
    public void parsePacketToMap(final S44PacketWorldBorder packet, final Map<String, String> valueMap) {
        valueMap.put("Info", "Not Implemented");
    }
}
