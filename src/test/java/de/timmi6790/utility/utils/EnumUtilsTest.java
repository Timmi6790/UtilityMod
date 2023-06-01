package de.timmi6790.utility.utils;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class EnumUtilsTest {
    @Test
    void getPrettyNames() {
        final List<String> prettyNames = EnumUtils.getPrettyNames(TestEnum.values());
        assertThat(prettyNames).containsExactly("TestValue", "TestValue2", "TestValue3");
    }

    @Test
    void getPrettyName() {
        final String prettyName = EnumUtils.getPrettyName(TestEnum.TEST_VALUE);
        assertThat(prettyName).isEqualTo("TestValue");
    }

    @Test
    void getIgnoreCase() {
        final TestEnum testEnum = EnumUtils.getIgnoreCase("testValue", TestEnum.values()).orElse(null);
        assertThat(testEnum).isEqualTo(TestEnum.TEST_VALUE);
    }

    @Test
    void getIgnoreCaseInvalidInput() {
        final Optional<TestEnum> testEnum = EnumUtils.getIgnoreCase("asddsasdsad", TestEnum.values());
        assertThat(testEnum).isEmpty();
    }

    private enum TestEnum {
        TEST_VALUE,
        TEST_VALUE_2,
        TEST_VALUE_3
    }
}
