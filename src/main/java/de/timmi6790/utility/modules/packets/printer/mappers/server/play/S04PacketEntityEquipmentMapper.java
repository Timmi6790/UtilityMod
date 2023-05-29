package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S04PacketEntityEquipment;

import java.util.Map;


public class S04PacketEntityEquipmentMapper extends ServerPacketMapper<S04PacketEntityEquipment> {
    public S04PacketEntityEquipmentMapper() {
        super(S04PacketEntityEquipment.class);
    }

    @Override
    public void parsePacketToMap(final S04PacketEntityEquipment packet, final Map<String, String> valueMap) {
        valueMap.put("EntityId", String.valueOf(packet.getEntityID()));
        valueMap.put("SlotId", String.valueOf(packet.getEquipmentSlot()));
        valueMap.put("Item", packet.getItemStack().getItem().getRegistryName());
    }
}
