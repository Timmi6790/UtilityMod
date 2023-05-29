package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S09PacketHeldItemChange;

import java.util.Map;


public class S09PacketHeldItemChangeMapper extends ServerPacketMapper<S09PacketHeldItemChange> {
    public S09PacketHeldItemChangeMapper() {
        super(S09PacketHeldItemChange.class);
    }

    @Override
    public void parsePacketToMap(final S09PacketHeldItemChange packet, final Map<String, String> valueMap) {
        valueMap.put("HotbarId", String.valueOf(packet.getHeldItemHotbarIndex()));
    }
}
