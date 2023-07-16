package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S1FPacketSetExperience;

public class S1FPacketSetExperienceMapper extends ServerPacketMapper<S1FPacketSetExperience> {
    public S1FPacketSetExperienceMapper() {
        super(S1FPacketSetExperience.class);
    }

    @Override
    public void parsePacketToMap(final S1FPacketSetExperience packet, final Map<String, String> valueMap) {
        valueMap.put("Level", String.valueOf(packet.getLevel()));
        valueMap.put("TotalExperience", String.valueOf(packet.getTotalExperience()));
        valueMap.put("Field", String.valueOf(packet.func_149397_c()));
    }
}
