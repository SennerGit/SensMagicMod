package net.sen.sensmagicmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.config.ConfigSensMagicMod;
import net.sen.sensmagicmod.magic.ModMagicElements;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SensMagicMod.MODID);

    /**********************
     MAGIC CRYSTALS
     **********************/
    //Small Magic Crystals
    public static final RegistryObject<ItemCrystal> CRYSTAL_RAW_SMALL = ITEMS.register("crystal_raw_small", () -> new ItemCrystal(new Item.Properties(), ConfigSensMagicMod.get().small_magic_capacity, ModMagicElements.RAW));
    public static final RegistryObject<ItemCrystal> CRYSTAL_ENDER_SMALL = ITEMS.register("crystal_ender_small", () -> new ItemCrystal(new Item.Properties(), ConfigSensMagicMod.get().small_magic_capacity, ModMagicElements.ENDER));

     /**********************
            METALLURGY
     **********************/
    //Crimson Steel
    public static final RegistryObject<Item> CRIMSON_STEEL_RAW = ITEMS.register("crimson_steel_raw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_STEEL_INGOT = ITEMS.register("crimson_steel_ingot", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_STEEL_NUGGET = ITEMS.register("crimson_steel_nugget", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
