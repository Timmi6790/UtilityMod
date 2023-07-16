package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Arrays;
import java.util.Map;
import net.minecraft.network.play.server.S2APacketParticles;

public class S2APacketParticlesMapper extends ServerPacketMapper<S2APacketParticles> {
    public S2APacketParticlesMapper() {
        super(S2APacketParticles.class);
    }

    @Override
    public void parsePacketToMap(final S2APacketParticles packet, final Map<String, String> valueMap) {
        valueMap.put("ParticleType", packet.getParticleType().getParticleName());
        valueMap.put("Position", this.join(packet.getXCoordinate(), packet.getYCoordinate(), packet.getZCoordinate()));
        valueMap.put("Offset", this.join(packet.getXCoordinate(), packet.getYCoordinate(), packet.getZCoordinate()));
        valueMap.put("ParticleSpeed", String.valueOf(packet.getParticleSpeed()));
        valueMap.put("ParticleCount", String.valueOf(packet.getParticleCount()));
        valueMap.put("LongDistance", String.valueOf(packet.isLongDistance()));
        valueMap.put("Arguments", Arrays.toString(packet.getParticleArgs()));
    }
}
