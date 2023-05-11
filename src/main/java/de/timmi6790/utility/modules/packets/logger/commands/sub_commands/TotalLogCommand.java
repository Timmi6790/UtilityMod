package de.timmi6790.utility.modules.packets.logger.commands.sub_commands;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.minecraft.command.ICommandSender;

import de.timmi6790.utility.modules.command.BaseCommand;
import de.timmi6790.utility.modules.packets.logger.PacketLogData;
import de.timmi6790.utility.modules.packets.logger.PacketLogInfo;
import de.timmi6790.utility.modules.packets.logger.PacketLoggerModule;
import de.timmi6790.utility.utils.FormatUtils;

public class TotalLogCommand extends BaseCommand
{
	private final PacketLoggerModule module;

	public TotalLogCommand(final PacketLoggerModule module)
	{
		super("total");

		this.module = module;
	}

	@Override
	public void onCommand(final ICommandSender sender, final String[] args)
	{
		final List<PacketLogData> packets = new ArrayList<>();
		for (final PacketLogInfo packetLogInfo : this.module.getPacketLogInfos().values())
		{
			packets.add(packetLogInfo.getTotal().clone());
		}

		final long timePassed = System.currentTimeMillis() - this.module.getLoggerStartTime();
		this.module.broadcastLogInfo(
				"Total " + FormatUtils.toHumanReadableSeconds(TimeUnit.MILLISECONDS.toSeconds(timePassed)),
				packets
		);
	}
}
