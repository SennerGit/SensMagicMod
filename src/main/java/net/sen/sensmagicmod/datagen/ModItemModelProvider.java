package net.sen.sensmagicmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider
{

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, SensMagicMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        simpleItem(ModItems.CRIMSON_STEEL_INGOT);
        simpleItem(ModItems.CRIMSON_STEEL_RAW);
        simpleItem(ModItems.CRIMSON_STEEL_NUGGET);
        simpleItem(ModItems.CRYSTAL_ENDER);
        simpleItem(ModItems.CRYSTAL_RAW);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SensMagicMod.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(SensMagicMod.MODID, "item/" + item.getId().getPath()));
    }
}
