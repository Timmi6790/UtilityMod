package de.timmi6790.utility.modules.config;

import java.nio.file.Paths;

import de.timmi6790.utility.Constants;
import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.Property;
import gg.essential.vigilance.data.PropertyType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Config extends Vigilant
{
	/*
	 * Crash Fix
	 */
	private static final String CRASH_CATEGORY = "Crash Fix";

	@Property(
			type = PropertyType.CHECKBOX,
			name = "Invalid Potion IDs",
			description = "Prevent invalid potion id crashes.",
			category = CRASH_CATEGORY
	)
	private boolean potionIdCrashFix = true;

	@Property(
			type = PropertyType.CHECKBOX,
			name = "Data Watcher",
			description = "Tries to prevent invalid data watcher crashes.",
			category = CRASH_CATEGORY
	)
	private boolean dataWatcherCrashFix = true;

	/*
	 * Update Checker
	 */
	@Property(
			type = PropertyType.CHECKBOX,
			name = "Check for Updates",
			description = "Check for updates on first server join.",
			category = "Update Checker"
	)
	private boolean checkForUpdatesOnServerJoin = true;

	public Config()
	{
		super(Paths.get(".", "config", Constants.MOD_ID + ".toml").toFile(), Constants.MOD_NAME + " Config");

		initialize();
	}
}
