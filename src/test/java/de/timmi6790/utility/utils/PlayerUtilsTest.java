package de.timmi6790.utility.utils;

import net.minecraft.entity.player.EntityPlayer;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Optional;
import java.util.function.Consumer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class PlayerUtilsTest {
    @SuppressWarnings("checkstyle:RedundantModifier")
    @Test
    void consumePlayerFound() {
        try (final MockedStatic<PlayerUtils> utilities = mockStatic(PlayerUtils.class)) {
            final EntityPlayer player = mock(EntityPlayer.class);
            utilities.when(PlayerUtils::getPlayer).thenReturn(Optional.of(player));
            utilities.when(() -> PlayerUtils.consumePlayer(any())).thenCallRealMethod();

            final Consumer<EntityPlayer> runnable = mock(Consumer.class);

            PlayerUtils.consumePlayer(runnable);

            verify(runnable).accept(any());
        }
    }

    @SuppressWarnings("checkstyle:RedundantModifier")
    @Test
    void consumePlayerNotFound() {
        try (final MockedStatic<PlayerUtils> utilities = mockStatic(PlayerUtils.class)) {
            utilities.when(PlayerUtils::getPlayer).thenReturn(Optional.empty());
            utilities.when(() -> PlayerUtils.consumePlayer(any())).thenCallRealMethod();

            final Consumer<EntityPlayer> runnable = mock(Consumer.class);

            PlayerUtils.consumePlayer(runnable);

            verify(runnable, never()).accept(any());
        }
    }
}
