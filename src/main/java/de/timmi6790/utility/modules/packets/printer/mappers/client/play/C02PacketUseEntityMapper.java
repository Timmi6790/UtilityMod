package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;
import java.util.Map;
import net.minecraft.network.play.client.C02PacketUseEntity;

public class C02PacketUseEntityMapper extends ClientPacketMapper<C02PacketUseEntity> {
    public C02PacketUseEntityMapper() {
        super(C02PacketUseEntity.class);
    }

    @Override
    public void parsePacketToMap(final C02PacketUseEntity packet, final Map<String, String> valueMap) {
        this.addEntityToMap(packet.getEntityFromWorld(this.getWorld()), valueMap);
        valueMap.put("Action", EnumUtils.getPrettyName(packet.getAction()));
        valueMap.put("HitVec", String.valueOf(packet.getHitVec()));
    }
}
