package de.timmi6790.utility.utils;

import java.util.Optional;
import java.util.function.Consumer;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PlayerUtils
{
	public Optional<EntityPlayer> getPlayer()
	{
		return Optional.ofNullable(Minecraft.getMinecraft().thePlayer);
	}

	public boolean consumePlayer(Consumer<EntityPlayer> playerConsumer)
	{
		final Optional<EntityPlayer> playerOptional = PlayerUtils.getPlayer();
		if (!playerOptional.isPresent())
		{
			return false;
		}

		playerConsumer.accept(playerOptional.get());
		return true;
	}
}
