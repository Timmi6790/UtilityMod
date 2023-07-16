package de.timmi6790.utility.modules.packets.printer.mappers.server.status;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.status.server.S00PacketServerInfo;

public class S00PacketServerInfoMapper extends ServerPacketMapper<S00PacketServerInfo> {
    public S00PacketServerInfoMapper() {
        super(S00PacketServerInfo.class);
    }

    @Override
    protected void parsePacketToMap(final S00PacketServerInfo packet, final Map<String, String> valueMap) {
        // Not needed
    }
}
