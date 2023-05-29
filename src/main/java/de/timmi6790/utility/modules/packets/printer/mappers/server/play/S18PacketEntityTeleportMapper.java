package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S18PacketEntityTeleport;

import java.util.Map;


public class S18PacketEntityTeleportMapper extends ServerPacketMapper<S18PacketEntityTeleport> {
    public S18PacketEntityTeleportMapper() {
        super(S18PacketEntityTeleport.class);
    }

    @Override
    public void parsePacketToMap(final S18PacketEntityTeleport packet, final Map<String, String> valueMap) {
        valueMap.put("EntityId", String.valueOf(packet.getEntityId()));
        valueMap.put("Position", this.join(packet.getX(), packet.getY(), packet.getZ()));
        valueMap.put("Look", this.join(packet.getYaw(), packet.getPitch()));
        valueMap.put("OnGround", String.valueOf(packet.getOnGround()));
    }
}
