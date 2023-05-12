package de.timmi6790.utility;

import java.util.ArrayList;
import java.util.List;

import de.timmi6790.utility.modules.command.BaseCommand;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BaseModule implements Module
{
	private final List<ListenerComponent> listenerComponents = new ArrayList<>();
	private final List<BaseCommand> commands = new ArrayList<>();

	protected void registerListenerComponents(final ListenerComponent... listenerComponents)
	{
		for (final ListenerComponent listenerComponent : listenerComponents)
		{
			this.registerListenerComponent(listenerComponent);
		}
	}

	protected void registerListenerComponent(final ListenerComponent listenerComponent)
	{
		this.listenerComponents.add(listenerComponent);
	}

	protected void registerCommands(final BaseCommand... commands)
	{
		for (final BaseCommand command : commands)
		{
			this.registerCommand(command);
		}
	}

	protected void registerCommand(final BaseCommand command)
	{
		this.commands.add(command);
	}

	@Override
	public void enable()
	{
		log.debug("Enabling module {}.", this.getClass().getSimpleName());
		for (final BaseCommand command : this.commands)
		{
			try
			{
				log.debug("Registering command {} in module {}.", command.getCommandName(), this.getClass().getSimpleName());
				command.register();
			}
			catch (Exception e)
			{
				log.error("Failed to register command: " + command.getCommandName(), e);
			}
		}
	}

	@Override
	public void registerEvents()
	{
		log.debug("Registering events in module {}.", this.getClass().getSimpleName());
		for (final ListenerComponent listenerComponent : this.listenerComponents)
		{
			try
			{
				log.debug("Registering listener component {} in module {}.", listenerComponent.getClass().getSimpleName(), this.getClass().getSimpleName());
				listenerComponent.registerEvents();
			}
			catch (Exception e)
			{
				log.error("Failed to register listener component: " + listenerComponent.getClass().getSimpleName(), e);
			}
		}
	}

	@Override
	public void disable()
	{
		log.debug("Disabling module {}.", this.getClass().getSimpleName());
		for (final ListenerComponent listenerComponent : this.listenerComponents)
		{
			try
			{
				log.debug("Unregistering listener component {} in module {}.", listenerComponent.getClass().getSimpleName(), this.getClass().getSimpleName());
				listenerComponent.unregisterEvents();
			}
			catch (Exception e)
			{
				log.error("Failed to unregister listener component: " + listenerComponent.getClass().getSimpleName(), e);
			}
		}
		listenerComponents.clear();

		for (final BaseCommand command : this.commands)
		{
			try
			{
				log.debug("Unregistering command {} in module {}.", command.getCommandName(), this.getClass().getSimpleName());
				command.unregister();
			}
			catch (Exception e)
			{
				log.error("Failed to unregister command: " + command.getCommandName(), e);
			}
		}
		commands.clear();
	}
}
