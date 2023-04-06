package net.sen.sensmagicmod.datagen;

import com.google.common.collect.ImmutableList;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.block.ModBlockss;
import net.sen.sensmagicmod.item.ModItems;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public static final ImmutableList<ItemLike> CRIMSON_STEEL_SMELTABLES = ImmutableList.of(ModItems.CRIMSON_STEEL_RAW.get(), ModBlockss.CRIMSON_STEEL_ORE.get(), ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), ModBlockss.CRIMSON_STEEL_NETHER_ORE.get(), ModBlockss.CRIMSON_STEEL_END_ORE.get());

    public ModRecipeProvider(PackOutput output)
    {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer)
    {
        createOreRecipes("crimson_steel", consumer, CRIMSON_STEEL_SMELTABLES, ModItems.CRIMSON_STEEL_INGOT.get(), ModItems.CRIMSON_STEEL_RAW.get(), ModItems.CRIMSON_STEEL_NUGGET.get(), ModBlockss.CRIMSON_STEEL_BLOCK.get(), ModBlockss.RAW_CRIMSON_STEEL_BLOCK.get());
    }

    private void createOreRecipes(String name, Consumer<FinishedRecipe> consumer, ImmutableList<ItemLike> smeltable, ItemLike ingot, ItemLike raw, ItemLike nugget, ItemLike metalBlock, ItemLike rawBlock)
    {
        oreSmelting(consumer, smeltable, RecipeCategory.MISC, ingot, 0.7f, 200, name+"_ingot");
        oreBlasting(consumer, smeltable, RecipeCategory.MISC, ingot, 0.7f, 100, name+"_ingot");
        nineBlockStorageRecipesWithCustomUnpacking(consumer, RecipeCategory.MISC, ingot, RecipeCategory.BUILDING_BLOCKS, metalBlock, name+"_ingot_from_"+name+"_block", name+"_ingot");
        nineBlockStorageRecipes(consumer, RecipeCategory.MISC, raw, RecipeCategory.BUILDING_BLOCKS, rawBlock);
        nineBlockStorageRecipesWithCustomPacking(consumer, RecipeCategory.MISC, nugget, RecipeCategory.MISC, ingot, name+"_ingot_from_nuggets", name+"_ingot");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> p_250172_, RecipeCategory p_250588_, ItemLike p_251868_, float p_250789_, int p_252144_, String p_251687_)
    {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, p_250172_, p_250588_, p_251868_, p_250789_, p_252144_, p_251687_, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> p_251504_, RecipeCategory p_248846_, ItemLike p_249735_, float p_248783_, int p_250303_, String p_251984_)
    {
        oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, p_251504_, p_248846_, p_249735_, p_248783_, p_250303_, p_251984_, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeCategory p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
        for(ItemLike itemlike : p_249619_) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_).group(p_251450_).unlockedBy(getHasName(itemlike), has(itemlike)).save(p_250791_, new ResourceLocation(SensMagicMod.MODID, getItemName(p_250066_)) + p_249236_ + "_" + getItemName(itemlike));
        }

    }

    protected static void nineBlockStorageRecipesWithCustomPacking(Consumer<FinishedRecipe> p_250488_, RecipeCategory p_250885_, ItemLike p_251651_, RecipeCategory p_250874_, ItemLike p_248576_, String p_250171_, String p_249386_) {
        nineBlockStorageRecipes(p_250488_, p_250885_, p_251651_, p_250874_, p_248576_, p_250171_, p_249386_, getSimpleRecipeName(p_251651_), (String)null);
    }

    protected static void nineBlockStorageRecipesWithCustomUnpacking(Consumer<FinishedRecipe> p_250320_, RecipeCategory p_248979_, ItemLike p_249101_, RecipeCategory p_252036_, ItemLike p_250886_, String p_248768_, String p_250847_)
    {
        nineBlockStorageRecipes(p_250320_, p_248979_, p_249101_, p_252036_, p_250886_, getSimpleRecipeName(p_250886_), (String)null, p_248768_, p_250847_);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_)
    {
        nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_, ItemLike p_250042_, RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_, String p_252237_, @Nullable String p_250414_) {
        ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_)).save(p_250423_, new ResourceLocation(SensMagicMod.MODID, p_252237_));
        ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_).pattern("###").pattern("###").pattern("###").group(p_248641_).unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, new ResourceLocation(SensMagicMod.MODID,p_250475_));
    }
}
