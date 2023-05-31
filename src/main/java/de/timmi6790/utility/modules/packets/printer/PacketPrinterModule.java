package de.timmi6790.utility.modules.packets.printer;

import de.timmi6790.utility.BaseModule;
import de.timmi6790.utility.modules.packets.printer.commands.PacketPrinterCommand;
import de.timmi6790.utility.modules.packets.printer.mappers.PacketMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.forge.FMLProxyPacketMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.handshake.C00HandshakeMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.login.C00PacketLoginStartMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.login.C01PacketEncryptionResponseMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C00PacketKeepAliveMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C01PacketChatMessageMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C02PacketUseEntityMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C03PacketPlayerMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C04PacketPlayerPositionMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C05PacketPlayerLookMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C06PacketPlayerPosLookMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C07PacketPlayerDiggingMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C08PacketPlayerBlockPlacementMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C09PacketHeldItemChangeMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C0APacketAnimationMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C0BPacketEntityActionMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C0CPacketInputMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C0DPacketCloseWindowMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C0EPacketClickWindowMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C0FPacketConfirmTransactionMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C10PacketCreativeInventoryActionMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C11PacketEnchantItemMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C12PacketUpdateSignMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C13PacketPlayerAbilitiesMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C14PacketTabCompleteMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C15PacketClientSettingsMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C16PacketClientStatusMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C17PacketCustomPayloadMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C18PacketSpectateMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.play.C19PacketResourcePackStatusMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.status.C00PacketServerQueryMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.client.status.C01PacketPingMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.login.S00PacketDisconnectMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.login.S01PacketEncryptionRequestMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.login.S02PacketLoginSuccessMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.login.S03PacketEnableCompressionMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S00PacketKeepAliveMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S01PacketJoinGameMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S02PacketChatMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S03PacketTimeUpdateMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S04PacketEntityEquipmentMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S05PacketSpawnPositionMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S06PacketUpdateHealthMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S07PacketRespawnMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S08PacketPlayerPosLookMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S09PacketHeldItemChangeMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S0APacketUseBedMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S0BPacketAnimationMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S0CPacketSpawnPlayerMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S0DPacketCollectItemMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S0EPacketSpawnObjectMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S0FPacketSpawnMobMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S10PacketSpawnPaintingMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S11PacketSpawnExperienceOrbMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S12PacketEntityVelocityMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S13PacketDestroyEntitiesMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S14PacketEntityMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S15PacketEntityRelMoveMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S16PacketEntityLookMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S17PacketEntityLookMoveMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S18PacketEntityTeleportMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S19PacketEntityHeadLookMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S19PacketEntityStatusMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S1BPacketEntityAttachMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S1CPacketEntityMetadataMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S1DPacketEntityEffectMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S1EPacketRemoveEntityEffectMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S1FPacketSetExperienceMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S20PacketEntityPropertiesMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S21PacketChunkDataMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S22PacketMultiBlockChangeMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S23PacketBlockChangeMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S24PacketBlockActionMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S25PacketBlockBreakAnimMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S26PacketMapChunkBulkMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S27PacketExplosionMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S28PacketEffectMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S29PacketSoundEffectMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S2APacketParticlesMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S2BPacketChangeGameStateMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S2CPacketSpawnGlobalEntityMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S2DPacketOpenWindowMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S2EPacketCloseWindowMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S2FPacketSetSlotMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S30PacketWindowItemsMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S31PacketWindowPropertyMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S32PacketConfirmTransactionMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S33PacketUpdateSignMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S34PacketMapsMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S35PacketUpdateTileEntityMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S36PacketSignEditorOpenMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S37PacketStatisticsMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S38PacketPlayerListItemMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S39PacketPlayerAbilitiesMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S3APacketTabCompleteMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S3BPacketScoreboardObjectiveMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S3CPacketUpdateScoreMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S3DPacketDisplayScoreboardMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S3EPacketTeamsMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S3FPacketCustomPayloadMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S40PacketDisconnectMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S41PacketServerDifficultyMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S42PacketCombatEventMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S43PacketCameraMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S44PacketWorldBorderMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S45PacketTitleMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S46PacketSetCompressionLevelMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S47PacketPlayerListHeaderFooterMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S48PacketResourcePackSendMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.play.S49PacketUpdateEntityNBTMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.status.S00PacketServerInfoMapper;
import de.timmi6790.utility.modules.packets.printer.mappers.server.status.S01PacketPongMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import net.minecraft.network.Packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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
