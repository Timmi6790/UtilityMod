package de.timmi6790.utility.modules.update_checker;

import de.timmi6790.utility.ListenerComponent;
import de.timmi6790.utility.modules.config.Config;
import de.timmi6790.utility.modules.config.reference.ConfigReference;
import lombok.RequiredArgsConstructor;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

@RequiredArgsConstructor
public class UpdateCheckerListener implements ListenerComponent {
    private final UpdateCheckerModule module;

    private final ConfigReference<Boolean> checkOnJoin = new ConfigReference<>(Config::isCheckForUpdatesOnServerJoin);
    private boolean checked = false;

    @SubscribeEvent
    public void onServerJoin(final FMLNetworkEvent.ClientConnectedToServerEvent event) {
        if (!checkOnJoin.getOrDefault(false)) {
            return;
        }

        // Only check once on server join
        if (checked) {
            return;
        }

        checked = true;
        module.checkForUpdates();
    }
}
