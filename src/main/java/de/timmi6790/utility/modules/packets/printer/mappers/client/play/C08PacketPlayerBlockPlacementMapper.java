package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;

import java.util.Map;


public class C08PacketPlayerBlockPlacementMapper extends ClientPacketMapper<C08PacketPlayerBlockPlacement> {
    public C08PacketPlayerBlockPlacementMapper() {
        super(C08PacketPlayerBlockPlacement.class);
    }

    @Override
    public void parsePacketToMap(final C08PacketPlayerBlockPlacement packet, final Map<String, String> valueMap) {
        valueMap.put("BlockPos", this.toString(packet.getPosition()));
        valueMap.put("PlaceDirection", String.valueOf(packet.getPlacedBlockDirection()));
        valueMap.put("ItemName", this.toString(packet.getStack()));
        valueMap.put("Facing", this.join(packet.getPlacedBlockOffsetX(), packet.getPlacedBlockOffsetY(), packet.getPlacedBlockOffsetZ()));
    }
}
