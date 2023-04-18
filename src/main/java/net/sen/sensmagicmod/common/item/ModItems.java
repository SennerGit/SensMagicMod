package net.sen.sensmagicmod.common.item;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.config.ConfigSensMagicMod;
import net.sen.sensmagicmod.common.entity.ModEntities;
import net.sen.sensmagicmod.common.magic.ModMagicElements;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SensMagicMod.MODID);

    /**
     MAGIC CRYSTALS
     */
    //Small Magic Crystals
    public static final RegistryObject<ItemCrystal> CRYSTAL_RAW_SMALL = ITEMS.register("crystal_raw_small", () -> new ItemCrystal(new Item.Properties(), ConfigSensMagicMod.get().small_magic_capacity, ModMagicElements.RAW));
    public static final RegistryObject<ItemCrystal> CRYSTAL_ENDER_SMALL = ITEMS.register("crystal_ender_small", () -> new ItemCrystal(new Item.Properties(), ConfigSensMagicMod.get().small_magic_capacity, ModMagicElements.ENDER));

     /**
            METALLURGY
     */
    //Crimson Steel
    public static final RegistryObject<Item> CRIMSON_STEEL_RAW = ITEMS.register("crimson_steel_raw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_STEEL_INGOT = ITEMS.register("crimson_steel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_STEEL_NUGGET = ITEMS.register("crimson_steel_nugget", () -> new Item(new Item.Properties()));

    //Orichalcum
    public static final RegistryObject<Item> ORICHALCUM_RAW = ITEMS.register("orichalcum_raw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_INGOT = ITEMS.register("orichalcum_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_NUGGET = ITEMS.register("orichalcum_nugget", () -> new Item(new Item.Properties()));


    //Mythril
    public static final RegistryObject<Item> MYTHRIL_RAW = ITEMS.register("mythril_raw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_INGOT = ITEMS.register("mythril_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_NUGGET = ITEMS.register("mythril_nugget", () -> new Item(new Item.Properties()));

    //Blood stone
    public static final RegistryObject<Item> BLOOD_STONE_GEM = ITEMS.register("blood_stone_gem", () -> new Item(new Item.Properties()));


    /**
     TOOLS
     */
    //Crimson Steel
    public static final RegistryObject<Item> CRIMSON_STEEL_SWORD = ITEMS.register("crimson_steel_sword", () -> new SwordItem(ModToolTiers.CRIMSON_STEEL, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_STEEL_SHOVEL = ITEMS.register("crimson_steel_shovel", () -> new ShovelItem(ModToolTiers.CRIMSON_STEEL, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_STEEL_PICKAXE = ITEMS.register("crimson_steel_pickaxe", () -> new PickaxeItem(ModToolTiers.CRIMSON_STEEL, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_STEEL_AXE = ITEMS.register("crimson_steel_axe", () -> new AxeItem(ModToolTiers.CRIMSON_STEEL, 6.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_STEEL_HOE = ITEMS.register("crimson_steel_hoe", () -> new HoeItem(ModToolTiers.CRIMSON_STEEL, -2, -1.0F, new Item.Properties()));

    //Orichalcum
    public static final RegistryObject<Item> ORICHALCUM_SWORD = ITEMS.register("orichalcum_sword", () -> new SwordItem(ModToolTiers.ORICHALCUM, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_SHOVEL = ITEMS.register("orichalcum_shovel", () -> new ShovelItem(ModToolTiers.ORICHALCUM, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_PICKAXE = ITEMS.register("orichalcum_pickaxe", () -> new PickaxeItem(ModToolTiers.ORICHALCUM, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_AXE = ITEMS.register("orichalcum_axe", () -> new AxeItem(ModToolTiers.ORICHALCUM, 6.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_HOE = ITEMS.register("orichalcum_hoe", () -> new HoeItem(ModToolTiers.ORICHALCUM, -2, -1.0F, new Item.Properties()));

    //Mythril
    public static final RegistryObject<Item> MYTHRIL_SWORD = ITEMS.register("mythril_sword", () -> new SwordItem(ModToolTiers.MYTHRIL, 3, -2.4F, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_SHOVEL = ITEMS.register("mythril_shovel", () -> new ShovelItem(ModToolTiers.MYTHRIL, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_PICKAXE = ITEMS.register("mythril_pickaxe", () -> new PickaxeItem(ModToolTiers.MYTHRIL, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_AXE = ITEMS.register("mythril_axe", () -> new AxeItem(ModToolTiers.MYTHRIL, 6.0F, -3.1F, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_HOE = ITEMS.register("mythril_hoe", () -> new HoeItem(ModToolTiers.MYTHRIL, -2, -1.0F, new Item.Properties()));

    /**
     MAGIC TOOLS
     */
    //Blood stone
    public static final RegistryObject<Item> BLOOD_STONE_WAND = ITEMS.register("blood_stone_wand", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STRAPHIN_HORN = ITEMS.register("straphin_horn", () -> new Item(new Item.Properties()));

    /**
     INGREDIENTS
     */
    //Straphin
    public static final RegistryObject<Item> STRAPHIN_HIDE = ITEMS.register("straphin_hide", () -> new Item(new Item.Properties()));

    /**
     FOOD
     */
    public static final RegistryObject<Item> STRAPHIN_MEAT = ITEMS.register("straphin_meat", () -> new Item(new Item.Properties().food(ModFoods.STRAPHIN_MEAT)));
    public static final RegistryObject<Item> COOKED_STRAPHIN_MEAT = ITEMS.register("cooked_straphin_meat", () -> new Item(new Item.Properties().food(ModFoods.COOKED_STRAPHIN_MEAT)));

    /**
     SPAWN EGG
     */
    public static final RegistryObject<Item> STRAPHIN_SPAWN_EGG = ITEMS.register("straphin_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.STRAPHIN, 0xD57E36, 0x1D0D00, new Item.Properties()));

    /**
     BOOK
     */
    public static final RegistryObject<Item> SENS_MAGIC_MOD_BOOK_ICON = ITEMS.register("sens_magic_mod_book_icon", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SENS_MAGIC_MOD_BOOK = ITEMS.register("sens_magic_mod_book", () -> new GuideBookItem(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
