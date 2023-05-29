package de.timmi6790.utility.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MathUtils {
    public double calculatePercentage(final int total, final int value) {
        if (total == 0 || value == 0) {
            return 0;
        }

        return value * 100D / total;
    }
}
