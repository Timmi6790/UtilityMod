package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;
import java.util.Map;
import net.minecraft.network.play.client.C16PacketClientStatus;

public class C16PacketClientStatusMapper extends ClientPacketMapper<C16PacketClientStatus> {
    public C16PacketClientStatusMapper() {
        super(C16PacketClientStatus.class);
    }

    @Override
    public void parsePacketToMap(final C16PacketClientStatus packet, final Map<String, String> valueMap) {
        valueMap.put("Status", EnumUtils.getPrettyName(packet.getStatus()));
    }
}
