package de.timmi6790.utility.modules.packets.logger.commands.sub_commands;

import de.timmi6790.utility.modules.command.BaseCommand;
import de.timmi6790.utility.modules.packets.logger.PacketLoggerModule;
import de.timmi6790.utility.utils.VerifyUtils;
import net.minecraft.command.ICommandSender;

public class SetPacketShowCountCommand extends BaseCommand {
    private final PacketLoggerModule module;

    public SetPacketShowCountCommand(final PacketLoggerModule module) {
        super("setShowCount");

        this.module = module;

        this.setSyntax("<count>");
        this.setMinArgs(1);
    }

    @Override
    public void onCommand(final ICommandSender sender, final String[] args) {
        if (!VerifyUtils.isInt(args[0])) {
            this.returnTellInvalidArgument(args[0], "Integer");
            return;
        }

        final int newValue = Integer.parseInt(args[0]);
        this.module.setPacketShowCount(newValue);
        this.tell("Set packet show count to " + newValue);
    }
}
