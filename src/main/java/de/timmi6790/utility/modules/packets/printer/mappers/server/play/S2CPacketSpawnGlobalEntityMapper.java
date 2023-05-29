package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S2CPacketSpawnGlobalEntity;

import java.util.Map;


public class S2CPacketSpawnGlobalEntityMapper extends ServerPacketMapper<S2CPacketSpawnGlobalEntity> {
    public S2CPacketSpawnGlobalEntityMapper() {
        super(S2CPacketSpawnGlobalEntity.class);
    }

    @Override
    public void parsePacketToMap(final S2CPacketSpawnGlobalEntity packet, final Map<String, String> valueMap) {
        valueMap.put("EntityId", String.valueOf(packet.func_149052_c()));
        valueMap.put("Position", this.join(packet.func_149051_d(), packet.func_149050_e(), packet.func_149049_f()));
        valueMap.put("Type", String.valueOf(packet.func_149053_g()));
    }
}
