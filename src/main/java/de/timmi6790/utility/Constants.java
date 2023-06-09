package de.timmi6790.utility;

import de.timmi6790.utility.utils.MinecraftTimeUnit;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Constants {
    public static final String MOD_ID = "utilitymod";
    public static final String MOD_NAME = "UtilityMod";
    public static final int TICKS_PER_SECOND = (int) MinecraftTimeUnit.SECONDS.toTicks(1);
    public static final String GITHUB_REPO = "Timmi6790/UtilityMod";
}
