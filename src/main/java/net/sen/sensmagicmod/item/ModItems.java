package net.sen.sensmagicmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.SensMagicMod;

public class ModItems
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SensMagicMod.MODID);

    //Magic Crystal
    public static final RegistryObject<Item> CRYSTAL_ENDER = ITEMS.register("crystal_ender", () -> new ItemCrystal(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_RAW = ITEMS.register("crystal_raw", () -> new ItemCrystal(new Item.Properties()));

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
