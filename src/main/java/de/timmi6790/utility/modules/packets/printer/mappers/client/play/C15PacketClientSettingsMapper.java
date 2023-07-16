package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;
import java.util.Map;
import net.minecraft.network.play.client.C15PacketClientSettings;

public class C15PacketClientSettingsMapper extends ClientPacketMapper<C15PacketClientSettings> {
    public C15PacketClientSettingsMapper() {
        super(C15PacketClientSettings.class);
    }

    @Override
    public void parsePacketToMap(final C15PacketClientSettings packet, final Map<String, String> valueMap) {
        valueMap.put("Language", packet.getLang());
        valueMap.put("View", String.valueOf(packet.view));
        valueMap.put("ChatVisibility", EnumUtils.getPrettyName(packet.getChatVisibility()));
        valueMap.put("EnableColours", String.valueOf(packet.isColorsEnabled()));
        valueMap.put("ModelPartFlags", String.valueOf(packet.getModelPartFlags()));
    }
}
