package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S28PacketEffect;

import java.util.Map;


public class S28PacketEffectMapper extends ServerPacketMapper<S28PacketEffect> {
    public S28PacketEffectMapper() {
        super(S28PacketEffect.class);
    }

    @Override
    public void parsePacketToMap(final S28PacketEffect packet, final Map<String, String> valueMap) {
        valueMap.put("Position", this.toString(packet.getSoundPos()));
        valueMap.put("SoundType", String.valueOf(packet.getSoundType()));
        valueMap.put("SoundData", String.valueOf(packet.getSoundData()));
        valueMap.put("ServerWide", String.valueOf(packet.isSoundServerwide()));
    }
}
