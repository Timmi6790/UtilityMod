package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S2DPacketOpenWindow;

public class S2DPacketOpenWindowMapper extends ServerPacketMapper<S2DPacketOpenWindow> {
    public S2DPacketOpenWindowMapper() {
        super(S2DPacketOpenWindow.class);
    }

    @Override
    public void parsePacketToMap(final S2DPacketOpenWindow packet, final Map<String, String> valueMap) {
        valueMap.put("WindowId", String.valueOf(packet.getWindowId()));
        valueMap.put("InventoryType", String.valueOf(packet.getGuiId()));
        valueMap.put("WindowTitle", String.valueOf(packet.getWindowTitle().getUnformattedText()));
        valueMap.put("SlotCount", String.valueOf(packet.getSlotCount()));
        valueMap.put("EntityId", String.valueOf(packet.getEntityId()));
    }
}
