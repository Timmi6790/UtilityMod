package de.timmi6790.utility.modules.packets.printer.mappers.server.login;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.login.server.S00PacketDisconnect;

import java.util.Map;


public class S00PacketDisconnectMapper extends ServerPacketMapper<S00PacketDisconnect> {
    public S00PacketDisconnectMapper() {
        super(S00PacketDisconnect.class);
    }

    @Override
    public void parsePacketToMap(final S00PacketDisconnect packet, final Map<String, String> valueMap) {
        valueMap.put("Reason", packet.func_149603_c().getUnformattedText());
    }
}
