package de.timmi6790.utility.modules.packets.printer.mappers;

import net.minecraft.network.Packet;

public abstract class ServerPacketMapper<T extends Packet<?>> extends PacketMapper<T> {
    protected ServerPacketMapper(final Class<T> packetClass) {
        super(packetClass, PacketSide.SERVER);
    }
}
