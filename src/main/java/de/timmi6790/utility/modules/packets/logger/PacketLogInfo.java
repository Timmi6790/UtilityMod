package de.timmi6790.utility.modules.packets.logger;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;

import io.netty.buffer.Unpooled;
import lombok.Data;

@Data
public class PacketLogInfo
{
	private final PacketLogData total;
	private final PacketLogData second;

	public PacketLogInfo(final Class<? extends Packet> packetClass)
	{
		this.total = new PacketLogData(packetClass);
		this.second = new PacketLogData(packetClass);
	}

	private int getByteSize(final Packet packet)
	{
		final PacketBuffer packetbuffer = new PacketBuffer(Unpooled.buffer());
		try
		{
			packet.writePacketData(packetbuffer);
			final byte[] bytes = new byte[packetbuffer.readableBytes()];
			packetbuffer.readBytes(bytes);
			return bytes.length;
		}
		catch (final Exception ignore)
		{
			return 0;
		}
	}

	public void logPacket(final Packet packet)
	{
		this.total.getPackets().incrementAndGet();
		this.second.getPackets().incrementAndGet();

		final int byteSize = this.getByteSize(packet);
		this.total.getBytes().addAndGet(byteSize);
		this.second.getBytes().addAndGet(byteSize);
	}
}
