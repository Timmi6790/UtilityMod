package de.timmi6790.utility.modules.packets.printer.mappers.server.login;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import net.minecraft.network.login.server.S01PacketEncryptionRequest;

import java.util.Map;


public class S01PacketEncryptionRequestMapper extends ServerPacketMapper<S01PacketEncryptionRequest> {
    public S01PacketEncryptionRequestMapper() {
        super(S01PacketEncryptionRequest.class);
    }

    @Override
    protected void parsePacketToMap(final S01PacketEncryptionRequest packet, final Map<String, String> valueMap) {
        // Not needed
    }
}
