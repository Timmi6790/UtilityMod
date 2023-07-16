package de.timmi6790.utility.modules.packets.printer.mappers.client.login;

import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import java.util.Map;
import net.minecraft.network.login.client.C01PacketEncryptionResponse;

public class C01PacketEncryptionResponseMapper extends ClientPacketMapper<C01PacketEncryptionResponse> {
    public C01PacketEncryptionResponseMapper() {
        super(C01PacketEncryptionResponse.class);
    }

    @Override
    protected void parsePacketToMap(final C01PacketEncryptionResponse packet, final Map<String, String> valueMap) {
        // Not needed
    }
}
