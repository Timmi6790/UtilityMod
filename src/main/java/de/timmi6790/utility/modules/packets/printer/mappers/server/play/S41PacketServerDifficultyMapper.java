package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;
import java.util.Map;
import net.minecraft.network.play.server.S41PacketServerDifficulty;

public class S41PacketServerDifficultyMapper extends ServerPacketMapper<S41PacketServerDifficulty> {
    public S41PacketServerDifficultyMapper() {
        super(S41PacketServerDifficulty.class);
    }

    @Override
    public void parsePacketToMap(final S41PacketServerDifficulty packet, final Map<String, String> valueMap) {
        valueMap.put("Difficulty", EnumUtils.getPrettyName(packet.getDifficulty()));
        valueMap.put("Locked", String.valueOf(packet.isDifficultyLocked()));
    }
}
