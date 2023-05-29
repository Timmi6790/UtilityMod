package de.timmi6790.utility.modules.packets.printer.commands.subcommands;

import de.timmi6790.utility.modules.packets.printer.PacketPrinterModule;
import de.timmi6790.utility.modules.packets.printer.mappers.PacketMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.PacketSide;
import de.timmi6790.utility.utils.EnumUtils;
import de.timmi6790.utility.utils.MessageBuilder;
import net.minecraft.command.ICommandSender;
import net.minecraft.network.Packet;
import net.minecraft.util.EnumChatFormatting;

import java.util.*;


public class ListCommand extends AbstractPacketPrinterCommand {
    public ListCommand(final PacketPrinterModule module) {
        super(module, "list", Collections.singletonList("l"));
    }

    @Override
    public void onCommand(final ICommandSender sender, final String[] args) {
        final PacketPrinterModule packetPrinterManager = this.getModule();

        final Map<PacketSide, List<String>> activeListeners = new EnumMap<>(PacketSide.class);
        // Map the active classes to the pretty class name
        for (final Class<Packet<?>> listenerClass : packetPrinterManager.getActiveListeners()) {
            final Optional<PacketMapper<Packet<?>>> mapper = packetPrinterManager.getPacketMapper(listenerClass);
            mapper.ifPresent(packetPacketMapper ->
                    activeListeners.computeIfAbsent(packetPacketMapper.getPacketSide(), k -> new ArrayList<>())
                            .add(packetPacketMapper.getCleanPacketName())
            );
        }

        if (activeListeners.isEmpty()) {
            this.tell(
                    MessageBuilder.of("No listeners found", EnumChatFormatting.YELLOW)
                            .addBoxToMessage()
            );
            return;
        }

        final MessageBuilder messageBuilder = MessageBuilder.of("");
        for (final Map.Entry<PacketSide, List<String>> entry : activeListeners.entrySet()) {
            final List<String> packetNames = entry.getValue();
            packetNames.sort(Comparator.naturalOrder());

            messageBuilder
                    .addMessage("\n\n" + EnumUtils.getPrettyName(entry.getKey()), EnumChatFormatting.GOLD)
                    .addMessage(":\n", EnumChatFormatting.GRAY);

            for (final String packetName : packetNames) {
                messageBuilder
                        .addMessage("\n    - ", EnumChatFormatting.GRAY)
                        .addMessage(packetName, EnumChatFormatting.GOLD);
            }
        }
        messageBuilder
                .addBoxToMessage()
                .sendToPlayer();
    }
}
