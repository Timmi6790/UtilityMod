package de.timmi6790.utility.modules.server_tick_rate;

import java.util.concurrent.TimeUnit;

import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.Constants;
import de.timmi6790.utility.utils.MinecraftTimeUnit;
import lombok.Getter;

/**
 * Makes assumption of the server TPS based of the {@link net.minecraft.network.play.server.S03PacketTimeUpdate} packet that is normally send every second by the server.
 */
@Getter
public class ServerTickRateModule extends BaseModule
{
	private static final double ONE_SECOND_IN_NANO = TimeUnit.SECONDS.toNanos(1);

	private long tickSection = -1;

	private final RollingAverage tps10Seconds;
	private final RollingAverage tps1Minute;
	private final RollingAverage tps5Minutes;
	private final RollingAverage tps10Minutes;

	public ServerTickRateModule()
	{
		this.tps10Seconds = new RollingAverage(10, MinecraftTimeUnit.SECONDS);
		this.tps1Minute = new RollingAverage(1, MinecraftTimeUnit.MINUTES);
		this.tps5Minutes = new RollingAverage(5, MinecraftTimeUnit.MINUTES);
		this.tps10Minutes = new RollingAverage(10, MinecraftTimeUnit.MINUTES);

		registerListenerComponent(
				new ServerTickRateListener(this)
		);
	}

	void addNewTick()
	{
		final long time = System.nanoTime();

		// Start of the tick tracking
		if (this.tickSection == -1)
		{
			this.tickSection = time;
			return;
		}

		final long diff = time - this.tickSection;
		final double currentTps = ONE_SECOND_IN_NANO / diff * Constants.TICKS_PER_SECOND;
		this.tps10Seconds.add(currentTps, diff);
		this.tps1Minute.add(currentTps, diff);
		this.tps5Minutes.add(currentTps, diff);
		this.tps10Minutes.add(currentTps, diff);
		this.tickSection = time;
	}

	public void reset()
	{
		this.tickSection = -1;

		this.tps10Seconds.reset();
		this.tps1Minute.reset();
		this.tps5Minutes.reset();
		this.tps10Minutes.reset();
	}
}
