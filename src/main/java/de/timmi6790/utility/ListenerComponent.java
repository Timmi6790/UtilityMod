package de.timmi6790.utility;

import de.timmi6790.utility.utils.EventUtils;

public interface ListenerComponent
{
	default void registerEvents()
	{
		EventUtils.registerEvents(this);
	}

	default void unregisterEvents()
	{
		EventUtils.unregisterEvents(this);
	}
}
