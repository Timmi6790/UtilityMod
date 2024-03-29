package de.timmi6790.utility.modules.config.reference;

import de.timmi6790.utility.UtilityMod;
import de.timmi6790.utility.modules.config.Config;
import de.timmi6790.utility.modules.config.ConfigModule;
import java.util.Optional;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConfigReference<T> {
    private final Function<Config, T> configValue;
    private Config config;

    private boolean ensureConfig() {
        if (this.config == null) {
            UtilityMod.getInstance()
                    .getModuleManager()
                    .getModule(ConfigModule.class)
                    .ifPresent(configModule -> this.config = configModule.getConfig());
        }

        return this.config != null;
    }

    public Optional<T> get() {
        if (!this.ensureConfig()) {
            return Optional.empty();
        }

        return Optional.ofNullable(this.configValue.apply(this.config));
    }

    public T getOrDefault(final T defaultValue) {
        return this.get().orElse(defaultValue);
    }
}
