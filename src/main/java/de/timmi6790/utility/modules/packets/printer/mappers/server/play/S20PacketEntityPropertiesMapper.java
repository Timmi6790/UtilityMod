package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S20PacketEntityProperties;

public class S20PacketEntityPropertiesMapper extends ServerPacketMapper<S20PacketEntityProperties> {
    public S20PacketEntityPropertiesMapper() {
        super(S20PacketEntityProperties.class);
    }

    @Override
    public void parsePacketToMap(final S20PacketEntityProperties packet, final Map<String, String> valueMap) {
        valueMap.put("EntityId", String.valueOf(packet.getEntityId()));
        valueMap.put("Modifier", "Not Implemented");
    }
}
