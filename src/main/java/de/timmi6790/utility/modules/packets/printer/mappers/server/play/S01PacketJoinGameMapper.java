package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S01PacketJoinGame;

public class S01PacketJoinGameMapper extends ServerPacketMapper<S01PacketJoinGame> {
    public S01PacketJoinGameMapper() {
        super(S01PacketJoinGame.class);
    }

    @Override
    public void parsePacketToMap(final S01PacketJoinGame packet, final Map<String, String> valueMap) {
        valueMap.put("EntityId", String.valueOf(packet.getEntityId()));
        valueMap.put("HardcoreMode", String.valueOf(packet.isHardcoreMode()));
        valueMap.put("Dimension", String.valueOf(packet.getDimension()));
        valueMap.put("Difficulty", String.valueOf(packet.getDifficulty().getDifficultyResourceKey()));
        valueMap.put("MaxPlayers", String.valueOf(packet.getMaxPlayers()));
        valueMap.put("GameType", String.valueOf(packet.getGameType().getName()));
        valueMap.put("WorldType", String.valueOf(packet.getWorldType().getWorldTypeName()));
        valueMap.put("ReducedDebugInfo", String.valueOf(packet.isReducedDebugInfo()));
    }
}
