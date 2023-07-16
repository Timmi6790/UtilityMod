package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import java.util.Map;
import net.minecraft.network.play.client.C0DPacketCloseWindow;

public class C0DPacketCloseWindowMapper extends ClientPacketMapper<C0DPacketCloseWindow> {
    public C0DPacketCloseWindowMapper() {
        super(C0DPacketCloseWindow.class);
    }

    @Override
    public void parsePacketToMap(final C0DPacketCloseWindow packet, final Map<String, String> valueMap) {
        valueMap.put("WindowId", String.valueOf(packet.windowId));
    }
}
