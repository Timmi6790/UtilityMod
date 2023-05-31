package de.timmi6790.utility.utils;

import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class VerifyUtils {
    private static final Pattern BOOLEAN_PATTERN = Pattern.compile("true|false", Pattern.CASE_INSENSITIVE);

    public boolean isInt(final Object value) {
        try {
            Integer.parseInt(String.valueOf(value));
            return true;
        } catch (final NumberFormatException ignore) {
            return false;
        }
    }

    public boolean isDouble(final Object value) {
        try {
            Double.parseDouble(String.valueOf(value));
            return true;
        } catch (final NumberFormatException ignore) {
            return false;
        }
    }

    public boolean isFloat(final Object value) {
        try {
            Float.parseFloat(String.valueOf(value));
            return true;
        } catch (final NumberFormatException ignore) {
            return false;
        }
    }

    public boolean isBoolean(final Object value) {
        return BOOLEAN_PATTERN.matcher(String.valueOf(value)).matches();
    }

    public boolean hasEmptyArg(final String[] args, final int position) {
        return args.length == position + 1 && args[position].isEmpty();
    }
}
