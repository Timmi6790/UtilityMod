package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.server.S0APacketUseBed;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;


public class S0APacketUseBedMapper extends ServerPacketMapper<S0APacketUseBed>
{
	public S0APacketUseBedMapper()
	{
		super(S0APacketUseBed.class);
	}

	@Override
	public void parsePacketToMap(final S0APacketUseBed packet, final Map<String, String> valueMap)
	{
		valueMap.put("BedPos", this.toString(packet.getBedPosition()));

		final EntityPlayer player = packet.getPlayer(this.getWorld());
		if (player != null)
		{
			valueMap.put("EntityId", String.valueOf(player.getEntityId()));
			valueMap.put("EntityDisplayName", player.getDisplayNameString());
		}
		else
		{
			valueMap.put("EntityId", "Not Found");
		}
	}
}
