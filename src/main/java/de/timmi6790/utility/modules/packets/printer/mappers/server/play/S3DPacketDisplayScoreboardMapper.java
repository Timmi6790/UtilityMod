package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S3DPacketDisplayScoreboard;

import java.util.Map;


public class S3DPacketDisplayScoreboardMapper extends ServerPacketMapper<S3DPacketDisplayScoreboard> {
    public S3DPacketDisplayScoreboardMapper() {
        super(S3DPacketDisplayScoreboard.class);
    }

    @Override
    public void parsePacketToMap(final S3DPacketDisplayScoreboard packet, final Map<String, String> valueMap) {
        valueMap.put("ScoreName", packet.func_149370_d());
        valueMap.put("Position", String.valueOf(packet.func_149371_c()));
    }
}
