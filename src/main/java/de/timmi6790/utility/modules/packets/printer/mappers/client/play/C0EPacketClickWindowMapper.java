package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import java.util.Map;
import net.minecraft.network.play.client.C0EPacketClickWindow;

public class C0EPacketClickWindowMapper extends ClientPacketMapper<C0EPacketClickWindow> {
    public C0EPacketClickWindowMapper() {
        super(C0EPacketClickWindow.class);
    }

    @Override
    public void parsePacketToMap(final C0EPacketClickWindow packet, final Map<String, String> valueMap) {
        valueMap.put("WindowId", String.valueOf(packet.getWindowId()));
        valueMap.put("SlotId", String.valueOf(packet.getSlotId()));
        valueMap.put("UsedButton", String.valueOf(packet.getUsedButton()));
        valueMap.put("ActionNumber", String.valueOf(packet.getActionNumber()));
        valueMap.put("Mode", String.valueOf(packet.getMode()));
        valueMap.put("ClickedItem", this.toString(packet.getClickedItem()));
    }
}
