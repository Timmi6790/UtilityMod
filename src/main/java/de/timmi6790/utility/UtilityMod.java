package de.timmi6790.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import de.timmi6790.utility.modules.server_tick_rate.ServerTickRateModule;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Mod(modid = Constants.MOD_ID)
@Log4j2
public class UtilityMod
{
	@Getter
	@Mod.Instance(Constants.MOD_ID)
	private static UtilityMod instance;

	private final Map<Class<? extends Module>, Module> modules = new HashMap<>();

	public UtilityMod()
	{
		this.addModules(
				false,
				new ServerTickRateModule()
		);
	}

	public <T extends Module> Optional<T> getModule(final Class<T> clazz)
	{
		final T module = (T) this.modules.get(clazz);
		return Optional.ofNullable(module);
	}

	void addModules(final boolean registerEvents, final Module... modules)
	{
		for (final Module module : modules)
		{
			this.addModule(module, registerEvents);
		}
	}

	void addModule(final Module module, final boolean registerEvents)
	{
		try
		{
			log.debug("Loading module: " + module.getClass().getName() + " with registerEvents: " + registerEvents);
			module.enable();
			if (registerEvents)
			{
				module.registerEvents();
			}

			this.modules.put(module.getClass(), module);
		}
		catch (final Exception e)
		{
			log.error("Failed to load module: " + module.getClass().getName(), e);
		}
	}

	@Mod.EventHandler
	public void preInit(final FMLPreInitializationEvent event)
	{
		for (final Module module : this.modules.values())
		{
			try
			{
				log.debug("Register events for module: " + module.getClass().getName());
				module.registerEvents();
			}
			catch (final Exception e)
			{
				log.error("Failed to register events for module: " + module.getClass().getName(), e);
			}
		}
	}
}
