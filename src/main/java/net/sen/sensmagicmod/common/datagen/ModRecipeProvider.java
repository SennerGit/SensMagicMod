package net.sen.sensmagicmod.common.datagen;

import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.block.ModBlockss;
import net.sen.sensmagicmod.common.item.ModItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public static final ImmutableList<ItemLike> CRIMSON_STEEL_SMELTABLES = ImmutableList.of(ModItems.CRIMSON_STEEL_RAW.get(), ModBlockss.CRIMSON_STEEL_ORE.get(), ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), ModBlockss.CRIMSON_STEEL_NETHER_ORE.get());
    public static final ImmutableList<ItemLike> ORICHALCUM_SMELTABLES = ImmutableList.of(ModItems.ORICHALCUM_RAW.get(), ModBlockss.ORICHALCUM_ORE.get(), ModBlockss.ORICHALCUM_DEEPSLATE_ORE.get());
    public static final ImmutableList<ItemLike> MYTHRIL_SMELTABLES = ImmutableList.of(ModItems.MYTHRIL_RAW.get(), ModBlockss.MYTHRIL_ORE.get(), ModBlockss.MYTHRIL_DEEPSLATE_ORE.get());

    public ModRecipeProvider(PackOutput output)
    {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer)
    {
        this.functionalBlocksRecipes(consumer);
        this.oreRecipes(consumer);
        this.toolRecipes(consumer);
        this.foodRecipes(consumer);
    }

    private void functionalBlocksRecipes(Consumer<FinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlockss.WIZARD_CAULDRON.get()).define('#', ModItems.CRIMSON_STEEL_INGOT.get()).define('C', Items.CAULDRON).pattern("# #").pattern("#C#").pattern("###").group(null).unlockedBy(getHasName(ModItems.CRIMSON_STEEL_INGOT.get()), has(ModItems.CRIMSON_STEEL_INGOT.get())).save(consumer, new ResourceLocation(SensMagicMod.MODID, "wizard_cauldron"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlockss.WIZARD_ALCHEMY_STATION.get()).define('#', Items.IRON_INGOT).define('P', Items.GLASS_BOTTLE).define('G', Blocks.GLASS).pattern("PGP").pattern("###").pattern("###").group(null).unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(consumer, new ResourceLocation(SensMagicMod.MODID, "wizard_alchemy_station"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlockss.WIZARD_WRITING_STATION.get()).define('#', ItemTags.PLANKS).define('P', Items.PAPER).define('F', Items.FEATHER).pattern(" FP").pattern("###").pattern("###").group(null).unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer, new ResourceLocation(SensMagicMod.MODID, "wizard_writing_station"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlockss.WIZARD_RITUAL_STONE.get()).define('#', ItemTags.STONE_BRICKS).define('C', ItemTags.WOOL_CARPETS).pattern(" C ").pattern("###").pattern("###").group(null).unlockedBy("has_stone_bricks", has(ItemTags.STONE_BRICKS)).save(consumer, new ResourceLocation(SensMagicMod.MODID, "wizard_ritual_stone"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlockss.WIZARD_STONE_CUTTER.get()).define('#', Items.IRON_INGOT).define('P', ItemTags.f_271360_).pattern("P P").pattern("###").pattern("###").group(null).unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(consumer, new ResourceLocation(SensMagicMod.MODID, "wizard_stone_cutter"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlockss.WIZARD_FABRIC_STATION.get()).define('#', ItemTags.PLANKS).define('S', Items.STRING).pattern("SSS").pattern("###").pattern("###").group(null).unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer, new ResourceLocation(SensMagicMod.MODID, "wizard_fabric_station"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlockss.WIZARD_FORGE.get()).define('#', ModItems.CRIMSON_STEEL_INGOT.get()).define('F', Blocks.FURNACE).pattern("###").pattern("#F#").pattern("###").group(null).unlockedBy(getHasName(ModItems.CRIMSON_STEEL_INGOT.get()), has(ModItems.CRIMSON_STEEL_INGOT.get())).save(consumer, new ResourceLocation(SensMagicMod.MODID, "wizard_forge"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlockss.WIZARD_ASTRONOMY_STATION.get()).define('#', Items.IRON_INGOT).define('G', Blocks.GLASS).pattern("##G").pattern(" # ").pattern("# #").group(null).unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT)).save(consumer, new ResourceLocation(SensMagicMod.MODID, "wizard_astronomy_station"));
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlockss.WIZARD_AGRICULTURE_STATION.get()).define('#', ItemTags.PLANKS).define('H', ItemTags.f_271298_).pattern("H H").pattern("###").pattern("###").group(null).unlockedBy("has_planks", has(ItemTags.PLANKS)).save(consumer, new ResourceLocation(SensMagicMod.MODID, "wizard_agriculture_station"));
    }

    private void foodRecipes(Consumer<FinishedRecipe> consumer)
    {
        cookRecipes(consumer, "smoking", RecipeSerializer.SMOKING_RECIPE, 100);
        cookRecipes(consumer, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, 600);
    }

    protected static void cookRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer, String cookingMethod, RecipeSerializer<? extends AbstractCookingRecipe> cookingSerializer, int cookingTime)
    {
        simpleCookingRecipe(finishedRecipeConsumer, cookingMethod, cookingSerializer, cookingTime, ModItems.STRAPHIN_MEAT.get(), ModItems.COOKED_STRAPHIN_MEAT.get(), 0.35F);
    }

    private void oreRecipes(Consumer<FinishedRecipe> consumer)
    {
        createOreRecipes("crimson_steel", consumer, CRIMSON_STEEL_SMELTABLES, ModItems.CRIMSON_STEEL_INGOT.get(), ModItems.CRIMSON_STEEL_RAW.get(), ModItems.CRIMSON_STEEL_NUGGET.get(), ModBlockss.CRIMSON_STEEL_BLOCK.get(), ModBlockss.RAW_CRIMSON_STEEL_BLOCK.get());
        createOreRecipes("orichalcum", consumer, ORICHALCUM_SMELTABLES, ModItems.ORICHALCUM_INGOT.get(), ModItems.ORICHALCUM_RAW.get(), ModItems.ORICHALCUM_NUGGET.get(), ModBlockss.ORICHALCUM_BLOCK.get(), ModBlockss.RAW_ORICHALCUM_BLOCK.get());
        createOreRecipes("mythril", consumer, MYTHRIL_SMELTABLES, ModItems.MYTHRIL_INGOT.get(), ModItems.MYTHRIL_RAW.get(), ModItems.MYTHRIL_NUGGET.get(), ModBlockss.MYTHRIL_BLOCK.get(), ModBlockss.RAW_MYTHRIL_BLOCK.get());
    }

    private void toolRecipes(Consumer<FinishedRecipe> consumer)
    {
        createToolRecipes("crimson_steel", consumer,
                ModItems.CRIMSON_STEEL_INGOT.get(),
                ModItems.CRIMSON_STEEL_SWORD.get(),
                ModItems.CRIMSON_STEEL_SHOVEL.get(),
                ModItems.CRIMSON_STEEL_PICKAXE.get(),
                ModItems.CRIMSON_STEEL_AXE.get(),
                ModItems.CRIMSON_STEEL_HOE.get(), (String) null);

        createToolRecipes("orichalcum", consumer,
                ModItems.ORICHALCUM_INGOT.get(),
                ModItems.ORICHALCUM_SWORD.get(),
                ModItems.ORICHALCUM_SHOVEL.get(),
                ModItems.ORICHALCUM_PICKAXE.get(),
                ModItems.ORICHALCUM_AXE.get(),
                ModItems.ORICHALCUM_HOE.get(), (String) null);

        createToolRecipes("mythril", consumer,
                ModItems.MYTHRIL_INGOT.get(),
                ModItems.MYTHRIL_SWORD.get(),
                ModItems.MYTHRIL_SHOVEL.get(),
                ModItems.MYTHRIL_PICKAXE.get(),
                ModItems.MYTHRIL_AXE.get(),
                ModItems.MYTHRIL_HOE.get(), (String) null);
    }

    private static void createToolRecipes(String name, Consumer<FinishedRecipe> consumer, ItemLike ingot, Item sword, Item shovel, Item pickaxe, Item axe, Item hoe, @Nullable String pPackedGroup)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, sword).define('#', ingot).define('S', Items.STICK).pattern(" # ").pattern(" # ").pattern(" S ").group(pPackedGroup).unlockedBy(getHasName(ingot), has(ingot)).save(consumer, new ResourceLocation(SensMagicMod.MODID, name+"_sword"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, shovel).define('#', ingot).define('S', Items.STICK).pattern(" # ").pattern(" S ").pattern(" S ").group(pPackedGroup).unlockedBy(getHasName(ingot), has(ingot)).save(consumer, new ResourceLocation(SensMagicMod.MODID, name+"_shovel"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, pickaxe).define('#', ingot).define('S', Items.STICK).pattern("###").pattern(" S ").pattern(" S ").group(pPackedGroup).unlockedBy(getHasName(ingot), has(ingot)).save(consumer, new ResourceLocation(SensMagicMod.MODID, name+"_pickaxe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, axe).define('#', ingot).define('S', Items.STICK).pattern("## ").pattern("#S ").pattern(" S ").group(pPackedGroup).unlockedBy(getHasName(ingot), has(ingot)).save(consumer, new ResourceLocation(SensMagicMod.MODID, name+"_axe"));
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, hoe).define('#', ingot).define('S', Items.STICK).pattern("## ").pattern(" S ").pattern(" S ").group(pPackedGroup).unlockedBy(getHasName(ingot), has(ingot)).save(consumer, new ResourceLocation(SensMagicMod.MODID, name+"_hoe"));
    }

    private static void createOreRecipes(String name, Consumer<FinishedRecipe> consumer, ImmutableList<ItemLike> smeltable, ItemLike ingot, ItemLike raw, ItemLike nugget, ItemLike metalBlock, ItemLike rawBlock)
    {
        oreSmelting(consumer, smeltable, RecipeCategory.MISC, ingot, 0.7f, 200, name+"_ingot");
        oreBlasting(consumer, smeltable, RecipeCategory.MISC, ingot, 0.7f, 100, name+"_ingot");
        nineBlockStorageRecipesWithCustomUnpacking(consumer, RecipeCategory.MISC, ingot, RecipeCategory.BUILDING_BLOCKS, metalBlock, name+"_ingot_from_"+name+"_block", name+"_ingot");
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, raw, RecipeCategory.BUILDING_BLOCKS, rawBlock);
        nineBlockStorageRecipesWithCustomPacking(consumer, RecipeCategory.MISC, nugget, RecipeCategory.MISC, ingot, name+"_ingot_from_nuggets", name+"_ingot");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> finishedRecipeConsumer, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group)
    {
        oreCooking(finishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, ingredients, category, result, experience, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> finishedRecipeConsumer, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group)
    {
        oreCooking(finishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, ingredients, category, result, experience, cookingTime, group, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> finishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> cookingSerializer, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group, String recipeName) {
        for(ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, cookingSerializer).group(group).unlockedBy(getHasName(itemlike), has(itemlike)).save(finishedRecipeConsumer, new ResourceLocation(SensMagicMod.MODID, getItemName(result)) + recipeName + "_" + getItemName(itemlike));
        }

    }

    protected static void nineBlockStorageRecipesWithCustomPacking(Consumer<FinishedRecipe> finishedRecipeConsumer, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed, String packedName, String unpackedName) {
        nineBlockStorageRecipes(finishedRecipeConsumer, unpackedCategory, unpacked, packedCategory, packed, packedName, unpackedName, getSimpleRecipeName(unpacked), (String)null);
    }

    protected static void nineBlockStorageRecipesWithCustomUnpacking(Consumer<FinishedRecipe> finishedRecipeConsumer, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed, String packedName, String unpackedName)
    {
        nineBlockStorageRecipes(finishedRecipeConsumer, unpackedCategory, unpacked, packedCategory, packed, getSimpleRecipeName(packed), (String)null, packedName, unpackedName);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed)
    {
        nineBlockStorageRecipes(finishedRecipeConsumer, unpackedCategory, unpacked, packedCategory, packed, getSimpleRecipeName(packed), (String)null, getSimpleRecipeName(unpacked), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer, RecipeCategory unpackedCategory, ItemLike unpacked, RecipeCategory packedCategory, ItemLike packed, String packedName, @Nullable String packedGroup, String unpackedName, @Nullable String unpackedGroup)
    {
        ShapelessRecipeBuilder.shapeless(unpackedCategory, unpacked, 9).requires(packed).group(unpackedGroup).unlockedBy(getHasName(packed), has(packed)).save(finishedRecipeConsumer, new ResourceLocation(SensMagicMod.MODID, unpackedName));
        ShapedRecipeBuilder.shaped(packedCategory, packed).define('#', unpacked).pattern("###").pattern("###").pattern("###").group(packedGroup).unlockedBy(getHasName(unpacked), has(unpacked)).save(finishedRecipeConsumer, new ResourceLocation(SensMagicMod.MODID, packedName));
    }

    protected static void simpleCookingRecipe(Consumer<FinishedRecipe> finishedRecipeConsumer, String cookingMethod, RecipeSerializer<? extends AbstractCookingRecipe> cookingSerializer, int cookingTime, ItemLike ingredient, ItemLike result, float experience)
    {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, cookingTime, cookingSerializer).unlockedBy(getHasName(ingredient), has(ingredient)).save(finishedRecipeConsumer, new ResourceLocation(SensMagicMod.MODID, getItemName(result) + "_from_" + cookingMethod));
    }
}
