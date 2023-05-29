package de.timmi6790.utility.modules.server_tick_rate;

import com.google.common.base.Preconditions;
import de.timmi6790.utility.Constants;
import de.timmi6790.utility.utils.MinecraftTimeUnit;

import java.util.concurrent.TimeUnit;

/**
 * Slightly modified version of the paper implementation
 */
public class RollingAverage {
    private static final long ONE_SECOND_IN_NANO = TimeUnit.SECONDS.toNanos(1);
    private static final long TICKS_PER_SECOND_IN_NANO = MinecraftTimeUnit.SECONDS.toNanos(Constants.TICKS_PER_SECOND);

    private final int size;
    private final double[] samples;
    private final long[] times;
    private long time;
    private double total;
    private int index = 0;

    RollingAverage(final int time, final MinecraftTimeUnit timeunit) {
        this.size = (int) MinecraftTimeUnit.SECONDS.convert(time, timeunit);
        Preconditions.checkArgument(this.size > 0, "Size must be greater than 0");

        this.samples = new double[this.size];
        this.times = new long[this.size];

        this.reset();
    }

    public void reset() {
        this.index = 0;
        this.time = this.size * ONE_SECOND_IN_NANO;
        this.total = (TICKS_PER_SECOND_IN_NANO * this.size);
        for (int index = 0; index < this.size; index++) {
            this.samples[index] = Constants.TICKS_PER_SECOND;
            this.times[index] = ONE_SECOND_IN_NANO;
        }
    }

    public void add(final double x, final long t) {
        this.time -= this.times[this.index];
        this.total -= this.samples[this.index] * this.times[this.index];
        this.samples[this.index] = x;
        this.times[this.index] = t;
        this.time += t;
        this.total += x * t;
        this.index = (this.index + 1) % this.size;
    }

    public double getAverage() {
        return this.total / this.time;
    }
}
