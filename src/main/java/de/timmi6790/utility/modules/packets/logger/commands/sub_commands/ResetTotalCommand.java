package de.timmi6790.utility.modules.packets.logger.commands.sub_commands;

import de.timmi6790.utility.modules.command.BaseCommand;
import de.timmi6790.utility.modules.packets.logger.PacketLogInfo;
import de.timmi6790.utility.modules.packets.logger.PacketLoggerModule;
import net.minecraft.command.ICommandSender;

public class ResetTotalCommand extends BaseCommand {
    private final PacketLoggerModule module;

    public ResetTotalCommand(final PacketLoggerModule module) {
        super("resetTotal");

        this.module = module;
    }

    @Override
    public void onCommand(final ICommandSender sender, final String[] args) {
        this.module.setLoggerStartTime(System.currentTimeMillis());
        for (final PacketLogInfo packetLogInfo : this.module.getPacketLogInfos().values()) {
            packetLogInfo.getTotal().reset();
        }
        this.tell("Reset total logger");
    }
}
