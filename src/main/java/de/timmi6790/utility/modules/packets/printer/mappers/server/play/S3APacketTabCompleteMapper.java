package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.play.server.S3APacketTabComplete;

import java.util.Arrays;
import java.util.Map;


public class S3APacketTabCompleteMapper extends ServerPacketMapper<S3APacketTabComplete> {
    public S3APacketTabCompleteMapper() {
        super(S3APacketTabComplete.class);
    }

    @Override
    public void parsePacketToMap(final S3APacketTabComplete packet, final Map<String, String> valueMap) {
        valueMap.put("Matches", Arrays.toString(packet.func_149630_c()));
    }
}
