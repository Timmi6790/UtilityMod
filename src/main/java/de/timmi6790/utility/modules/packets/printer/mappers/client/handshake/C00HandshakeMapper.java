package de.timmi6790.utility.modules.packets.printer.mappers.client.handshake;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;
import java.util.Map;
import net.minecraft.network.handshake.client.C00Handshake;

public class C00HandshakeMapper extends ClientPacketMapper<C00Handshake> {
    public C00HandshakeMapper() {
        super(C00Handshake.class);
    }

    @Override
    public void parsePacketToMap(final C00Handshake packet, final Map<String, String> valueMap) {
        valueMap.put("Version", String.valueOf(packet.getProtocolVersion()));
        valueMap.put("Ip", String.valueOf(packet.ip));
        valueMap.put("Port", String.valueOf(packet.port));
        valueMap.put("RequestState", EnumUtils.getPrettyName(packet.getRequestedState()));
        valueMap.put("FML", String.valueOf(packet.hasFMLMarker()));
    }
}
