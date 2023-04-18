package net.sen.sensmagicmod.common.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
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

@Mod.EventBusSubscriber(modid = SensMagicMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityEvents
{
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event)
    {
        event.put(ModEntities.STRAPHIN.get(), StraphinEntity.setAttributes());
    }

    @SubscribeEvent
    public static void entitySpawnRestriction(SpawnPlacementRegisterEvent event)
    {
        event.register(ModEntities.STRAPHIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
