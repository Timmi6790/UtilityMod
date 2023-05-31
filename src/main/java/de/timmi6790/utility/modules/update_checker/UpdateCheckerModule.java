package de.timmi6790.utility.modules.update_checker;

import com.google.gson.Gson;
import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.Constants;
import de.timmi6790.utility.UtilityMod;
import de.timmi6790.utility.utils.MessageBuilder;
import de.timmi6790.utility.utils.MinecraftTimeUnit;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import net.minecraft.event.ClickEvent;
import net.minecraft.util.EnumChatFormatting;
import org.apache.commons.io.IOUtils;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.CompletableFuture;

@Log4j2
public class UpdateCheckerModule extends BaseModule {
    private static final String REPO_INFO_URL = "https://api.github.com/repos/%s/releases/latest";

    public UpdateCheckerModule() {
        this.registerListenerComponents(
                new UpdateCheckerListener(this)
        );
    }

    public void checkForUpdates() {
        log.debug("Checking for updates");

        try {
            final VersionData latestVersion = this.getLastVersion().get();
            final String currentVersion = UtilityMod.getVersion();
            if (this.hasNewVersion(currentVersion, latestVersion.getVersion())) {
                MessageBuilder.of(Constants.MOD_NAME, EnumChatFormatting.YELLOW)
                        .addMessage("\n\nA new version is available!", EnumChatFormatting.GRAY)
                        .addMessage("\nCurrent version: ", EnumChatFormatting.GRAY)
                        .addMessage(currentVersion, EnumChatFormatting.YELLOW)
                        .addMessage("\nNew version: ", EnumChatFormatting.GRAY)
                        .addMessage(latestVersion.getVersion(), EnumChatFormatting.YELLOW)
                        .addMessage(
                                MessageBuilder.of("\nClick me to find the new version", EnumChatFormatting.YELLOW)
                                        .addClickEvent(ClickEvent.Action.OPEN_URL, latestVersion.getDownloadUrl())
                        )
                        .addBoxToMessage()
                        .sendToPlayerDelayed(45, MinecraftTimeUnit.TICKS);
            }
        } catch (final Exception ignore) {
            log.error("Failed to check for updates", ignore);
        }
    }

    private CompletableFuture<VersionData> getLastVersion() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                final URL url = new URL(String.format(REPO_INFO_URL, Constants.GITHUB_REPO));
                final String json = IOUtils.toString(url, StandardCharsets.UTF_8);

                final Gson gson = new Gson();
                final Map<String, String> map = gson.fromJson(json, Map.class);

                return new VersionData(
                        map.get("tag_name"),
                        map.get("html_url")
                );
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private String getTokenOrDefault(final StringTokenizer tokenizer, final String defaultValue) {
        if (tokenizer.hasMoreTokens()) {
            return tokenizer.nextToken();
        }

        return defaultValue;
    }

    public boolean hasNewVersion(@NonNull final String currentVersion, @NonNull final String newVersion) {
        final StringTokenizer currentVersionToken = new StringTokenizer(currentVersion, ".");
        final StringTokenizer newVersionToken = new StringTokenizer(newVersion, ".");

        while (currentVersionToken.hasMoreTokens() || newVersionToken.hasMoreElements()) {
            final String currentPart = this.getTokenOrDefault(currentVersionToken, "0");
            final String newPart = this.getTokenOrDefault(newVersionToken, "0");

            final int compareValue = newPart.compareTo(currentPart);
            if (compareValue > 0) {
                return true;
            } else if (compareValue < 0) {
                return false;
            }
        }

        // Equal versions
        return false;
    }

    @Data
    private static class VersionData {
        private final String version;
        private final String downloadUrl;
    }
}
