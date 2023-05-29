package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S19PacketEntityStatus;

import java.util.Map;


public class S19PacketEntityStatusMapper extends ServerPacketMapper<S19PacketEntityStatus> {
    public S19PacketEntityStatusMapper() {
        super(S19PacketEntityStatus.class);
    }

    @Override
    public void parsePacketToMap(final S19PacketEntityStatus packet, final Map<String, String> valueMap) {
        this.addEntityToMap(packet.getEntity(this.getWorld()), valueMap);
        valueMap.put("OpCode", String.valueOf(packet.getOpCode()));
    }
}
