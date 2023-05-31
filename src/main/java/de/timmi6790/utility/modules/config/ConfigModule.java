package de.timmi6790.utility.modules.config;

import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.modules.config.commands.ConfigCommand;
import lombok.Getter;

public class ConfigModule extends BaseModule {
    @Getter
    private final Config config = new Config();

    public ConfigModule() {
        this.registerCommand(new ConfigCommand(this));
    }
}
