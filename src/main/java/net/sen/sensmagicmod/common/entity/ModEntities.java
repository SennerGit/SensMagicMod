package net.sen.sensmagicmod.common.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.entity.custom.StraphinEntity;

public class ModEntities
{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SensMagicMod.MODID);

    public static final RegistryObject<EntityType<StraphinEntity>> STRAPHIN = ENTITY_TYPES.register("straphin", () -> EntityType.Builder.of(StraphinEntity::new, MobCategory.CREATURE).sized(1.5f, 1.75f).build(new ResourceLocation(SensMagicMod.MODID, "straphin").toString()));

    public static void register(IEventBus eventBus)
    {
        ENTITY_TYPES.register(eventBus);
    }
}