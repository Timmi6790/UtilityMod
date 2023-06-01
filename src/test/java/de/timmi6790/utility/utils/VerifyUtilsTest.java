package de.timmi6790.utility.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class VerifyUtilsTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "90000"})
    void isIntValid(final String value) {
        assertThat(VerifyUtils.isInt(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"String", "0.0", ""})
    void isIntInvalid(final String value) {
        assertThat(VerifyUtils.isInt(value)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "0.0", "-1.111111111", "90000.999999"})
    void isDoubleValid(final String value) {
        assertThat(VerifyUtils.isDouble(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"String", ""})
    void isDoubleInvalid(final String value) {
        assertThat(VerifyUtils.isDouble(value)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "0.0", "-1.111", "90000.999"})
    void isFloatValid(final String value) {
        assertThat(VerifyUtils.isFloat(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"String", ""})
    void isFloatInvalid(final String value) {
        assertThat(VerifyUtils.isFloat(value)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"true", "false", "TRUE", "FALSE"})
    void isBooleanValid(final String value) {
        assertThat(VerifyUtils.isBoolean(value)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"String", "", "0"})
    void isBooleanInvalid(final String value) {
        assertThat(VerifyUtils.isBoolean(value)).isFalse();
    }

    @Test
    void hasEmptyArg() {
        assertThat(VerifyUtils.hasEmptyArg(Arrays.asList("a", "b").toArray(new String[0]), 1)).isFalse();

        assertThat(VerifyUtils.hasEmptyArg(Arrays.asList("a", "b", "").toArray(new String[0]), 2)).isTrue();
    }
}
