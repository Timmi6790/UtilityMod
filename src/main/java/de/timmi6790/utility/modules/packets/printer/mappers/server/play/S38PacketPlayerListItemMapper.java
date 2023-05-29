package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import com.mojang.authlib.GameProfile;
import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;
import net.minecraft.network.play.server.S38PacketPlayerListItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class S38PacketPlayerListItemMapper extends ServerPacketMapper<S38PacketPlayerListItem> {
    public S38PacketPlayerListItemMapper() {
        super(S38PacketPlayerListItem.class);
    }

    @Override
    public void parsePacketToMap(final S38PacketPlayerListItem packet, final Map<String, String> valueMap) {
        valueMap.put("Action", EnumUtils.getPrettyName(packet.getAction()));

        final List<String> playerUUIDS = new ArrayList<>();
        for (final S38PacketPlayerListItem.AddPlayerData data : packet.getEntries()) {
            final GameProfile gameProfile = data.getProfile();
            playerUUIDS.add(String.valueOf(gameProfile.getId()));
        }
        valueMap.put("PlayerUUIDs", String.valueOf(playerUUIDS));
    }
}
