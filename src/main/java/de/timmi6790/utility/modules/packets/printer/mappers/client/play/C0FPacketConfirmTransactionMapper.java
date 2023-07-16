package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import java.util.Map;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;

public class C0FPacketConfirmTransactionMapper extends ClientPacketMapper<C0FPacketConfirmTransaction> {
    public C0FPacketConfirmTransactionMapper() {
        super(C0FPacketConfirmTransaction.class);
    }

    @Override
    public void parsePacketToMap(final C0FPacketConfirmTransaction packet, final Map<String, String> valueMap) {
        valueMap.put("WindowId", String.valueOf(packet.getWindowId()));
        valueMap.put("UID", String.valueOf(packet.getUid()));
        valueMap.put("Accepted", String.valueOf(packet.accepted));
    }
}
