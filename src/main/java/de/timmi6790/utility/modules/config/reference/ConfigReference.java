package de.timmi6790.utility.modules.config.reference;

import de.timmi6790.utility.UtilityMod;
import de.timmi6790.utility.modules.config.Config;
import de.timmi6790.utility.modules.config.ConfigModule;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
public class ConfigReference<T> {
    private final Function<Config, T> configValue;
    private Config config;

    private boolean ensureConfig() {
        if (this.config == null) {
            UtilityMod.getInstance().getModule(ConfigModule.class).ifPresent(
                    configModule -> this.config = configModule.getConfig()
            );
        }

        return config != null;
    }

    public Optional<T> get() {
        if (!this.ensureConfig()) {
            return Optional.empty();
        }

        return Optional.ofNullable(this.configValue.apply(this.config));
    }

    public T getOrDefault(T defaultValue) {
        return this.get().orElse(defaultValue);
    }
}
