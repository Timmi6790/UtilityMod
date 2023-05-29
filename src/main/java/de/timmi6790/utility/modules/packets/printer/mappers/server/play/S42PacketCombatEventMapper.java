package de.timmi6790.utility.modules.packets.printer.mappers.server.play;

import de.timmi6790.utility.modules.packets.printer.mappers.ServerPacketMapper;
import de.timmi6790.utility.utils.EnumUtils;
import net.minecraft.network.play.server.S42PacketCombatEvent;

import java.util.Map;

public class S42PacketCombatEventMapper extends ServerPacketMapper<S42PacketCombatEvent> {
    public S42PacketCombatEventMapper() {
        super(S42PacketCombatEvent.class);
    }

    @Override
    public void parsePacketToMap(final S42PacketCombatEvent packet, final Map<String, String> valueMap) {
        valueMap.put("Even", EnumUtils.getPrettyName(packet.eventType));
        valueMap.put("DeathMessage", packet.deathMessage);
        valueMap.put("AttackedEntityId", String.valueOf(packet.field_179775_c));
        valueMap.put("Info", "Not fully implemented");
    }
}
