package de.timmi6790.utility.modules.packets.printer.mappers;

import de.timmi6790.utility.utils.EnumUtils;
import de.timmi6790.utility.utils.MessageBuilder;
import lombok.Data;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Data
public abstract class PacketMapper<T extends Packet<?>> {
    private final Class<T> packetClass;
    private final PacketSide packetSide;
    private final String cleanPacketName;

    protected PacketMapper(final Class<T> packetClass, final PacketSide packetSide) {
        this.packetClass = packetClass;
        this.packetSide = packetSide;
        this.cleanPacketName = this.removePacketCode(packetClass.getSimpleName());
    }

    /**
     * Map the packet to a map
     *
     * @param packet   the packet
     * @param valueMap the value map
     */
    protected abstract void parsePacketToMap(final T packet, final Map<String, String> valueMap);

    protected String removePacketCode(final String packetClassName) {
        return packetClassName.replaceFirst("^(?:.*){3}Packet", "");
    }

    protected Minecraft getMinecraft() {
        return Minecraft.getMinecraft();
    }

    protected WorldClient getWorld() {
        return this.getMinecraft().theWorld;
    }

    protected EntityPlayerSP getPlayer() {
        return this.getMinecraft().thePlayer;
    }

    protected MessageBuilder getBaseMessageBuilder() {
        return MessageBuilder.of("[", EnumChatFormatting.GRAY)
                .addMessage(EnumUtils.getPrettyName(this.packetSide), EnumChatFormatting.YELLOW)
                .addMessage("] ", EnumChatFormatting.GRAY)
                .addMessage("[")
                .addMessage(this.cleanPacketName, EnumChatFormatting.YELLOW)
                .addMessage("] ", EnumChatFormatting.GRAY);
    }

    protected MessageBuilder addMapToMessage(final MessageBuilder messageBuilder, final Map<String, String> map) {
        for (final Map.Entry<String, String> entry : map.entrySet()) {
            messageBuilder
                    .addMessage(entry.getKey() + ":", EnumChatFormatting.GRAY)
                    .addMessage(entry.getValue(), EnumChatFormatting.YELLOW)
                    .addMessage("; ", EnumChatFormatting.GRAY);
        }

        return messageBuilder;
    }

    protected String toString(final BlockPos blockPos) {
        return "(" + blockPos.getX() + "," + blockPos.getY() + "," + blockPos.getZ() + ")";
    }

    protected String toString(final ItemStack itemStack) {
        return String.valueOf(itemStack.getItem().getRegistryName());
    }

    protected String toString(final List<DataWatcher.WatchableObject> watchableObjects) {
        final StringJoiner joiner = new StringJoiner("; ");
        for (final DataWatcher.WatchableObject object : watchableObjects) {
            joiner.add("(ValueId: " + object.getDataValueId() + "; Type:" + object.getObjectType() + "; Object: " + object.getObject() + ")");
        }
        return "(" + joiner + ")";
    }

    protected String join(final Object... values) {
        final StringJoiner joiner = new StringJoiner(";");
        for (final Object value : values) {
            joiner.add(String.valueOf(value));
        }
        return "(" + joiner + ")";
    }

    protected void addEntityToMap(final Entity entity, final Map<String, String> valueMap) {
        if (entity != null) {
            valueMap.put("EntityId", String.valueOf(entity.getEntityId()));
        } else {
            valueMap.put("EntityId", "Unknown");
        }
    }

    public MessageBuilder parsePacketToMessage(final T packet) {
        final Map<String, String> valueMap = new HashMap<>();
        this.parsePacketToMap(packet, valueMap);

        return this.addMapToMessage(this.getBaseMessageBuilder(), valueMap);
    }
}
