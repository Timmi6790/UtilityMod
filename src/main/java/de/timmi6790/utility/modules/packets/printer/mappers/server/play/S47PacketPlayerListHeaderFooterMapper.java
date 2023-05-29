package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S47PacketPlayerListHeaderFooter;

import java.util.Map;


public class S47PacketPlayerListHeaderFooterMapper extends ServerPacketMapper<S47PacketPlayerListHeaderFooter> {
    public S47PacketPlayerListHeaderFooterMapper() {
        super(S47PacketPlayerListHeaderFooter.class);
    }

    @Override
    public void parsePacketToMap(final S47PacketPlayerListHeaderFooter packet, final Map<String, String> valueMap) {
        valueMap.put("Header", packet.getHeader().getUnformattedText());
        valueMap.put("Footer", packet.getFooter().getUnformattedText());
    }
}
