package de.timmi6790.utility;

public interface ListenerComponent {
    default void registerEvents() {
        throw new UnsupportedOperationException();
    }

    default void unregisterEvents() {
        throw new UnsupportedOperationException();
    }
}
