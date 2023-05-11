package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.network.play.server.S21PacketChunkData;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S21PacketChunkDataMapper extends ServerPacketMapper<S21PacketChunkData>
{
	public S21PacketChunkDataMapper()
	{
		super(S21PacketChunkData.class);
	}

	@Override
	public void parsePacketToMap(final S21PacketChunkData packet, final Map<String, String> valueMap)
	{
		valueMap.put("Position", this.join(packet.getChunkX(), packet.getChunkZ()));
		valueMap.put("Unload", String.valueOf(packet.func_149274_i()));
		valueMap.put("Data", "Not Implemented");
	}
}
