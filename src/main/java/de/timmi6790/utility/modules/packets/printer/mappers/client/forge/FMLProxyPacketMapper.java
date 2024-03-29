package de.timmi6790.utility.modules.packets.printer.mappers.client.forge;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import java.util.Map;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

public class FMLProxyPacketMapper extends ClientPacketMapper<FMLProxyPacket> {
    public FMLProxyPacketMapper() {
        super(FMLProxyPacket.class);
    }

    @Override
    public void parsePacketToMap(final FMLProxyPacket packet, final Map<String, String> valueMap) {
        valueMap.put("Channel", packet.channel());
        valueMap.put("Target", packet.getTarget().name());
    }
}
