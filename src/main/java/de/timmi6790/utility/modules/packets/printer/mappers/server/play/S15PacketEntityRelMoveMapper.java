package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S14PacketEntity;

import java.util.Map;


public class S15PacketEntityRelMoveMapper extends ServerPacketMapper<S14PacketEntity.S15PacketEntityRelMove> {
    public S15PacketEntityRelMoveMapper() {
        super(S14PacketEntity.S15PacketEntityRelMove.class);
    }

    @Override
    public void parsePacketToMap(final S14PacketEntity.S15PacketEntityRelMove packet,
                                 final Map<String, String> valueMap) {
        this.addEntityToMap(packet.getEntity(this.getWorld()), valueMap);
        valueMap.put("Position", this.join(packet.func_149062_c(), packet.func_149061_d(), packet.func_149064_e()));
        valueMap.put("OnGround", String.valueOf(packet.getOnGround()));
    }
}
