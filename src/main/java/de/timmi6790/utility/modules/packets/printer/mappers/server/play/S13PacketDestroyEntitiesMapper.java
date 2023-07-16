package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S13PacketDestroyEntities;
import scala.actors.threadpool.Arrays;

public class S13PacketDestroyEntitiesMapper extends ServerPacketMapper<S13PacketDestroyEntities> {
    public S13PacketDestroyEntitiesMapper() {
        super(S13PacketDestroyEntities.class);
    }

    @Override
    public void parsePacketToMap(final S13PacketDestroyEntities packet, final Map<String, String> valueMap) {
        valueMap.put("EntityIds", Arrays.toString(packet.getEntityIDs()));
    }
}
