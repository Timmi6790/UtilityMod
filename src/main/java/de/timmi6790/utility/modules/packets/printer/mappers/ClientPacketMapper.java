package de.timmi6790.utility.modules.packets.printer.mappers;

import net.minecraft.network.Packet;

public abstract class ClientPacketMapper<T extends Packet<?>> extends PacketMapper<T> {
    protected ClientPacketMapper(final Class packetClass) {
        super(packetClass, PacketSide.CLIENT);
    }
}
