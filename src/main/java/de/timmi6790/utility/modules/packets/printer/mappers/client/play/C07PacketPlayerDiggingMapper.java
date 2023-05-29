package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;
import net.minecraft.network.play.client.C07PacketPlayerDigging;

import java.util.Map;


public class C07PacketPlayerDiggingMapper extends ClientPacketMapper<C07PacketPlayerDigging> {
    public C07PacketPlayerDiggingMapper() {
        super(C07PacketPlayerDigging.class);
    }

    @Override
    public void parsePacketToMap(final C07PacketPlayerDigging packet, final Map<String, String> valueMap) {
        valueMap.put("BlockPos", this.toString(packet.getPosition()));
        valueMap.put("Facing", EnumUtils.getPrettyName(packet.getFacing()));
        valueMap.put("Status", EnumUtils.getPrettyName(packet.getStatus()));
    }
}
