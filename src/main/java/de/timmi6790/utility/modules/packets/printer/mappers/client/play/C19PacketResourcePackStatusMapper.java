package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;
import java.util.Map;
import net.minecraft.network.play.client.C19PacketResourcePackStatus;

public class C19PacketResourcePackStatusMapper extends ClientPacketMapper<C19PacketResourcePackStatus> {
    public C19PacketResourcePackStatusMapper() {
        super(C19PacketResourcePackStatus.class);
    }

    @Override
    public void parsePacketToMap(final C19PacketResourcePackStatus packet, final Map<String, String> valueMap) {
        valueMap.put("Action", EnumUtils.getPrettyName(packet.status));
    }
}
