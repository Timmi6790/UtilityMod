package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S40PacketDisconnect;

public class S40PacketDisconnectMapper extends ServerPacketMapper<S40PacketDisconnect> {
    public S40PacketDisconnectMapper() {
        super(S40PacketDisconnect.class);
    }

    @Override
    public void parsePacketToMap(final S40PacketDisconnect packet, final Map<String, String> valueMap) {
        valueMap.put("Reason", packet.getReason().getUnformattedText());
    }
}
