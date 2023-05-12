package de.timmi6790.utility;

import java.util.ArrayList;
import java.util.List;

import de.timmi6790.utility.modules.command.BaseCommand;

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
		for (final BaseCommand command : this.commands)
		{
			command.register();
		}
	}

	@Override
	public void registerEvents()
	{
		for (final ListenerComponent listenerComponent : this.listenerComponents)
		{
			listenerComponent.registerEvents();
		}
	}

	@Override
	public void disable()
	{
		for (final ListenerComponent listenerComponent : this.listenerComponents)
		{
			listenerComponent.unregisterEvents();
		}

		for (final BaseCommand command : this.commands)
		{
			command.unregister();
		}
	}
}
