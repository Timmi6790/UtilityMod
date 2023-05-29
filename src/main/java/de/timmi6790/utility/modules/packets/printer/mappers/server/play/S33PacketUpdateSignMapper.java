package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S33PacketUpdateSign;
import net.minecraft.util.IChatComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class S33PacketUpdateSignMapper extends ServerPacketMapper<S33PacketUpdateSign> {
    public S33PacketUpdateSignMapper() {
        super(S33PacketUpdateSign.class);
    }

    @Override
    public void parsePacketToMap(final S33PacketUpdateSign packet, final Map<String, String> valueMap) {
        valueMap.put("Position", this.toString(packet.getPos()));

        final List<String> parsedLines = new ArrayList<>();
        for (final IChatComponent chatComponent : packet.getLines()) {
            parsedLines.add(chatComponent.getUnformattedText());
        }
        valueMap.put("Lines", this.join(parsedLines));
    }
}
