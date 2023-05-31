package de.timmi6790.utility.modules.packets.printer;

import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.modules.packets.printer.commands.PacketPrinterCommand;
import de.timmi6790.utility.modules.packets.printer.mappers.PacketMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.forge.FMLProxyPacketMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.handshake.C00HandshakeMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.login.C00PacketLoginStartMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.login.C01PacketEncryptionResponseMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.*;
import de.timmi6790.utility.modules.packets.printer.mappers.client.status.C00PacketServerQueryMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.status.C01PacketPingMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.login.S00PacketDisconnectMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.login.S01PacketEncryptionRequestMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.login.S02PacketLoginSuccessMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.login.S03PacketEnableCompressionMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.*;
import de.timmi6790.utility.modules.packets.printer.mappers.server.status.S00PacketServerInfoMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.status.S01PacketPongMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import net.minecraft.network.Packet;

import java.util.*;

@Log4j2
public class PacketPrinterModule extends BaseModule {
    private final Map<Class<? extends Packet<?>>, PacketMapper<?>> packetMappers = new HashMap<>();
    @Getter
    private final Set<Class<Packet<?>>> activeListeners = Collections.synchronizedSet(new HashSet<>());
    @Getter
    @Setter
    private PrintMode printMode = PrintMode.CHAT;

    public PacketPrinterModule() {
        this.registerPacketMappers(
                // Client Play
                new C0APacketAnimationMapper(),
                new C0BPacketEntityActionMapper(),
                new C0CPacketInputMapper(),
                new C0DPacketCloseWindowMapper(),
                new C0EPacketClickWindowMapper(),
                new C0FPacketConfirmTransactionMapper(),
                new C00PacketKeepAliveMapper(),
                new C01PacketChatMessageMapper(),
                new C02PacketUseEntityMapper(),
                new C03PacketPlayerMapper(),
                new C04PacketPlayerPositionMapper(),
                new C05PacketPlayerLookMapper(),
                new C06PacketPlayerPosLookMapper(),
                new C07PacketPlayerDiggingMapper(),
                new C08PacketPlayerBlockPlacementMapper(),
                new C09PacketHeldItemChangeMapper(),
                new C10PacketCreativeInventoryActionMapper(),
                new C11PacketEnchantItemMapper(),
                new C12PacketUpdateSignMapper(),
                new C13PacketPlayerAbilitiesMapper(),
                new C14PacketTabCompleteMapper(),
                new C15PacketClientSettingsMapper(),
                new C16PacketClientStatusMapper(),
                new C17PacketCustomPayloadMapper(),
                new C18PacketSpectateMapper(),
                new C19PacketResourcePackStatusMapper(),

                // Client Status
                new C00PacketServerQueryMapper(),
                new C01PacketPingMapper(),

                // Client Handshake
                new C00HandshakeMapper(),

                // Client Login
                new C00PacketLoginStartMapper(),
                new C01PacketEncryptionResponseMapper(),

                // Client Forge
                new FMLProxyPacketMapper(),

                // Server Login
                new S00PacketDisconnectMapper(),
                new S01PacketEncryptionRequestMapper(),
                new S02PacketLoginSuccessMapper(),
                new S03PacketEnableCompressionMapper(),

                // Server Play
                new S0APacketUseBedMapper(),
                new S0BPacketAnimationMapper(),
                new S0CPacketSpawnPlayerMapper(),
                new S0DPacketCollectItemMapper(),
                new S0EPacketSpawnObjectMapper(),
                new S0FPacketSpawnMobMapper(),
                new S00PacketKeepAliveMapper(),
                new S1BPacketEntityAttachMapper(),
                new S1CPacketEntityMetadataMapper(),
                new S1DPacketEntityEffectMapper(),
                new S1EPacketRemoveEntityEffectMapper(),
                new S1FPacketSetExperienceMapper(),
                new S01PacketJoinGameMapper(),
                new S2APacketParticlesMapper(),
                new S2BPacketChangeGameStateMapper(),
                new S2CPacketSpawnGlobalEntityMapper(),
                new S2DPacketOpenWindowMapper(),
                new S2EPacketCloseWindowMapper(),
                new S2FPacketSetSlotMapper(),
                new S02PacketChatMapper(),
                new S3APacketTabCompleteMapper(),
                new S3BPacketScoreboardObjectiveMapper(),
                new S3CPacketUpdateScoreMapper(),
                new S3DPacketDisplayScoreboardMapper(),
                new S3EPacketTeamsMapper(),
                new S3FPacketCustomPayloadMapper(),
                new S03PacketTimeUpdateMapper(),
                new S04PacketEntityEquipmentMapper(),
                new S05PacketSpawnPositionMapper(),
                new S06PacketUpdateHealthMapper(),
                new S07PacketRespawnMapper(),
                new S08PacketPlayerPosLookMapper(),
                new S09PacketHeldItemChangeMapper(),
                new S10PacketSpawnPaintingMapper(),
                new S11PacketSpawnExperienceOrbMapper(),
                new S12PacketEntityVelocityMapper(),
                new S13PacketDestroyEntitiesMapper(),
                new S14PacketEntityMapper(),
                new S15PacketEntityRelMoveMapper(),
                new S16PacketEntityLookMapper(),
                new S17PacketEntityLookMoveMapper(),
                new S18PacketEntityTeleportMapper(),
                new S19PacketEntityHeadLookMapper(),
                new S19PacketEntityStatusMapper(),
                new S20PacketEntityPropertiesMapper(),
                new S21PacketChunkDataMapper(),
                new S22PacketMultiBlockChangeMapper(),
                new S23PacketBlockChangeMapper(),
                new S24PacketBlockActionMapper(),
                new S25PacketBlockBreakAnimMapper(),
                new S26PacketMapChunkBulkMapper(),
                new S27PacketExplosionMapper(),
                new S28PacketEffectMapper(),
                new S29PacketSoundEffectMapper(),
                new S30PacketWindowItemsMapper(),
                new S31PacketWindowPropertyMapper(),
                new S32PacketConfirmTransactionMapper(),
                new S33PacketUpdateSignMapper(),
                new S34PacketMapsMapper(),
                new S35PacketUpdateTileEntityMapper(),
                new S36PacketSignEditorOpenMapper(),
                new S37PacketStatisticsMapper(),
                new S38PacketPlayerListItemMapper(),
                new S39PacketPlayerAbilitiesMapper(),
                new S40PacketDisconnectMapper(),
                new S41PacketServerDifficultyMapper(),
                new S42PacketCombatEventMapper(),
                new S43PacketCameraMapper(),
                new S44PacketWorldBorderMapper(),
                new S45PacketTitleMapper(),
                new S46PacketSetCompressionLevelMapper(),
                new S47PacketPlayerListHeaderFooterMapper(),
                new S48PacketResourcePackSendMapper(),
                new S49PacketUpdateEntityNBTMapper(),

                // Server Status
                new S00PacketServerInfoMapper(),
                new S01PacketPongMapper()
        );

        this.registerCommands(
                new PacketPrinterCommand(this)
        );

        this.registerListenerComponents(
                new PacketPrinterListener(this)
        );
    }

    @SafeVarargs
    public final void registerPacketMappers(final PacketMapper<? extends Packet<?>>... packetMappers) {
        for (final PacketMapper<? extends Packet<?>> packetMapper : packetMappers) {
            this.registerPacketMapper(packetMapper);
        }
    }

    public boolean registerPacketMapper(final PacketMapper<? extends Packet<?>> packetMapper) {
        if (this.packetMappers.containsKey(packetMapper.getPacketClass())) {
            return false;
        }

        this.packetMappers.put(packetMapper.getPacketClass(), packetMapper);
        return true;
    }

    public List<PacketMapper<?>> getPacketMappers() {
        return new ArrayList<>(this.packetMappers.values());
    }

    public <T extends Packet<?>> Optional<PacketMapper<T>> getPacketMapper(final Class<T> packetClass) {
        return Optional.ofNullable((PacketMapper<T>) this.packetMappers.get(packetClass));
    }

    public boolean hasPacketLogger(final Class<Packet<?>> packetClass) {
        return this.activeListeners.contains(packetClass);
    }

    public boolean addPacketLogger(final Class<Packet<?>> packetClass) {
        return this.activeListeners.add(packetClass);
    }

    public boolean removePacketLogger(final Class<Packet<?>> packetClass) {
        return this.activeListeners.remove(packetClass);
    }
}
