package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

public class S35PacketUpdateTileEntityMapper extends ServerPacketMapper<S35PacketUpdateTileEntity> {
    public S35PacketUpdateTileEntityMapper() {
        super(S35PacketUpdateTileEntity.class);
    }

    @Override
    public void parsePacketToMap(final S35PacketUpdateTileEntity packet, final Map<String, String> valueMap) {
        valueMap.put("Position", this.toString(packet.getPos()));
        valueMap.put("MetaData", String.valueOf(packet.getTileEntityType()));
    }
}
