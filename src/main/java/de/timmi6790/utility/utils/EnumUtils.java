package de.timmi6790.utility.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.NonNull;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

/**
 * Enum utilities.
 */
@UtilityClass
public class EnumUtils {
    /**
     * Converts all enum value into a more readable name.
     *
     * @param enumValue the enum value
     * @return the pretty names
     */
    public static List<String> getPrettyNames(@NonNull final Enum[] enumValue) {
        return Arrays.stream(enumValue).map(EnumUtils::getPrettyName).collect(Collectors.toList());
    }

    /**
     * Converts a enum value into a neat formatted text. It will remove all _ characters and will also capitalize all
     * values after the first part. TEST_Value -> TestValue
     *
     * @param enumValue the enum value
     * @return the pretty name
     */
    public static String getPrettyName(@NonNull final Enum enumValue) {
        // Remove _ and capitalize after the first part
        final String[] nameParts = enumValue.name().split("_");
        final StringBuilder prettyName = new StringBuilder();
        for (final String namePart : nameParts) {
            prettyName.append(StringUtils.capitalize(namePart.toLowerCase()));
        }

        return prettyName.toString();
    }

    /**
     * Searches for the search string against the given enum values. All enum values are checked with their pretty name
     * {@link #getPrettyName(Enum)}}.
     *
     * @param <T>       the enum type
     * @param search    the search string
     * @param enumValue the enum value
     * @return the found enum value
     */
    public static <T extends Enum> Optional<T> getIgnoreCase(
            @NonNull final String search, @NonNull final T[] enumValue) {
        return Arrays.stream(enumValue)
                .filter(value -> getPrettyName(value).equalsIgnoreCase(search))
                .findAny();
    }
}
