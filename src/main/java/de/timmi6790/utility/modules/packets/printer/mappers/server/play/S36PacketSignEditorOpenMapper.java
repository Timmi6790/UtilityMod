package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S36PacketSignEditorOpen;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S36PacketSignEditorOpenMapper extends ServerPacketMapper<S36PacketSignEditorOpen>
{
	public S36PacketSignEditorOpenMapper()
	{
		super(S36PacketSignEditorOpen.class);
	}

	@Override
	public void parsePacketToMap(final S36PacketSignEditorOpen packet, final Map<String, String> valueMap)
	{
		valueMap.put("Position", this.toString(packet.getSignPosition()));
	}
}
