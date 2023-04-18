package net.sen.sensmagicmod.common.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.block.ModBlockss;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider
{
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, SensMagicMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        this.tag(BlockTags.PLANKS).add(ModBlockss.GRAY_LEAF_PLANKS.get());
        this.tag(BlockTags.SAPLINGS).add(ModBlockss.GRAY_LEAF_SAPLING.get());
        this.tag(ModBlockTags.GRAY_LEAF_LOG).add(ModBlockss.GRAY_LEAF_LOG.get()).add(ModBlockss.GRAY_LEAF_WOOD.get()).add(ModBlockss.STRIPPED_GRAY_LEAF_LOG.get()).add(ModBlockss.STRIPPED_GRAY_LEAF_WOOD.get());
        this.tag(BlockTags.LOGS_THAT_BURN).addTag(ModBlockTags.GRAY_LEAF_LOG);
        this.tag(BlockTags.OVERWORLD_NATURAL_LOGS).add(ModBlockss.GRAY_LEAF_LOG.get());
        this.tag(BlockTags.LEAVES).add(ModBlockss.GRAY_LEAF_LEAVES.get());
        this.tag(ModBlockTags.CRIMSON_STEEL_ORES).add(ModBlockss.CRIMSON_STEEL_ORE.get()).add(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get()).add(ModBlockss.CRIMSON_STEEL_NETHER_ORE.get());
        this.tag(ModBlockTags.ORICHALCUM_ORES).add(ModBlockss.ORICHALCUM_ORE.get()).add(ModBlockss.ORICHALCUM_DEEPSLATE_ORE.get());
        this.tag(ModBlockTags.MYTHRIL_ORES).add(ModBlockss.MYTHRIL_ORE.get()).add(ModBlockss.MYTHRIL_DEEPSLATE_ORE.get());
        this.tag(ModBlockTags.BLOOD_STONE_ORES).add(ModBlockss.BLOOD_STONE_ORE.get()).add(ModBlockss.BLOOD_STONE_DEEPSLATE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlockss.BLOCK_CRYSTAL_ENDER.get()).add(ModBlockss.ORICHALCUM_BLOCK.get()).addTag(ModBlockTags.ORICHALCUM_ORES).add(ModBlockss.RAW_ORICHALCUM_BLOCK.get()).add(ModBlockss.MYTHRIL_BLOCK.get()).addTag(ModBlockTags.MYTHRIL_ORES).add(ModBlockss.RAW_MYTHRIL_BLOCK.get()).add(ModBlockss.BLOOD_STONE_BLOCK.get()).addTag(ModBlockTags.BLOOD_STONE_ORES).add(ModBlockss.CRIMSON_STEEL_BLOCK.get()).addTag(ModBlockTags.CRIMSON_STEEL_ORES).add(ModBlockss.RAW_CRIMSON_STEEL_BLOCK.get()).add(ModBlockss.WIZARD_CAULDRON.get()).add(ModBlockss.WIZARD_STONE_CUTTER.get()).add(ModBlockss.WIZARD_RITUAL_STONE.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).addTag(ModBlockTags.GRAY_LEAF_LOG).add(ModBlockss.WIZARD_FABRIC_STATION.get(), ModBlockss.WIZARD_WRITING_STATION.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlockss.WIZARD_CAULDRON.get()).add(ModBlockss.WIZARD_STONE_CUTTER.get()).add(ModBlockss.WIZARD_RITUAL_STONE.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlockss.CRIMSON_STEEL_BLOCK.get()).addTag(ModBlockTags.CRIMSON_STEEL_ORES).add(ModBlockss.RAW_CRIMSON_STEEL_BLOCK.get());
        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlockss.BLOCK_CRYSTAL_ENDER.get()).add(ModBlockss.ORICHALCUM_BLOCK.get()).addTag(ModBlockTags.ORICHALCUM_ORES).add(ModBlockss.RAW_ORICHALCUM_BLOCK.get()).add(ModBlockss.MYTHRIL_BLOCK.get()).addTag(ModBlockTags.MYTHRIL_ORES).add(ModBlockss.RAW_MYTHRIL_BLOCK.get()).add(ModBlockss.BLOOD_STONE_BLOCK.get()).addTag(ModBlockTags.BLOOD_STONE_ORES);
        this.tag(ModBlockTags.NEEDS_CRIMSON_STEEL_TOOL);
        this.tag(ModBlockTags.NEEDS_ORICHALCUM_TOOL);
        this.tag(ModBlockTags.NEEDS_MYTHRIL_TOOL);
    }
}
