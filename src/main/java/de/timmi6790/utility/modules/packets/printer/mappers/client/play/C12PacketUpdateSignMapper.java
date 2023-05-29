package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import net.minecraft.network.play.client.C12PacketUpdateSign;
import net.minecraft.util.IChatComponent;

import java.util.Map;
import java.util.StringJoiner;


public class C12PacketUpdateSignMapper extends ClientPacketMapper<C12PacketUpdateSign> {
    public C12PacketUpdateSignMapper() {
        super(C12PacketUpdateSign.class);
    }

    @Override
    public void parsePacketToMap(final C12PacketUpdateSign packet, final Map<String, String> valueMap) {
        valueMap.put("BlockPos", this.toString(packet.getPosition()));

        final StringJoiner parsedLines = new StringJoiner("; ");
        for (final IChatComponent line : packet.getLines()) {
            parsedLines.add(line.getUnformattedText());
        }
        valueMap.put("Lines", "[" + parsedLines + "]");
    }
}
