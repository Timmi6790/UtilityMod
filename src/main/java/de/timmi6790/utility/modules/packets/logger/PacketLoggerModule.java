package de.timmi6790.utility.modules.packets.logger;

import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.modules.packets.logger.commands.PacketLoggerCommand;
import de.timmi6790.utility.utils.FormatUtils;
import de.timmi6790.utility.utils.MathUtils;
import de.timmi6790.utility.utils.MessageBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.minecraft.network.Packet;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@EqualsAndHashCode(callSuper = true)
@Data
public class PacketLoggerModule extends BaseModule {
    private final Map<Class<? extends Packet>, PacketLogInfo> packetLogInfos = new ConcurrentHashMap<>();

    private PacketSortMode sortMode = PacketSortMode.BYTE_SIZE;
    private boolean secondBroadcast = false;
    private int packetShowCount = 5;
    private long loggerStartTime = System.currentTimeMillis();

    private ScheduledFuture<?> broadcastTask;

    public PacketLoggerModule() {
        registerListenerComponent(
                new PacketLoggerListener(this)
        );

        registerCommands(
                new PacketLoggerCommand(this)
        );
    }

    @Override
    public void enable() {
        super.enable();

        broadcastTask = Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
                () ->
                {
                    // Timed Broadcast
                    if (this.secondBroadcast) {
                        final List<PacketLogData> secondPacket = new ArrayList<>(this.packetLogInfos.size());
                        for (final PacketLogInfo packetLogInfo : this.packetLogInfos.values()) {
                            secondPacket.add(packetLogInfo.getSecond().clone());
                        }

                        this.broadcastLogInfo("Second", secondPacket);
                    }

                    // Reset
                    for (final PacketLogInfo packetLogInfo : this.packetLogInfos.values()) {
                        packetLogInfo.getSecond().reset();
                    }
                },
                1,
                1,
                TimeUnit.SECONDS
        );
    }


    @Override
    public void disable() {
        super.disable();

        if (broadcastTask != null) {
            broadcastTask.cancel(true);
        }
    }

    public void broadcastLogInfo(final String title, final List<PacketLogData> logDataList) {
        logDataList.sort(this.sortMode.getComparator());

        int totalPackets = 0;
        int totalBytes = 0;
        for (final PacketLogData packetLogData : logDataList) {
            totalPackets += packetLogData.getPackets().get();
            totalBytes += packetLogData.getBytes().get();
        }

        final MessageBuilder messageBuilder = MessageBuilder.of(title + "\nPackets ", EnumChatFormatting.YELLOW)
                .addMessage(String.valueOf(totalPackets), EnumChatFormatting.GRAY)
                .addMessage("   Bytes ")
                .addMessage(FormatUtils.toHumanReadableByteCountBin(totalBytes), EnumChatFormatting.GRAY);

        for (int index = 0; Math.min(this.packetShowCount, logDataList.size()) > index; index++) {
            final PacketLogData packetLogData = logDataList.get(index);

            final int packets = packetLogData.getPackets().get();
            final int bytes = packetLogData.getBytes().get();

            // Nothing to show when it is empty
            // This can happen because of the resets
            if (packets == 0) {
                continue;
            }

            messageBuilder.addMessage("\n" + packetLogData.getPacketClass().getSimpleName())
                    .addMessage(": ", EnumChatFormatting.GRAY)
                    .addMessage("P")
                    .addMessage(
                            String.format(
                                    ":%s[%.2f%%]",
                                    packets,
                                    MathUtils.calculatePercentage(totalPackets, packets)
                            ),
                            EnumChatFormatting.GRAY
                    ).addMessage(";B")
                    .addMessage(
                            String.format(
                                    ":%s[%.2f%%]",
                                    FormatUtils.toHumanReadableByteCountBin(bytes),
                                    MathUtils.calculatePercentage(totalBytes, bytes)
                            ),
                            EnumChatFormatting.GRAY
                    );
        }

        messageBuilder
                .addBoxToMessage()
                .sendToPlayer();
    }
}
