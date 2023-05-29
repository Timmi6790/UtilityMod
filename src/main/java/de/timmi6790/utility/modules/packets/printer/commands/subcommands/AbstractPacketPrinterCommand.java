package de.timmi6790.utility.modules.packets.printer.commands.subcommands;

import de.timmi6790.utility.modules.command.BaseCommand;
import de.timmi6790.utility.modules.command.CommandReturnException;
import de.timmi6790.utility.modules.packets.printer.PacketPrinterModule;
import de.timmi6790.utility.modules.packets.printer.mappers.PacketMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.PacketSide;
import de.timmi6790.utility.utils.EnumUtils;
import de.timmi6790.utility.utils.MessageBuilder;
import lombok.Getter;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractPacketPrinterCommand extends BaseCommand {
    @Getter
    private final PacketPrinterModule module;

    protected AbstractPacketPrinterCommand(final PacketPrinterModule module, final String name, final List<String> aliases) {
        super(name, aliases);

        this.module = module;
    }

    public PacketSide getPacketSideThrow(final String userInput) {
        final Optional<PacketSide> packetSideOpt = EnumUtils.getIgnoreCase(userInput, PacketSide.values());
        if (packetSideOpt.isPresent()) {
            return packetSideOpt.get();
        }

        throw new CommandReturnException(
                MessageBuilder.of(userInput, EnumChatFormatting.YELLOW)
                        .addMessage(" is not a valid input.", EnumChatFormatting.GRAY)
        );
    }

    public PacketMapper<?> getPacketMapperThrow(final PacketSide packetSide, final String userInput) {
        for (final PacketMapper<?> mapper : this.getModule().getPacketMappers()) {
            if (mapper.getPacketSide() == packetSide && mapper.getCleanPacketName().equalsIgnoreCase(userInput)) {
                return mapper;
            }
        }

        throw new CommandReturnException(
                MessageBuilder.of(userInput, EnumChatFormatting.YELLOW)
                        .addMessage(" is not a valid input.", EnumChatFormatting.GRAY)
        );
    }

    public List<String> getPacketMappersCleanNames(final PacketSide packetSide) {
        final List<String> packetMapperCleanNames = new ArrayList<>();
        for (final PacketMapper<?> mapper : this.getModule().getPacketMappers()) {
            if (mapper.getPacketSide() == packetSide) {
                packetMapperCleanNames.add(mapper.getCleanPacketName());
            }
        }
        return packetMapperCleanNames;
    }
}
