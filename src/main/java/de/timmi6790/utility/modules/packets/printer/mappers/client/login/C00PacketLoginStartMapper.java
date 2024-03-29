package de.timmi6790.utility.modules.packets.printer.mappers.client.login;

import com.mojang.authlib.GameProfile;
import de.timmi6790.utility.modules.packets.printer.mappers.ClientPacketMapper;
import java.util.Map;
import net.minecraft.network.login.client.C00PacketLoginStart;

public class C00PacketLoginStartMapper extends ClientPacketMapper<C00PacketLoginStart> {
    public C00PacketLoginStartMapper() {
        super(C00PacketLoginStart.class);
    }

    @Override
    public void parsePacketToMap(final C00PacketLoginStart packet, final Map<String, String> valueMap) {
        final GameProfile profile = packet.getProfile();

        valueMap.put("UUID", String.valueOf(profile.getId()));
        valueMap.put("Name", profile.getName());
    }
}
