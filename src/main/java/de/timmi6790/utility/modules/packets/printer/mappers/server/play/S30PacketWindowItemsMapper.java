package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S30PacketWindowItems;

import java.util.Map;


public class S30PacketWindowItemsMapper extends ServerPacketMapper<S30PacketWindowItems> {
    public S30PacketWindowItemsMapper() {
        super(S30PacketWindowItems.class);
    }

    @Override
    public void parsePacketToMap(final S30PacketWindowItems packet, final Map<String, String> valueMap) {
        valueMap.put("WindowId", String.valueOf(packet.func_148911_c()));
        valueMap.put("ItemStack", "Not Implemented");
    }
}
