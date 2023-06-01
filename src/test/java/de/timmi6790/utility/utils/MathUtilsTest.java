package de.timmi6790.utility.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MathUtilsTest {
    @Test
    void calculatePercentage() {
        final double result = MathUtils.calculatePercentage(100, 10);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void calculatePercentageTotalZeroInput() {
        final double result = MathUtils.calculatePercentage(0, 100);
        assertThat(result).isZero();
    }

    @Test
    void calculatePercentageValueZeroInput() {
        final double result = MathUtils.calculatePercentage(2, 0);
        assertThat(result).isZero();
    }
}
