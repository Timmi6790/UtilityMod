package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class S12PacketEntityVelocityMapper extends ServerPacketMapper<S12PacketEntityVelocity> {
    public S12PacketEntityVelocityMapper() {
        super(S12PacketEntityVelocity.class);
    }

    @Override
    public void parsePacketToMap(final S12PacketEntityVelocity packet, final Map<String, String> valueMap) {
        valueMap.put("EntityId", String.valueOf(packet.getEntityID()));
        valueMap.put("Motion", this.join(packet.getMotionX(), packet.getMotionY(), packet.getMotionZ()));
    }
}
