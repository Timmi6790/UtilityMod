package de.timmi6790.utility.modules.config;

import de.timmi6790.utility.Constants;
import de.timmi6790.utility.modules.config.events.ConfigChangeEvent;
import de.timmi6790.utility.utils.EventUtils;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@Log4j2
public class Config extends Vigilant {
    /*
     * Crash Fix
     */
    private static final String CRASH_CATEGORY = "Crash Fix";

    @Property(
            type = PropertyType.SWITCH,
            name = "Invalid Potion IDs",
            description = "Prevent invalid potion id crashes.",
            category = CRASH_CATEGORY)
    private boolean potionIdCrashFix = true;

    @Property(
            type = PropertyType.SWITCH,
            name = "Data Watcher",
            description = "Tries to prevent invalid data watcher crashes.",
            category = CRASH_CATEGORY)
    private boolean dataWatcherCrashFix = true;

    /*
     * Update Checker
     */
    @Property(
            type = PropertyType.SWITCH,
            name = "Check for Updates",
            description = "Check for updates on first server join.",
            category = "Update Checker")
    private boolean checkForUpdatesOnServerJoin = true;

    /*
     * Texture Pack Info
     */
    @Property(
            type = PropertyType.SWITCH,
            name = "Show Texture Pack Information",
            description = "Show texture pack information on receive.",
            category = "Texture Pack Info")
    private boolean showTexturePackInformation = true;

    /*
     * Barrier View
     */
    @Property(
            type = PropertyType.SWITCH,
            name = "Barrier Visibility",
            description = "Make Barrier blocks visible.",
            category = "Barrier View")
    private boolean visibleBarrierBlock = true;

    public Config() {
        super(Paths.get(".", "config", Constants.MOD_ID + ".toml").toFile(), Constants.MOD_NAME + " Config");

        this.initialize();

        // Register all fields to post a ConfigChangeEvent when the value changed
        for (final Field field : this.getClass().getDeclaredFields()) {
            if (field.getAnnotation(Property.class) == null) {
                continue;
            }

            try {
                this.registerListener(
                        field, newValue -> EventUtils.postEventSave(new ConfigChangeEvent(this, field, newValue)));
            } catch (final Exception e) {
                log.error("Can't register config change listener for field: " + field.getName(), e);
            }
        }
    }

    private Optional<Property> getProperty(final String fieldName) {
        try {
            return Optional.ofNullable(
                    this.getClass().getDeclaredField(fieldName).getAnnotation(Property.class));
        } catch (final NoSuchFieldException e) {
            log.error("Can't find field: " + fieldName, e);
            return Optional.empty();
        }
    }

    public Property getVisibleBarrierBlockProperty() {
        return this.getProperty("visibleBarrierBlock")
                .orElseThrow(() -> new RuntimeException("Can't find visibleBarrierBlock field"));
    }
}
