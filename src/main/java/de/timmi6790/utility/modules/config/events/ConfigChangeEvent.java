package de.timmi6790.utility.modules.config.events;

import de.timmi6790.utility.modules.config.Config;
import gg.essential.vigilance.data.Property;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.lang.reflect.Field;

@EqualsAndHashCode(callSuper = true)
@Data
public class ConfigChangeEvent extends Event {
    private final Config config;
    private final Field field;
    private final Object newValue;

    public Property getProperty() {
        return this.getField().getAnnotation(Property.class);
    }
}
