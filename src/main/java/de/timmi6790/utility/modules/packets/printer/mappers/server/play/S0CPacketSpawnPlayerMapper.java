package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;

import java.util.Map;


public class S0CPacketSpawnPlayerMapper extends ServerPacketMapper<S0CPacketSpawnPlayer> {
    public S0CPacketSpawnPlayerMapper() {
        super(S0CPacketSpawnPlayer.class);
    }

    @Override
    public void parsePacketToMap(final S0CPacketSpawnPlayer packet, final Map<String, String> valueMap) {
        valueMap.put("UUID", String.valueOf(packet.getPlayer()));
        valueMap.put("EntityId", String.valueOf(packet.getEntityID()));
        valueMap.put("Position", this.join(packet.getX(), packet.getY(), packet.getZ()));
        valueMap.put("Look", this.join(packet.getYaw(), packet.getPitch()));
        valueMap.put("ItemSlot", String.valueOf(packet.getCurrentItemID()));
    }
}
