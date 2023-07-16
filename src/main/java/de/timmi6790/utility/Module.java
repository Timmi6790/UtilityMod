package de.timmi6790.utility;

import java.util.Optional;

public interface Module {
    default UtilityMod getMod() {
        return UtilityMod.getInstance();
    }

    default <T extends Module> Optional<T> getModule(final Class<T> clazz) {
        return this.getMod().getModuleManager().getModule(clazz);
    }

    default void enable() {
        // Nothing to do
    }

    default void registerEvents() {
        // Nothing to do
    }

    default void disable() {
        // Nothing to do
    }
}
