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

    public static final RegistryObject<Item> CRYSTAL_ENDER = ITEMS.register("crystal_ender", () -> new ItemCrystal(new Item.Properties()));
    public static final RegistryObject<Item> CRYSTAL_RAW = ITEMS.register("crystal_raw", () -> new ItemCrystal(new Item.Properties()));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
