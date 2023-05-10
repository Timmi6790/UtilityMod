package de.timmi6790.utility.modules.core.events;

import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class PacketEvent extends Event
{
	private Packet packet;
}
