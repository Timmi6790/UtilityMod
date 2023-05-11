package de.timmi6790.utility.modules.packets.printer.commands.subcommands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import net.minecraft.command.ICommandSender;
import net.minecraft.network.Packet;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;

import de.timmi6790.utility.modules.packets.printer.PacketPrinterModule;
import de.timmi6790.utility.modules.packets.printer.mappers.PacketMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.PacketSide;
import de.timmi6790.utility.utils.EnumUtils;
import de.timmi6790.utility.utils.MessageBuilder;

public class RemoveCommand extends AbstractPacketPrinterCommand
{
	public RemoveCommand(final PacketPrinterModule module)
	{
		super(module, "remove", Collections.singletonList("r"));

		this.setMinArgs(2);
		this.setSyntax("<client|server> <packetName>");
	}

	@Override
	public void onCommand(final ICommandSender sender, final String[] args)
	{
		final PacketSide packetSide = this.getPacketSideThrow(args[0]);
		final PacketMapper<?> packetMapper = this.getPacketMapperThrow(packetSide, args[1]);

		final Class<Packet<?>> packetClass = (Class<Packet<?>>) packetMapper.getPacketClass();
		if (!this.getModule().hasPacketLogger(packetClass))
		{
			this.tell(
					MessageBuilder.of("Is currently not listening for " + packetMapper.getCleanPacketName())
			);
			return;
		}

		this.getModule().removePacketLogger(packetClass);
		this.tell(
				MessageBuilder.of("Removed listener for ", EnumChatFormatting.GRAY)
						.addMessage(EnumUtils.getPrettyName(packetSide), EnumChatFormatting.YELLOW)
						.addMessage("-", EnumChatFormatting.GRAY)
						.addMessage(packetMapper.getCleanPacketName(), EnumChatFormatting.YELLOW)
						.addMessage(".", EnumChatFormatting.GRAY)
		);
	}

	@Override
	public List<String> addTabCompletionOptions(final ICommandSender sender, final String[] args, final BlockPos pos)
	{
		if (args.length == 1)
		{
			return this.getTabCompleteOptions(EnumUtils.getPrettyNames(PacketSide.values()), args[0]);
		}
		else if (args.length == 2)
		{
			final Optional<PacketSide> packetSideOpt = EnumUtils.getIgnoreCase(args[0], PacketSide.values());
			if (packetSideOpt.isPresent())
			{
				return this.getTabCompleteOptions(this.getPacketMappersCleanNames(packetSideOpt.get()), args[1]);
			}
		}

		return new ArrayList<>();
	}
}
