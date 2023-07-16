package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import java.util.StringJoiner;
import net.minecraft.network.play.server.S22PacketMultiBlockChange;

public class S22PacketMultiBlockChangeMapper extends ServerPacketMapper<S22PacketMultiBlockChange> {
    public S22PacketMultiBlockChangeMapper() {
        super(S22PacketMultiBlockChange.class);
    }

    @Override
    public void parsePacketToMap(final S22PacketMultiBlockChange packet, final Map<String, String> valueMap) {
        final StringJoiner changedBlockJoiner = new StringJoiner("; ");
        for (final S22PacketMultiBlockChange.BlockUpdateData blockUpdateData : packet.getChangedBlocks()) {
            changedBlockJoiner.add("(Position:" + this.toString(blockUpdateData.getPos()) + " | NewBlock: "
                    + blockUpdateData.getBlockState().getBlock().getRegistryName() + ")");
        }
        valueMap.put("ChangedBlocks", changedBlockJoiner.toString());
    }
}
