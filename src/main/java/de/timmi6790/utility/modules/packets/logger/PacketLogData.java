package de.timmi6790.utility.modules.packets.logger;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.Data;
import net.minecraft.network.Packet;

@Data
public class PacketLogData implements Cloneable {
    private final Class<? extends Packet> packetClass;
    private final AtomicInteger packets = new AtomicInteger(0);
    private final AtomicInteger bytes = new AtomicInteger(0);

    public void reset() {
        this.packets.set(0);
        this.bytes.set(0);
    }

    @Override
    public PacketLogData clone() {
        final PacketLogData packetLogData = new PacketLogData(this.packetClass);
        packetLogData.getBytes().set(this.bytes.get());
        packetLogData.getPackets().set(this.packets.get());
        return packetLogData;
    }
}
