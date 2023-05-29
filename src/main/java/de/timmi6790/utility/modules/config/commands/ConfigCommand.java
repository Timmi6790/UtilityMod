package de.timmi6790.utility.modules.config.commands;

import de.timmi6790.utility.Constants;
import de.timmi6790.utility.modules.command.BaseCommand;
import de.timmi6790.utility.modules.config.ConfigModule;
import de.timmi6790.utility.utils.PlayerUtils;
import de.timmi6790.utility.utils.TaskScheduler;
import net.minecraft.command.ICommandSender;

public class ConfigCommand extends BaseCommand {
    private final ConfigModule module;

    public ConfigCommand(ConfigModule module) {
        super(Constants.MOD_ID + "Config");

        this.module = module;
    }

    @Override
    public void onCommand(ICommandSender sender, String[] args) {
        TaskScheduler.getInstance().schedule(
                1,
                () -> PlayerUtils.openGUI(module.getConfig().gui())
        );
    }
}
