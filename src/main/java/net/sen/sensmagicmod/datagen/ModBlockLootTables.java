package net.sen.sensmagicmod.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.block.*;
import net.sen.sensmagicmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider
{

    protected ModBlockLootTables()
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate()
    {
        dropSelf(ModBlockss.CRIMSON_STEEL_BLOCK.get());
        dropSelf(ModBlockss.RAW_CRIMSON_STEEL_BLOCK.get());
        add(ModBlockss.CRIMSON_STEEL_ORE.get(), (block) -> createOreDrop(ModBlockss.CRIMSON_STEEL_ORE.get(), ModItems.CRIMSON_STEEL_RAW.get()));
        add(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), (block) -> createOreDrop(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), ModItems.CRIMSON_STEEL_RAW.get()));
        add(ModBlockss.BLOCK_CRYSTAL_ENDER.get(), (block) -> createOreDrop(ModBlockss.BLOCK_CRYSTAL_ENDER.get(), ModItems.CRYSTAL_ENDER.get()));

        this.dropSelf(ModBlockss.GRAY_LEAF_LOG.get());
        this.dropSelf(ModBlockss.GRAY_LEAF_WOOD.get());
        this.dropSelf(ModBlockss.STRIPPED_GRAY_LEAF_LOG.get());
        this.dropSelf(ModBlockss.STRIPPED_GRAY_LEAF_WOOD.get());
        this.dropSelf(ModBlockss.GRAY_LEAF_PLANKS.get());
        this.dropSelf(ModBlockss.GRAY_LEAF_SAPLING.get());

        this.add(ModBlockss.GRAY_LEAF_LEAVES.get(), (block) -> createLeavesDrops(block, ModBlockss.GRAY_LEAF_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlockss.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
