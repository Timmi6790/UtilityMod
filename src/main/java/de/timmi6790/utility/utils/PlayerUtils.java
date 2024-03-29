package de.timmi6790.utility.utils;

import java.util.Optional;
import java.util.function.Consumer;
import lombok.experimental.UtilityClass;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

@UtilityClass
public class PlayerUtils {
    public Optional<EntityPlayer> getPlayer() {
        return Optional.ofNullable(Minecraft.getMinecraft().thePlayer);
    }

    public boolean consumePlayer(final Consumer<EntityPlayer> playerConsumer) {
        final Optional<EntityPlayer> playerOptional = PlayerUtils.getPlayer();
        if (!playerOptional.isPresent()) {
            return false;
        }

        playerConsumer.accept(playerOptional.get());
        return true;
    }

    public void openGUI(final GuiScreen gui) {
        Minecraft.getMinecraft().displayGuiScreen(gui);
    }
}
