package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;
import java.util.Map;
import net.minecraft.network.play.server.S45PacketTitle;

public class S45PacketTitleMapper extends ServerPacketMapper<S45PacketTitle> {
    public S45PacketTitleMapper() {
        super(S45PacketTitle.class);
    }

    @Override
    public void parsePacketToMap(final S45PacketTitle packet, final Map<String, String> valueMap) {
        valueMap.put("Type", EnumUtils.getPrettyName(packet.getType()));
        valueMap.put("Message", packet.getMessage().getUnformattedText());
        valueMap.put("FadeInTime", String.valueOf(packet.getFadeInTime()));
        valueMap.put("FadeOutTime", String.valueOf(packet.getFadeOutTime()));
        valueMap.put("DisplayTime", String.valueOf(packet.getDisplayTime()));
    }
}
