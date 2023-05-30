package de.timmi6790.utility;

import de.timmi6790.utility.modules.config.ConfigModule;
import de.timmi6790.utility.modules.crash_fix.CrashFixModule;
import de.timmi6790.utility.modules.creative_tab.CreativeTabModule;
import de.timmi6790.utility.modules.packets.logger.PacketLoggerModule;
import de.timmi6790.utility.modules.packets.printer.PacketPrinterModule;
import de.timmi6790.utility.modules.server_tick_rate.ServerTickRateModule;
import de.timmi6790.utility.modules.texture_pack_info.TexturePackInfoModule;
import de.timmi6790.utility.modules.update_checker.UpdateCheckerModule;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Mod(modid = Constants.MOD_ID)
@Log4j2
public class UtilityMod {
    @Getter
    @Mod.Instance(Constants.MOD_ID)
    private static UtilityMod instance;
    private final Map<Class<? extends Module>, Module> modules = new HashMap<>();

    public UtilityMod() {
        this.addModules(
                false,
                new ConfigModule(),
                new ServerTickRateModule(),
                new PacketLoggerModule(),
                new PacketPrinterModule(),
                new CreativeTabModule(),
                new CrashFixModule(),
                new UpdateCheckerModule(),
                new TexturePackInfoModule()
        );
    }

    public static String getVersion() {
        String version = UtilityMod.class.getPackage().getImplementationVersion();

        // The version is not available when running in an IDE
        if (version == null) {
            version = "0.0.0";
        }

        return version;
    }

    public <T extends Module> Optional<T> getModule(final Class<T> clazz) {
        final T module = (T) this.modules.get(clazz);
        return Optional.ofNullable(module);
    }

    void addModules(final boolean registerEvents, final Module... modules) {
        for (final Module module : modules) {
            this.addModule(module, registerEvents);
        }
    }

    void addModule(final Module module, final boolean registerEvents) {
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

    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        for (final Module module : this.modules.values()) {
            try {
                log.debug("Register events for module: " + module.getClass().getName());
                module.registerEvents();
            } catch (final Exception e) {
                log.error("Failed to register events for module: " + module.getClass().getName(), e);
            }
        }
    }
}
