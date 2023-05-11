package de.timmi6790.utility.modules.packets.printer.mappers.server.login;

import java.util.Map;

import net.minecraft.network.login.server.S02PacketLoginSuccess;

import com.mojang.authlib.GameProfile;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S02PacketLoginSuccessMapper extends ServerPacketMapper<S02PacketLoginSuccess>
{
	public S02PacketLoginSuccessMapper()
	{
		super(S02PacketLoginSuccess.class);
	}

	@Override
	public void parsePacketToMap(final S02PacketLoginSuccess packet, final Map<String, String> valueMap)
	{
		final GameProfile gameProfile = packet.getProfile();
		valueMap.put("PlayerUUID", String.valueOf(gameProfile.getId()));
		valueMap.put("PlayerName", gameProfile.getName());
	}
}
