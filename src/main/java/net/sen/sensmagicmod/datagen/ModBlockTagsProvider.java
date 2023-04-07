package net.sen.sensmagicmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.block.ModBlockss;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider
{
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, SensMagicMod.MODID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        /*tag(Tags.Blocks.ORE_RATES_DENSE).add(ModBlockss.BLOCK_CRYSTAL_ENDER.get());
        tag(Tags.Blocks.ORE_RATES_SINGULAR).add(ModBlockss.CRIMSON_STEEL_ORE.get(), ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), ModBlockss.CRIMSON_STEEL_NETHER_ORE.get(), ModBlockss.CRIMSON_STEEL_END_ORE.get());
        tag(Tags.Blocks.ORES).addTag(ORES_CRIMSON_STEEL).replace(false);
        tag(ORES_CRIMSON_STEEL).addTag(ModBlockTags.CRIMSON_STEEL_ORES);
        tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(ModBlockss.CRIMSON_STEEL_ORE.get());
        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get());
        tag(Tags.Blocks.ORES_IN_GROUND_NETHERRACK).add(ModBlockss.CRIMSON_STEEL_NETHER_ORE.get());
        tag(ORES_IN_GROUND_ENDSTONE).add(ModBlockss.BLOCK_CRYSTAL_ENDER.get(), ModBlockss.CRIMSON_STEEL_END_ORE.get());*/

        //Mining
        tag(NEEDS_IRON_TOOL).replace(false).add(ModBlockss.CRIMSON_STEEL_ORE.get(), ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), ModBlockss.CRIMSON_STEEL_NETHER_ORE.get(), ModBlockss.CRIMSON_STEEL_END_ORE.get(), ModBlockss.RAW_CRIMSON_STEEL_BLOCK.get(), ModBlockss.CRIMSON_STEEL_BLOCK.get());
        tag(NEEDS_DIAMOND_TOOL).replace(false).add(ModBlockss.BLOCK_CRYSTAL_ENDER.get());

        tag(PICKAXE).replace(false).add(ModBlockss.CRIMSON_STEEL_ORE.get(), ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), ModBlockss.CRIMSON_STEEL_NETHER_ORE.get(), ModBlockss.CRIMSON_STEEL_END_ORE.get(), ModBlockss.RAW_CRIMSON_STEEL_BLOCK.get(), ModBlockss.CRIMSON_STEEL_BLOCK.get(), ModBlockss.BLOCK_CRYSTAL_ENDER.get());

        //Logs
        tag(LOGS).add(ModBlockss.GRAY_LEAF_LOG.get(), ModBlockss.GRAY_LEAF_WOOD.get(), ModBlockss.STRIPPED_GRAY_LEAF_LOG.get(), ModBlockss.STRIPPED_GRAY_LEAF_WOOD.get());
    }

    private static TagKey<Block> tag(String name)
    {
        return BlockTags.create(new ResourceLocation(SensMagicMod.MODID, name));
    }

    public static final TagKey<Block> NEEDS_IRON_TOOL = tag("needs_iron_tool");
    public static final TagKey<Block> NEEDS_DIAMOND_TOOL = tag("needs_diamond_tool");
    public static final TagKey<Block> ORES_CRIMSON_STEEL = tag("ores/crimson_steel");

    public static final TagKey<Block> PICKAXE = tag("mineable/pickaxe");

    public static final TagKey<Block> ORES_IN_GROUND_ENDSTONE = tag("ores_in_ground/endstone");

    public static final TagKey<Block> LOGS = tag("logs");
}
