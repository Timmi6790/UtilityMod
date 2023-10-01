package de.timmi6790.utility;

import lombok.Getter;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilityMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Utilitymod");

    @Getter
    private static UtilityMod instance = null;

    public static String getVersion() {
        String version = UtilityMod.class.getPackage().getImplementationVersion();

        // The version is not available when running in an IDE
        if (version == null) {
            version = "0.0.0";
        }

        return version;
    }

    @Getter
    private final ModuleManager moduleManager = new ModuleManager();

    public UtilityMod() {
        instance = this;
    }

    @Override
    public void onInitialize(final ModContainer mod) {
        this.moduleManager.initialize();
    }
}
