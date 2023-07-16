package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import java.util.Map;
import net.minecraft.network.play.server.S29PacketSoundEffect;

public class S29PacketSoundEffectMapper extends ServerPacketMapper<S29PacketSoundEffect> {
    public S29PacketSoundEffectMapper() {
        super(S29PacketSoundEffect.class);
    }

    @Override
    public void parsePacketToMap(final S29PacketSoundEffect packet, final Map<String, String> valueMap) {
        valueMap.put("SoundName", packet.getSoundName());
        valueMap.put("Position", this.join(packet.getX(), packet.getY(), packet.getZ()));
        valueMap.put("Volume", String.valueOf(packet.getVolume()));
        valueMap.put("Pitch", String.valueOf(packet.getPitch()));
    }
}
