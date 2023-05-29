package de.timmi6790.utility.modules.packets.printer.mappers.client.status;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import net.minecraft.network.status.client.C00PacketServerQuery;

import java.util.Map;


public class C00PacketServerQueryMapper extends ClientPacketMapper<C00PacketServerQuery> {
    public C00PacketServerQueryMapper() {
        super(C00PacketServerQuery.class);
    }

    @Override
    protected void parsePacketToMap(final C00PacketServerQuery packet, final Map<String, String> valueMap) {
        // Not needed
    }
}
