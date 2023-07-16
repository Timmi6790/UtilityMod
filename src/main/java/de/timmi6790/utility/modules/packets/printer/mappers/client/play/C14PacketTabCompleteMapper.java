package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import java.util.Map;
import net.minecraft.network.play.client.C14PacketTabComplete;

public class C14PacketTabCompleteMapper extends ClientPacketMapper<C14PacketTabComplete> {
    public C14PacketTabCompleteMapper() {
        super(C14PacketTabComplete.class);
    }

    @Override
    public void parsePacketToMap(final C14PacketTabComplete packet, final Map<String, String> valueMap) {
        valueMap.put("Message", packet.getMessage());
        valueMap.put("BlockPos", this.toString(packet.getTargetBlock()));
    }
}
