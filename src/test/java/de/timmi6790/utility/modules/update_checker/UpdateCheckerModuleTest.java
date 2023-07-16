package de.timmi6790.utility.modules.update_checker;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;
import org.junit.jupiter.api.Test;

class UpdateCheckerModuleTest {
    private void checkVersion(final String currentVersion, final String newVersion, final boolean expected) {
        final UpdateCheckerModule updateCheckerModule = new UpdateCheckerModule();
        assertThat(updateCheckerModule.hasNewVersion(currentVersion, newVersion))
                .isEqualTo(expected);
    }

    @Test
    void hasNewVersion() {
        // Same version
        this.checkVersion("1.0.0", "1.0.0", false);

        // Patch update
        this.checkVersion("1.0.0", "1.0.1", true);
        this.checkVersion("1.0.1", "1.0.0", false);

        this.checkVersion("1.0.7", "1.0.9", true);
        this.checkVersion("1.0.9", "1.0.7", false);

        this.checkVersion("1.0.77", "1.0.9", true);
        this.checkVersion("1.0.9", "1.0.77", false);

        // Minor update
        this.checkVersion("1.0.0", "1.1.0", true);
        this.checkVersion("1.1.0", "1.0.0", false);

        this.checkVersion("1.0.0", "1.7.0", true);
        this.checkVersion("1.7.0", "1.0.0", false);

        this.checkVersion("1.0.0", "1.77.0", true);
        this.checkVersion("1.77.0", "1.0.0", false);

        // Major update
        this.checkVersion("1.0.0", "2.0.0", true);
        this.checkVersion("2.0.0", "1.0.0", false);

        this.checkVersion("1.0.0", "7.0.0", true);
        this.checkVersion("7.0.0", "1.0.0", false);

        this.checkVersion("1.0.0", "77.0.0", true);
        this.checkVersion("77.0.0", "1.0.0", false);
    }

    @Test
    void getLatestVersion() {
        final UpdateCheckerModule updateCheckerModule = spy(UpdateCheckerModule.class);

        // We can assume that the current version is always 0.0.0 during the tests
        final UpdateCheckerModule.VersionData newVersion = new UpdateCheckerModule.VersionData("1.0.0", "");
        when(updateCheckerModule.getLastVersion()).thenReturn(CompletableFuture.completedFuture(newVersion));
        doNothing().when(updateCheckerModule).sendNewVersionMessage(any(), any());

        updateCheckerModule.checkForUpdates();

        verify(updateCheckerModule).sendNewVersionMessage(any(), eq(newVersion));
    }
}
