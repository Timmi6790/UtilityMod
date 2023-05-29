package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S06PacketUpdateHealth;

import java.util.Map;


public class S06PacketUpdateHealthMapper extends ServerPacketMapper<S06PacketUpdateHealth> {
    public S06PacketUpdateHealthMapper() {
        super(S06PacketUpdateHealth.class);
    }

    @Override
    public void parsePacketToMap(final S06PacketUpdateHealth packet, final Map<String, String> valueMap) {
        valueMap.put("Health", String.valueOf(packet.getHealth()));
        valueMap.put("Food", String.valueOf(packet.getFoodLevel()));
        valueMap.put("Saturation", String.valueOf(packet.getSaturationLevel()));
    }
}
