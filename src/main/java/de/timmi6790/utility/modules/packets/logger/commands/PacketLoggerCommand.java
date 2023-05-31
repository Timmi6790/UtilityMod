package de.timmi6790.utility.modules.packets.logger.commands;

import de.timmi6790.utility.modules.command.CommandGroup;
import de.timmi6790.utility.modules.packets.logger.PacketLoggerModule;
import de.timmi6790.utility.modules.packets.logger.commands.sub_commands.ResetTotalCommand;
import de.timmi6790.utility.modules.packets.logger.commands.sub_commands.SetPacketShowCountCommand;
import de.timmi6790.utility.modules.packets.logger.commands.sub_commands.SortModeCommand;
import de.timmi6790.utility.modules.packets.logger.commands.sub_commands.ToggleSecondBroadcastCommand;
import de.timmi6790.utility.modules.packets.logger.commands.sub_commands.TotalLogCommand;

public class PacketLoggerCommand extends CommandGroup {
    public PacketLoggerCommand(final PacketLoggerModule module) {
        super("packetLogger");

        this.setPrefix("PacketLogger");
        this.registerSubCommands(
                new SortModeCommand(module),
                new TotalLogCommand(module),
                new ToggleSecondBroadcastCommand(module),
                new SetPacketShowCountCommand(module),
                new ResetTotalCommand(module)
        );
    }
}
