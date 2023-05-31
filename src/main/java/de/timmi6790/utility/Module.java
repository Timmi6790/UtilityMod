package de.timmi6790.utility;

import java.util.Optional;

public interface Module {
    default Optional<UtilityMod> getMod() {
        return Optional.ofNullable(UtilityMod.getInstance());
    }

    default <T extends Module> Optional<T> getModule(final Class<T> clazz) {
        return this.getMod().flatMap(mod -> mod.getModule(clazz));
    }


    default void enable() {

    }

    default void registerEvents() {

    }

    default void disable() {

    }
}
