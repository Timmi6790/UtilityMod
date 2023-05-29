package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S1DPacketEntityEffect;

import java.util.Map;


public class S1DPacketEntityEffectMapper extends ServerPacketMapper<S1DPacketEntityEffect> {
    public S1DPacketEntityEffectMapper() {
        super(S1DPacketEntityEffect.class);
    }

    @Override
    public void parsePacketToMap(final S1DPacketEntityEffect packet, final Map<String, String> valueMap) {
        valueMap.put("EntityId", String.valueOf(packet.getEntityId()));
        valueMap.put("EffectId", String.valueOf(packet.getEffectId()));
        valueMap.put("Amplifier", String.valueOf(packet.getAmplifier()));
        valueMap.put("Duration", String.valueOf(packet.getDuration()));
        valueMap.put("HideParticles", String.valueOf(packet.func_179707_f()));
    }
}
