package de.timmi6790.utility.modules.packets.printer.commands;


import de.timmi6790.utility.modules.command.CommandGroup;
import de.timmi6790.utility.modules.packets.printer.PacketPrinterModule;
import de.timmi6790.utility.modules.packets.printer.commands.subcommands.AddCommand;
import de.timmi6790.utility.modules.packets.printer.commands.subcommands.ListCommand;
import de.timmi6790.utility.modules.packets.printer.commands.subcommands.PrintModeCommand;
import de.timmi6790.utility.modules.packets.printer.commands.subcommands.RemoveCommand;

public class PacketPrinterCommand extends CommandGroup {
    public PacketPrinterCommand(final PacketPrinterModule module) {
        super("packetPrinter");

        this.setPrefix("PacketPrinter");
        this.registerSubCommands(
                new AddCommand(module),
                new RemoveCommand(module),
                new ListCommand(module),
                new PrintModeCommand(module)
        );
    }
}
