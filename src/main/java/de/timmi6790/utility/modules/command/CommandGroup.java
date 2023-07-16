package de.timmi6790.utility.modules.command;

import de.timmi6790.utility.utils.MessageBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import org.apache.commons.lang3.StringUtils;

public class CommandGroup extends BaseCommand {
    @Getter
    private final List<BaseCommand> subCommands = new ArrayList<>();
    /**
     * Stores the pre command group names, used for the help command
     */
    @Setter(AccessLevel.PACKAGE)
    private String preCommand;

    public CommandGroup(final String commandName) {
        super(commandName);
    }

    @Override
    public List<String> addTabCompletionOptions(final ICommandSender sender, final String[] args, final BlockPos pos) {
        final String firstArg = args[0];
        if (args.length == 1) {
            final List<String> tabCompletion = new ArrayList<>();
            final String argLower = firstArg.toLowerCase();
            for (final BaseCommand command : this.subCommands) {
                if (command.getCommandName().toLowerCase().startsWith(argLower)) {
                    tabCompletion.add(command.getCommandName());
                }
                tabCompletion.addAll(this.getTabCompleteOptions(command.getCommandAliases(), firstArg));
            }
            return tabCompletion;
        }

        final Optional<BaseCommand> command = this.getSubCommand(firstArg);
        if (command.isPresent()) {
            return command.get().addTabCompletionOptions(sender, Arrays.copyOfRange(args, 1, args.length), pos);
        }

        return new ArrayList<>();
    }

    @Override
    protected List<String> getSyntax() {
        // Only show the first argument instead of the entire syntax
        final List<String> subCommandNames = new ArrayList<>();
        for (final BaseCommand subCommand : this.subCommands) {
            subCommandNames.add(subCommand.getCommandName());
        }
        return Collections.singletonList(String.join("|", subCommandNames));
    }

    @Override
    public void onCommand(final ICommandSender sender, final String[] args) {
        if (args.length == 0) {
            final MessageBuilder helpMessage = MessageBuilder.of(
                    StringUtils.capitalize(this.getCommandName()) + "-Command\n", EnumChatFormatting.GOLD);
            for (final BaseCommand command : this.subCommands) {
                helpMessage.addMessage(
                        EnumChatFormatting.YELLOW,
                        "\n/%s %s %s",
                        this.getPreCommand() + this.getCommandName(),
                        command.getCommandName(),
                        String.join(" ", command.getSyntax()));
            }
            helpMessage.addBoxToMessage().sendToPlayer();
            return;
        }

        final Optional<BaseCommand> command = this.getSubCommand(args[0]);
        if (!command.isPresent()) {
            this.returnTellNotValidCommand(args[0]);
            return;
        }

        command.get().processCommand(sender, Arrays.copyOfRange(args, 1, args.length));
    }

    protected Optional<BaseCommand> getSubCommand(final String name) {
        for (final BaseCommand command : this.subCommands) {
            if (command.getCommandName().equalsIgnoreCase(name)) {
                return Optional.of(command);
            }

            for (final String alias : command.getCommandAliases()) {
                if (alias.equalsIgnoreCase(name)) {
                    return Optional.of(command);
                }
            }
        }

        return Optional.empty();
    }

    protected String getPreCommand() {
        if (this.preCommand == null) {
            return "";
        }

        return this.preCommand;
    }

    protected CommandGroup registerSubCommands(final BaseCommand... commands) {
        for (final BaseCommand command : commands) {
            this.registerSubCommand(command);
        }

        return this;
    }

    protected CommandGroup registerSubCommand(final BaseCommand command) {
        if (command instanceof CommandGroup) {
            final CommandGroup commandGroup = (CommandGroup) command;
            commandGroup.setPreCommand(this.getPreCommand() + this.getCommandName() + " ");
        }

        // Set group prefix is the sub command doesn't have one
        if (command.getPrefix() == null && this.getPrefix() != null) {
            command.setPrefix(this.getPrefix());
        }

        this.subCommands.add(command);
        return this;
    }
}
