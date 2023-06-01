package de.timmi6790.utility;

import de.timmi6790.utility.modules.barrier_view.BarrierViewModule;
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

@Mod(modid = Constants.MOD_ID)
@Log4j2
public class UtilityMod {
    @Getter
    @Mod.Instance(Constants.MOD_ID)
    private static UtilityMod instance;
    @Getter
    private final ModuleManager moduleManager = new ModuleManager();

    public UtilityMod() {
        this.moduleManager.addModules(
                false,
                new ConfigModule(),
                new ServerTickRateModule(),
                new PacketLoggerModule(),
                new PacketPrinterModule(),
                new CreativeTabModule(),
                new CrashFixModule(),
                new UpdateCheckerModule(),
                new TexturePackInfoModule(),
                new BarrierViewModule()
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

    @Mod.EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        this.moduleManager.initialize();
    }
}
