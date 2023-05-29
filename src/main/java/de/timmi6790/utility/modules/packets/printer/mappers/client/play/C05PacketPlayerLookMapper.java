package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import net.minecraft.network.play.client.C03PacketPlayer;

import java.util.Map;


public class C05PacketPlayerLookMapper extends ClientPacketMapper<C03PacketPlayer.C05PacketPlayerLook> {
    public C05PacketPlayerLookMapper() {
        super(C03PacketPlayer.C05PacketPlayerLook.class);
    }

    @Override
    public void parsePacketToMap(final C03PacketPlayer.C05PacketPlayerLook packet, final Map<String, String> valueMap) {
        valueMap.put("Look", this.join(packet.getYaw(), packet.getPitch()));
        valueMap.put("OnGround", String.valueOf(packet.isOnGround()));
    }
}
