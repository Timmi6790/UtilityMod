package de.timmi6790.utility.modules.server_tick_rate;

import de.timmi6790.utility.ListenerComponent;
import de.timmi6790.utility.modules.core.events.PacketReceiveEvent;
import lombok.RequiredArgsConstructor;
import net.minecraft.network.play.server.S03PacketTimeUpdate;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

@RequiredArgsConstructor
public class ServerTickRateListener implements ListenerComponent {
    private final ServerTickRateModule serverTickRate;

    @SubscribeEvent
    public void updateTick(final PacketReceiveEvent.Post event) {
        if (event.getPacket() instanceof S03PacketTimeUpdate) {
            this.serverTickRate.addNewTick();
        }
    }

    @SubscribeEvent
    public void onServerJoin(final FMLNetworkEvent.ClientConnectedToServerEvent event) {
        this.serverTickRate.reset();
    }

	/*
	@SubscribeEvent
	public void tickDebugMessage(final TickEvent.ClientTickEvent event)
	{
		if (event.phase != TickEvent.Phase.START)
		{
			return;
		}

		if (Minecraft.getMinecraft().thePlayer == null)
		{
			return;
		}

		Minecraft.getMinecraft().thePlayer.addChatMessage(
				new ChatComponentText(String.format(
						"10s: %.2f, 1m: %.2f, 5m: %.2f, 10m: %.2f, 15m: %.2f",
						this.serverTickRate.getTps10Seconds().getAverage(),
						this.serverTickRate.getTps1Minute().getAverage(),
						this.serverTickRate.getTps5Minutes().getAverage(),
						this.serverTickRate.getTps5Minutes().getAverage(),
						this.serverTickRate.getTps10Minutes().getAverage()
				))
		);
	}
	 */
}
