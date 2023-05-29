package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S3EPacketTeams;

import java.util.Map;


public class S3EPacketTeamsMapper extends ServerPacketMapper<S3EPacketTeams> {
    public S3EPacketTeamsMapper() {
        super(S3EPacketTeams.class);
    }

    @Override
    public void parsePacketToMap(final S3EPacketTeams packet, final Map<String, String> valueMap) {
        valueMap.put("Name", packet.getName());
        valueMap.put("DisplayName", packet.getDisplayName());
        valueMap.put("Prefix", packet.getPrefix());
        valueMap.put("Suffix", packet.getSuffix());
        valueMap.put("NameTagVisibility", packet.getNameTagVisibility());
        valueMap.put("Colour", String.valueOf(packet.getColor()));
        valueMap.put("Players", String.valueOf(packet.getPlayers()));
        valueMap.put("Action", String.valueOf(packet.getAction()));
        valueMap.put("FriendlyFlags", String.valueOf(packet.getFriendlyFlags()));
    }
}
