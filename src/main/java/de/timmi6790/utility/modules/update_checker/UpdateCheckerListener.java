package de.timmi6790.utility.modules.update_checker;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import de.timmi6790.utility.ListenerComponent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateCheckerListener implements ListenerComponent
{
	private final UpdateCheckerModule module;
	private boolean checked = false;

	@SubscribeEvent
	public void onServerJoin(final FMLNetworkEvent.ClientConnectedToServerEvent event)
	{
		// Only check once on server join
		if (checked)
		{
			return;
		}

		checked = true;
		module.checkForUpdates();
	}
}
