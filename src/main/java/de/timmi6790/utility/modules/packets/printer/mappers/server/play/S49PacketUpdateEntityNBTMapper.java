package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S49PacketUpdateEntityNBT;

import java.util.Map;


public class S49PacketUpdateEntityNBTMapper extends ServerPacketMapper<S49PacketUpdateEntityNBT> {
    public S49PacketUpdateEntityNBTMapper() {
        super(S49PacketUpdateEntityNBT.class);
    }

    @Override
    public void parsePacketToMap(final S49PacketUpdateEntityNBT packet, final Map<String, String> valueMap) {
        this.addEntityToMap(packet.getEntity(this.getWorld()), valueMap);
    }
}
