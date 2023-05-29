package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import net.minecraft.network.play.client.C03PacketPlayer;

import java.util.Map;


public class C03PacketPlayerMapper extends ClientPacketMapper<C03PacketPlayer> {
    public C03PacketPlayerMapper() {
        super(C03PacketPlayer.class);
    }

    @Override
    public void parsePacketToMap(final C03PacketPlayer packet, final Map<String, String> valueMap) {
        valueMap.put("OnGround", String.valueOf(packet.isOnGround()));
    }
}
