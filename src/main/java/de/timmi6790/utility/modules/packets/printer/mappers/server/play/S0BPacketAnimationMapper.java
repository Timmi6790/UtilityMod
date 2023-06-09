package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S0BPacketAnimation;

import java.util.Map;


public class S0BPacketAnimationMapper extends ServerPacketMapper<S0BPacketAnimation> {
    public S0BPacketAnimationMapper() {
        super(S0BPacketAnimation.class);
    }

    @Override
    public void parsePacketToMap(final S0BPacketAnimation packet, final Map<String, String> valueMap) {
        valueMap.put("EntityId", String.valueOf(packet.getEntityID()));
        valueMap.put("Type", String.valueOf(packet.getAnimationType()));
    }
}
