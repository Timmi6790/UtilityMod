package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S00PacketKeepAlive;

import java.util.Map;


public class S00PacketKeepAliveMapper extends ServerPacketMapper<S00PacketKeepAlive> {
    public S00PacketKeepAliveMapper() {
        super(S00PacketKeepAlive.class);
    }

    @Override
    public void parsePacketToMap(final S00PacketKeepAlive packet, final Map<String, String> valueMap) {
        valueMap.put("Key", String.valueOf(packet.func_149134_c()));
    }
}
