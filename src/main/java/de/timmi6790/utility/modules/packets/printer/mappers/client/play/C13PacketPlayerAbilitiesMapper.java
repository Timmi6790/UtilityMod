package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;

import java.util.Map;


public class C13PacketPlayerAbilitiesMapper extends ClientPacketMapper<C13PacketPlayerAbilities> {
    public C13PacketPlayerAbilitiesMapper() {
        super(C13PacketPlayerAbilities.class);
    }

    @Override
    public void parsePacketToMap(final C13PacketPlayerAbilities packet, final Map<String, String> valueMap) {
        valueMap.put("Invulnerable", String.valueOf(packet.isInvulnerable()));
        valueMap.put("Flying", String.valueOf(packet.isFlying()));
        valueMap.put("AllowFlying", String.valueOf(packet.isAllowFlying()));
        valueMap.put("CreativeMode", String.valueOf(packet.isCreativeMode()));
        valueMap.put("FlySpeed", String.valueOf(packet.flySpeed));
        valueMap.put("WalkSpeed", String.valueOf(packet.walkSpeed));
    }
}
