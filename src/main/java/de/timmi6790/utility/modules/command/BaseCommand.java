package de.timmi6790.utility.modules.command;

import de.timmi6790.utility.utils.MessageBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.ClientCommandHandler;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public abstract class BaseCommand extends CommandBase {
    private final String name;
    private final List<String> aliases = new ArrayList<>();
    @Getter(AccessLevel.PROTECTED)
    private final List<String> syntax = new ArrayList<>();
    @Getter(AccessLevel.PROTECTED)
    @Setter(AccessLevel.PROTECTED)
    private String prefix;
    @Setter(AccessLevel.PROTECTED)
    @Getter(AccessLevel.PROTECTED)
    private int minArgs = 0;

    protected BaseCommand(final String name) {
        this(name, null, null);
    }

    protected BaseCommand(final String name, final List<String> aliases) {
        this(name, null, aliases);
    }

    protected BaseCommand(final String name, final String prefix) {
        this(name, prefix, null);
    }

    protected BaseCommand(@NonNull final String name,
                          final String prefix,
                          final List<String> aliases) {
        this.name = name;
        this.prefix = prefix;

        if (aliases != null) {
            this.aliases.addAll(aliases);
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getCommandName() {
        return this.name;
    }

    @Override
    public String getCommandUsage(final ICommandSender sender) {
        return "/" + this.name;
    }

    @Override
    public List<String> getCommandAliases() {
        return this.aliases;
    }

    @Override
    public void processCommand(final ICommandSender sender, final String[] args) {
        if (this.minArgs > args.length) {
            this.returnTellMissingArgs();
        }

        try {
            this.onCommand(sender, args);
        } catch (final CommandReturnException ex) {
            if (ex.getMessageBuilder() != null) {
                this.tell(ex.getMessageBuilder());
            }
        }
    }

    public abstract void onCommand(final ICommandSender sender, final String[] args);

    protected void returnTell(final MessageBuilder messages) {
        throw new CommandReturnException(messages);
    }

    protected void returnTellNotValidCommand(final String commandName) {
        this.returnTell(
                MessageBuilder.of(commandName, EnumChatFormatting.YELLOW)
                        .addMessage(" is not a valid command.", EnumChatFormatting.GRAY)
        );
    }

    protected void returnTellMissingArgs() {
        MessageBuilder.of(StringUtils.capitalize(this.getCommandName()) + "-Command\n", EnumChatFormatting.GOLD)
                .addMessage("\n" + "/" + this.getCommandName() + " " + this.getCommandName() + " " + String.join(" ", this.getSyntax()), EnumChatFormatting.YELLOW)
                .addBoxToMessage()
                .sendToPlayer();
        this.returnTell(null);
    }

    protected void returnTellInvalidArgument(final Object value, final String checkType) {
        MessageBuilder.of(String.valueOf(value), EnumChatFormatting.YELLOW)
                .addMessage(" is not a valid ", EnumChatFormatting.GRAY)
                .addMessage(checkType)
                .addMessage(" value.", EnumChatFormatting.GRAY)
                .sendToPlayer();

        this.returnTell(null);
    }

    protected List<String> getTabCompleteOptions(final Collection<String> options, final String start) {
        return this.getTabCompleteOptions(options.toArray(new String[0]), start);
    }

    protected List<String> getTabCompleteOptions(final String[] options, final String start) {
        if (start.isEmpty() || (start.length() == 1 && start.charAt(0) == ' ')) {
            return new ArrayList<>(Arrays.asList(options));
        }

        final List<String> tabCompleteOptions = new ArrayList<>();
        final String startLower = start.toLowerCase();
        for (final String option : options) {
            if (option.toLowerCase().startsWith(startLower) && !option.equalsIgnoreCase(start)) {
                tabCompleteOptions.add(option);
            }
        }

        return tabCompleteOptions;
    }

    protected void tell(final String message) {
        this.tell(MessageBuilder.of(message));
    }

    protected void tell(final MessageBuilder message) {
        MessageBuilder.of("")
                .addMessage(this.prefix != null ? this.prefix + "> " : "", EnumChatFormatting.BLUE)
                .addMessage(message)
                .sendToPlayer();
    }

    protected EntityPlayerSP getPlayer() {
        return Minecraft.getMinecraft().thePlayer;
    }

    protected void setSyntax(final Collection<String> syntax) {
        this.syntax.clear();
        this.syntax.addAll(syntax);
    }

    protected void setSyntax(final String... syntax) {
        this.setSyntax(Arrays.asList(syntax));
    }

    public void register() {
        ClientCommandHandler.instance.registerCommand(this);
    }

    public void unregister() {
        final Map<String, ICommand> commandMap = ClientCommandHandler.instance.getCommands();
        commandMap.remove(this.getCommandName());

        for (final String commandAlias : this.getCommandAliases()) {
            if (this.equals(commandMap.get(commandAlias))) {
                commandMap.remove(commandAlias);
            }
        }
    }
}
