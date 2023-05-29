package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;

import java.util.Map;


public class C10PacketCreativeInventoryActionMapper extends ClientPacketMapper<C10PacketCreativeInventoryAction> {
    public C10PacketCreativeInventoryActionMapper() {
        super(C10PacketCreativeInventoryAction.class);
    }

    @Override
    public void parsePacketToMap(final C10PacketCreativeInventoryAction packet, final Map<String, String> valueMap) {
        valueMap.put("SlotId", String.valueOf(packet.getSlotId()));
        valueMap.put("ItemName", this.toString(packet.getStack()));
    }
}
