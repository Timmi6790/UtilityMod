package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S14PacketEntity;

public class S14PacketEntityMapper extends ServerPacketMapper<S14PacketEntity> {
    public S14PacketEntityMapper() {
        super(S14PacketEntity.class);
    }

    @Override
    public void parsePacketToMap(final S14PacketEntity packet, final Map<String, String> valueMap) {
        this.addEntityToMap(packet.getEntity(this.getWorld()), valueMap);
        valueMap.put("Position", this.join(packet.func_149062_c(), packet.func_149061_d(), packet.func_149064_e()));
        valueMap.put("Look", this.join(packet.func_149066_f(), packet.func_149063_g()));
        valueMap.put("OnGround", String.valueOf(packet.getOnGround()));
        valueMap.put("Field", String.valueOf(packet.func_149063_g()));
    }
}
