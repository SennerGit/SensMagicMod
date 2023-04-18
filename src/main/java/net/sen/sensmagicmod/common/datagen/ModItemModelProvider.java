package net.sen.sensmagicmod.common.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.block.ModBlockss;
import net.sen.sensmagicmod.common.item.ItemCrystal;
import net.sen.sensmagicmod.common.item.ModItems;
import software.bernie.example.registry.ItemRegistry;

public class ModItemModelProvider extends ItemModelProvider
{

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, SensMagicMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        this.registerItems();
        this.registerMagic();
        this.registerMetal();
        this.registerTools();
        this.registerFood();
        this.registerIngredients();
        this.registerWood();
        this.registerSaplings();
        this.registerSpawnEggs();
        this.registerBooks();
    }

    private void registerBooks()
    {
        simpleItem(ModItems.SENS_MAGIC_MOD_BOOK_ICON, "sens_magic_mod_book");
        simpleItem(ModItems.SENS_MAGIC_MOD_BOOK, "sens_magic_mod_book");
    }

    private void registerIngredients()
    {
        simpleItem(ModItems.STRAPHIN_HIDE);
    }

    private void registerFood()
    {
        simpleItem(ModItems.STRAPHIN_MEAT);
        simpleItem(ModItems.COOKED_STRAPHIN_MEAT);
    }

    private void registerItems()
    {

    }

    private void registerSpawnEggs()
    {
        withExistingParent(ModItems.STRAPHIN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private void registerMagic()
    {
        simpleItemCrystal(ModItems.CRYSTAL_ENDER_SMALL);
        simpleItemCrystal(ModItems.CRYSTAL_RAW_SMALL);

        simpleItem(ModItems.BLOOD_STONE_WAND);
        simpleItem(ModItems.STRAPHIN_HORN);
    }

    private void registerMetal()
    {
        simpleItem(ModItems.CRIMSON_STEEL_RAW);
        simpleItem(ModItems.CRIMSON_STEEL_INGOT);
        simpleItem(ModItems.CRIMSON_STEEL_NUGGET);
        simpleItem(ModItems.ORICHALCUM_RAW);
        simpleItem(ModItems.ORICHALCUM_INGOT);
        simpleItem(ModItems.ORICHALCUM_NUGGET);
        simpleItem(ModItems.MYTHRIL_RAW);
        simpleItem(ModItems.MYTHRIL_INGOT);
        simpleItem(ModItems.MYTHRIL_NUGGET);
        simpleItem(ModItems.BLOOD_STONE_GEM);
    }

    private void registerTools()
    {
        simpleItem(ModItems.CRIMSON_STEEL_SWORD);
        simpleItem(ModItems.CRIMSON_STEEL_SHOVEL);
        simpleItem(ModItems.CRIMSON_STEEL_PICKAXE);
        simpleItem(ModItems.CRIMSON_STEEL_AXE);
        simpleItem(ModItems.CRIMSON_STEEL_HOE);

        simpleItem(ModItems.ORICHALCUM_SWORD);
        simpleItem(ModItems.ORICHALCUM_SHOVEL);
        simpleItem(ModItems.ORICHALCUM_PICKAXE);
        simpleItem(ModItems.ORICHALCUM_AXE);
        simpleItem(ModItems.ORICHALCUM_HOE);

        simpleItem(ModItems.MYTHRIL_SWORD);
        simpleItem(ModItems.MYTHRIL_SHOVEL);
        simpleItem(ModItems.MYTHRIL_PICKAXE);
        simpleItem(ModItems.MYTHRIL_AXE);
        simpleItem(ModItems.MYTHRIL_HOE);
    }

    private void registerWood()
    {
        withExistingParent("gray_leaf_stairs",  modLoc("block/gray_leaf_stairs"));
        withExistingParent("gray_leaf_slab",  modLoc("block/gray_leaf_slab"));
    }

    private void registerSaplings()
    {
        saplingItem(ModBlockss.GRAY_LEAF_SAPLING);
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SensMagicMod.MODID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SensMagicMod.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String name)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(SensMagicMod.MODID, "item/" + name));
    }

    private ItemModelBuilder simpleItemCrystal(RegistryObject<ItemCrystal> item)
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
