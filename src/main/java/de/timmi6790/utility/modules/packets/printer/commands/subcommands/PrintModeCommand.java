package de.timmi6790.utility.modules.packets.printer.commands.subcommands;

import de.timmi6790.utility.modules.packets.printer.PacketPrinterModule;
import de.timmi6790.utility.modules.packets.printer.PrintMode;
import de.timmi6790.utility.utils.EnumUtils;
import de.timmi6790.utility.utils.MessageBuilder;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class PrintModeCommand extends AbstractPacketPrinterCommand {
    public PrintModeCommand(final PacketPrinterModule module) {
        super(module, "printMode", Collections.singletonList("pm"));

        this.setMinArgs(1);
        this.setSyntax("<printMode>");
    }

    @Override
    public void onCommand(final ICommandSender sender, final String[] args) {
        final String argument = args[0];

        final Optional<PrintMode> printModeOpt = EnumUtils.getIgnoreCase(argument, PrintMode.values());
        if (!printModeOpt.isPresent()) {
            this.tell(
                    MessageBuilder.of(argument, EnumChatFormatting.YELLOW)
                            .addMessage(" is not a valid argument.")
            );
            return;
        }

        this.getModule().setPrintMode(printModeOpt.get());
        this.tell(
                MessageBuilder.of("Set print mode to ", EnumChatFormatting.GRAY)
                        .addMessage(argument, EnumChatFormatting.YELLOW)
                        .addMessage(".", EnumChatFormatting.GRAY)
        );
    }

    @Override
    public List<String> addTabCompletionOptions(final ICommandSender sender, final String[] args, final BlockPos pos) {
        if (args.length == 1) {
            return this.getTabCompleteOptions(EnumUtils.getPrettyNames(PrintMode.values()), args[0]);
        }

        return new ArrayList<>();
    }
}
