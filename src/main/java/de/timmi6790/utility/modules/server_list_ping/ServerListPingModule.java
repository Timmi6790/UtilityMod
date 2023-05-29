package de.timmi6790.utility.modules.server_list_ping;

import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.modules.config.Config;
import de.timmi6790.utility.modules.config.reference.ConfigReference;
import net.minecraft.client.gui.ServerListEntryNormal;

public class ServerListPingModule extends BaseModule {
    private static final int MIN_PINGS = 1;
    private static final int DEFAULT_PINGS = 100;

    private final ConfigReference<Integer> concurrentServerListPings = new ConfigReference<>(Config::getConcurrentServerListPings);

    private int getConcurrentServerListPings() {
        return Math.min(concurrentServerListPings.getOrDefault(DEFAULT_PINGS), MIN_PINGS);
    }

    private void enforcePingLimit() {
        ServerListEntryNormal.field_148302_b.setCorePoolSize(getConcurrentServerListPings());
    }

    @Override
    public void enable() {
        super.enable();

        enforcePingLimit();
    }
}
