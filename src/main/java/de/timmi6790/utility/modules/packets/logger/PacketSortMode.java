package de.timmi6790.utility.modules.packets.logger;

import java.util.Collections;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PacketSortMode
{
	PACKET_AMOUNT(Collections.reverseOrder(Comparator.comparingInt(e -> e.getPackets().get()))),
	BYTE_SIZE(Collections.reverseOrder(Comparator.comparingInt(e -> e.getBytes().get())));

	private final Comparator<PacketLogData> comparator;
}
