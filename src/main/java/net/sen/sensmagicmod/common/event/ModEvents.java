package net.sen.sensmagicmod.common.event;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;

import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.block.ModBlockss;
import net.sen.sensmagicmod.common.entity.ModEntities;
import net.sen.sensmagicmod.common.entity.custom.StraphinEntity;
import net.sen.sensmagicmod.common.magic.PlayerMagicCorruption;
import net.sen.sensmagicmod.common.magic.PlayerMagicCorruptionProvider;
import net.sen.sensmagicmod.common.networking.ModMessages;
import net.sen.sensmagicmod.common.networking.packet.MagicCorruptionDataSyncS2CPacket;

@Mod.EventBusSubscriber(modid = SensMagicMod.MODID)
public class ModEvents
{
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof Player)
        {
            if (!event.getObject().getCapability(PlayerMagicCorruptionProvider.PLAYER_MAGIC_CORRUPTION).isPresent())
            {
                event.addCapability(new ResourceLocation(SensMagicMod.MODID, "properties"), new PlayerMagicCorruptionProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event)
    {
        if (event.isWasDeath())
        {
            event.getOriginal().getCapability(PlayerMagicCorruptionProvider.PLAYER_MAGIC_CORRUPTION).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerMagicCorruptionProvider.PLAYER_MAGIC_CORRUPTION).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event)
    {
        event.register(PlayerMagicCorruption.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        Player player = event.player;
        Level level = player.getLevel();

        if (event.side == LogicalSide.SERVER && hasCorruptionNearBy(player, level, 5))
        {
            event.player.getCapability(PlayerMagicCorruptionProvider.PLAYER_MAGIC_CORRUPTION).ifPresent(magicCorruption -> {
                if (magicCorruption.getMagicCorruption() > 0 && event.player.getRandom().nextFloat() < 0.001f)
                {
                    magicCorruption.addMagicCorruption(1);
                    ModMessages.sendToPlayer(new MagicCorruptionDataSyncS2CPacket(magicCorruption.getMagicCorruption()), ((ServerPlayer) event.player));
                }
            });
        }
        else
        {
            event.player.getCapability(PlayerMagicCorruptionProvider.PLAYER_MAGIC_CORRUPTION).ifPresent(magicCorruption -> {
                if (magicCorruption.getMagicCorruption() > 0 && event.player.getRandom().nextFloat() < 0.005f)
                {
                    magicCorruption.subMagicCorruption(1);
                    ModMessages.sendToPlayer(new MagicCorruptionDataSyncS2CPacket(magicCorruption.getMagicCorruption()), ((ServerPlayer) event.player));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event)
    {
        if (!event.getLevel().isClientSide)
        {
            if(event.getEntity() instanceof ServerPlayer player)
            {
                player.getCapability(PlayerMagicCorruptionProvider.PLAYER_MAGIC_CORRUPTION).ifPresent(magicCorruption -> {
                    ModMessages.sendToPlayer(new MagicCorruptionDataSyncS2CPacket(magicCorruption.getMagicCorruption()), player);
                });
            }
        }
    }

    private static boolean hasCorruptionNearBy(Player player, Level level, int size)
    {
        return level.getBlockStates(player.getBoundingBox().inflate(size))
                .filter(state -> state.is(ModBlockss.BLOCK_CRYSTAL_ENDER.get())).toArray().length > 0;
    }
}
