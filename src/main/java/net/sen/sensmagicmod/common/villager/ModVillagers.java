package net.sen.sensmagicmod.common.villager;

import com.google.common.collect.ImmutableSet;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.Block;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.block.ModBlockss;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers
{
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, SensMagicMod.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, SensMagicMod.MODID);

    /**********************
     POIS
     **********************/
    public static final RegistryObject<PoiType> WIZARD_CAULDRON_BLOCK_POI = POI_TYPES.register("wizard_cauldron_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlockss.WIZARD_CAULDRON.get().getStateDefinition().getPossibleStates()),1, 1));

    public static final RegistryObject<PoiType> WIZARD_ALCHEMY_STATION_BLOCK_POI = POI_TYPES.register("wizard_alchemy_station_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlockss.WIZARD_ALCHEMY_STATION.get().getStateDefinition().getPossibleStates()),1, 1));

    public static final RegistryObject<PoiType> WIZARD_WRITING_STATION_BLOCK_POI = POI_TYPES.register("wizard_writing_station_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlockss.WIZARD_WRITING_STATION.get().getStateDefinition().getPossibleStates()),1, 1));

    public static final RegistryObject<PoiType> WIZARD_RITUAL_STONE_BLOCK_POI = POI_TYPES.register("wizard_ritual_stone_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlockss.WIZARD_RITUAL_STONE.get().getStateDefinition().getPossibleStates()),1, 1));

    public static final RegistryObject<PoiType> WIZARD_STONE_CUTTER_BLOCK_POI = POI_TYPES.register("wizard_stone_cutter_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlockss.WIZARD_STONE_CUTTER.get().getStateDefinition().getPossibleStates()),1, 1));

    public static final RegistryObject<PoiType> WIZARD_FABRIC_STATION_BLOCK_POI = POI_TYPES.register("wizard_fabric_station_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlockss.WIZARD_FABRIC_STATION.get().getStateDefinition().getPossibleStates()),1, 1));

    public static final RegistryObject<PoiType> WIZARD_FORGE_BLOCK_POI = POI_TYPES.register("wizard_forge_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlockss.WIZARD_FORGE.get().getStateDefinition().getPossibleStates()),1, 1));

    public static final RegistryObject<PoiType> WIZARD_ASTRONOMY_STATION_BLOCK_POI = POI_TYPES.register("wizard_astronomy_station_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlockss.WIZARD_ASTRONOMY_STATION.get().getStateDefinition().getPossibleStates()),1, 1));

    public static final RegistryObject<PoiType> WIZARD_AGRICULTURE_STATION_BLOCK_POI = POI_TYPES.register("wizard_agriculture_station_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlockss.WIZARD_AGRICULTURE_STATION.get().getStateDefinition().getPossibleStates()),1, 1));

    /**********************
     PROFESSIONS
     **********************/
    public static final RegistryObject<VillagerProfession> WIZARD_INGREDIENTS_SELLER = VILLAGER_PROFESSIONS.register("wizard_ingredients_seller",
            () -> new VillagerProfession("wizard_ingredients_seller", x -> x.get() == WIZARD_CAULDRON_BLOCK_POI.get(),
                    x -> x.get() == WIZARD_CAULDRON_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static final RegistryObject<VillagerProfession> WIZARD_POTION_SELLER = VILLAGER_PROFESSIONS.register("wizard_potion_seller",
            () -> new VillagerProfession("wizard_potion_seller", x -> x.get() == WIZARD_ALCHEMY_STATION_BLOCK_POI.get(),
                    x -> x.get() == WIZARD_ALCHEMY_STATION_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static final RegistryObject<VillagerProfession> WIZARD_SCROLL_SELLER = VILLAGER_PROFESSIONS.register("wizard_scroll_seller",
            () -> new VillagerProfession("wizard_scroll_seller", x -> x.get() == WIZARD_WRITING_STATION_BLOCK_POI.get(),
                    x -> x.get() == WIZARD_WRITING_STATION_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static final RegistryObject<VillagerProfession> WIZARD_RITUAL_SELLER = VILLAGER_PROFESSIONS.register("wizard_ritual_seller",
            () -> new VillagerProfession("wizard_ritual_seller", x -> x.get() == WIZARD_RITUAL_STONE_BLOCK_POI.get(),
                    x -> x.get() == WIZARD_RITUAL_STONE_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static final RegistryObject<VillagerProfession> WIZARD_RUNE_SELLER = VILLAGER_PROFESSIONS.register("wizard_rune_seller",
            () -> new VillagerProfession("wizard_rune_seller", x -> x.get() == WIZARD_STONE_CUTTER_BLOCK_POI.get(),
                    x -> x.get() == WIZARD_STONE_CUTTER_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static final RegistryObject<VillagerProfession> WIZARD_FABRIC_SELLER = VILLAGER_PROFESSIONS.register("wizard_fabric_seller",
            () -> new VillagerProfession("wizard_fabric_seller", x -> x.get() == WIZARD_FABRIC_STATION_BLOCK_POI.get(),
                    x -> x.get() == WIZARD_FABRIC_STATION_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static final RegistryObject<VillagerProfession> WIZARD_SMITH_SELLER = VILLAGER_PROFESSIONS.register("wizard_smith_seller",
            () -> new VillagerProfession("wizard_smith_seller", x -> x.get() == WIZARD_FORGE_BLOCK_POI.get(),
                    x -> x.get() == WIZARD_FORGE_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static final RegistryObject<VillagerProfession> WIZARD_ASTRONOMER_SELLER = VILLAGER_PROFESSIONS.register("wizard_astronomer_seller",
            () -> new VillagerProfession("wizard_astronomer_seller", x -> x.get() == WIZARD_ASTRONOMY_STATION_BLOCK_POI.get(),
                    x -> x.get() == WIZARD_ASTRONOMY_STATION_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static final RegistryObject<VillagerProfession> WIZARD_FARMING_SELLER = VILLAGER_PROFESSIONS.register("wizard_farming_seller",
            () -> new VillagerProfession("wizard_farming_seller", x -> x.get() == WIZARD_AGRICULTURE_STATION_BLOCK_POI.get(),
                    x -> x.get() == WIZARD_AGRICULTURE_STATION_BLOCK_POI.get(), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));

    public static void registerPOIs()
    {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null,
                    WIZARD_CAULDRON_BLOCK_POI.get(),
                    WIZARD_ALCHEMY_STATION_BLOCK_POI.get(),
                    WIZARD_WRITING_STATION_BLOCK_POI.get(),
                    WIZARD_RITUAL_STONE_BLOCK_POI.get(),
                    WIZARD_STONE_CUTTER_BLOCK_POI.get(),
                    WIZARD_FABRIC_STATION_BLOCK_POI.get(),
                    WIZARD_FORGE_BLOCK_POI.get(),
                    WIZARD_ASTRONOMY_STATION_BLOCK_POI.get(),
                    WIZARD_AGRICULTURE_STATION_BLOCK_POI.get()
            );
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus)
    {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
