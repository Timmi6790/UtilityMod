package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import java.util.Map;
import net.minecraft.network.play.client.C0CPacketInput;

public class C0CPacketInputMapper extends ClientPacketMapper<C0CPacketInput> {
    public C0CPacketInputMapper() {
        super(C0CPacketInput.class);
    }

    @Override
    public void parsePacketToMap(final C0CPacketInput packet, final Map<String, String> valueMap) {
        valueMap.put("StrafeSpeed", String.valueOf(packet.getStrafeSpeed()));
        valueMap.put("ForwardSpeed", String.valueOf(packet.getForwardSpeed()));
        valueMap.put("Jumping", String.valueOf(packet.isJumping()));
        valueMap.put("Sneaking", String.valueOf(packet.isSneaking()));
    }
}
