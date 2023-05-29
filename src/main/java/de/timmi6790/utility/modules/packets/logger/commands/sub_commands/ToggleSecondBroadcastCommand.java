package de.timmi6790.utility.modules.packets.logger.commands.sub_commands;

import de.timmi6790.utility.modules.command.BaseCommand;
import de.timmi6790.utility.modules.packets.logger.PacketLoggerModule;
import net.minecraft.command.ICommandSender;

public class ToggleSecondBroadcastCommand extends BaseCommand {
    private final PacketLoggerModule module;

    public ToggleSecondBroadcastCommand(final PacketLoggerModule module) {
        super("toggleSecond");

        this.module = module;
    }

    @Override
    public void onCommand(final ICommandSender sender, final String[] args) {
        this.module.setSecondBroadcast(!this.module.isSecondBroadcast());
        if (this.module.isSecondBroadcast()) {
            this.tell("Enabled second broadcast");
        } else {
            this.tell("Disabled second broadcast");
        }
    }
}
