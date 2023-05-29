package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S2EPacketCloseWindow;

import java.util.Map;


public class S2EPacketCloseWindowMapper extends ServerPacketMapper<S2EPacketCloseWindow> {
    public S2EPacketCloseWindowMapper() {
        super(S2EPacketCloseWindow.class);
    }

    @Override
    public void parsePacketToMap(final S2EPacketCloseWindow packet, final Map<String, String> valueMap) {
        valueMap.put("WindowId", String.valueOf(packet.windowId));
    }
}
