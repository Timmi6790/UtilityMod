package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S23PacketBlockChange;

import java.util.Map;


public class S23PacketBlockChangeMapper extends ServerPacketMapper<S23PacketBlockChange> {
    public S23PacketBlockChangeMapper() {
        super(S23PacketBlockChange.class);
    }

    @Override
    public void parsePacketToMap(final S23PacketBlockChange packet, final Map<String, String> valueMap) {
        valueMap.put("Position", this.toString(packet.getBlockPosition()));
        valueMap.put("NewBlock", packet.getBlockState().getBlock().getRegistryName());
    }
}
