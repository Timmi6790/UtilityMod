package de.timmi6790.utility.modules.packets.logger.commands.sub_commands;

import de.timmi6790.utility.modules.command.BaseCommand;
import de.timmi6790.utility.modules.packets.logger.PacketLoggerModule;
import de.timmi6790.utility.modules.packets.logger.PacketSortMode;
import de.timmi6790.utility.utils.EnumUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;

public class SortModeCommand extends BaseCommand {
    private final PacketLoggerModule module;

    public SortModeCommand(final PacketLoggerModule module) {
        super("sortMode");

        this.module = module;

        this.setSyntax("<" + String.join("|", EnumUtils.getPrettyNames(PacketSortMode.values())) + ">");
        this.setMinArgs(1);
    }

    @Override
    public void onCommand(final ICommandSender sender, final String[] args) {
        final Optional<PacketSortMode> sortMode = EnumUtils.getIgnoreCase(args[0], PacketSortMode.values());
        if (sortMode.isPresent()) {
            this.module.setSortMode(sortMode.get());
            this.tell("Set sort mode to " + EnumUtils.getPrettyName(sortMode.get()));
        } else {
            this.tell("No valid sort mode found");
        }
    }

    @Override
    public List<String> addTabCompletionOptions(final ICommandSender sender, final String[] args, final BlockPos pos) {
        if (args.length != 1) {
            return new ArrayList<>();
        }

        return this.getTabCompleteOptions(EnumUtils.getPrettyNames(PacketSortMode.values()), args[0]);
    }
}
