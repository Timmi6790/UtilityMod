package de.timmi6790.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ModuleManager {
    private final Map<Class<? extends Module>, Module> modules = new HashMap<>();

    public <T extends Module> Optional<T> getModule(final Class<T> clazz) {
        final T module = (T) this.modules.get(clazz);
        return Optional.ofNullable(module);
    }

    public void addModules(final boolean registerEvents, final Module... modules) {
        for (final Module module : modules) {
            this.addModule(module, registerEvents);
        }
    }

    public void addModule(final Module module, final boolean registerEvents) {
        try {
            log.debug("Loading module: " + module.getClass().getName() + " with registerEvents: " + registerEvents);
            module.enable();
            if (registerEvents) {
                module.registerEvents();
            }

            this.modules.put(module.getClass(), module);
        } catch (final Exception e) {
            log.error("Failed to load module: " + module.getClass().getName(), e);
        }
    }

    public void initialize() {
        for (final Module module : this.modules.values()) {
            try {
                log.debug("Register events for module: " + module.getClass().getName());
                module.registerEvents();
            } catch (final Exception e) {
                log.error(
                        "Failed to register events for module: "
                                + module.getClass().getName(),
                        e);
            }
        }
    }
}
