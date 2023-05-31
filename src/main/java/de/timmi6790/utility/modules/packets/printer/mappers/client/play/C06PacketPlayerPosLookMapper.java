package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import net.minecraft.network.play.client.C03PacketPlayer;

import java.util.Map;


public class C06PacketPlayerPosLookMapper extends ClientPacketMapper<C03PacketPlayer.C06PacketPlayerPosLook> {
    public C06PacketPlayerPosLookMapper() {
        super(C03PacketPlayer.C06PacketPlayerPosLook.class);
    }

    @Override
    public void parsePacketToMap(final C03PacketPlayer.C06PacketPlayerPosLook packet,
                                 final Map<String, String> valueMap) {
        valueMap.put("Position", this.join(packet.getPositionX(), packet.getPositionY(), packet.getPositionZ()));
        valueMap.put("Look", this.join(packet.getYaw(), packet.getPitch()));
        valueMap.put("OnGround", String.valueOf(packet.isOnGround()));
    }
}
