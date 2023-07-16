package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S3BPacketScoreboardObjective;

public class S3BPacketScoreboardObjectiveMapper extends ServerPacketMapper<S3BPacketScoreboardObjective> {
    public S3BPacketScoreboardObjectiveMapper() {
        super(S3BPacketScoreboardObjective.class);
    }

    @Override
    public void parsePacketToMap(final S3BPacketScoreboardObjective packet, final Map<String, String> valueMap) {
        valueMap.put("Name", packet.func_149339_c());
        valueMap.put("Value", packet.func_149337_d());
        valueMap.put("RenderType", packet.func_179817_d().name());
        valueMap.put("Field", String.valueOf(packet.func_149338_e()));
    }
}
