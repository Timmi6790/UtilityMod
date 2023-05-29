package de.timmi6790.utility.modules.packets.printer.mappers.client.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import net.minecraft.network.play.client.C18PacketSpectate;

import java.util.Map;


public class C18PacketSpectateMapper extends ClientPacketMapper<C18PacketSpectate> {
    public C18PacketSpectateMapper() {
        super(C18PacketSpectate.class);
    }

    @Override
    protected void parsePacketToMap(final C18PacketSpectate packet, final Map<String, String> valueMap) {
        // Not needed
    }
}
