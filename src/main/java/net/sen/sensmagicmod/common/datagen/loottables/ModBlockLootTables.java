package net.sen.sensmagicmod.common.datagen.loottables;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.common.block.*;
import net.sen.sensmagicmod.common.item.ModItems;

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
        this.dropBlock();
        this.dropFunctionalBlock();
        this.dropOre();
        this.dropWood();
    }

    private void dropBlock()
    {

    }

    private void dropFunctionalBlock()
    {
        dropSelf(ModBlockss.WIZARD_CAULDRON.get());
        dropSelf(ModBlockss.WIZARD_ALCHEMY_STATION.get());
        dropSelf(ModBlockss.WIZARD_WRITING_STATION.get());
        dropSelf(ModBlockss.WIZARD_RITUAL_STONE.get());
        dropSelf(ModBlockss.WIZARD_STONE_CUTTER.get());
        dropSelf(ModBlockss.WIZARD_FABRIC_STATION.get());
        dropSelf(ModBlockss.WIZARD_FORGE.get());
        dropSelf(ModBlockss.WIZARD_ASTRONOMY_STATION.get());
        dropSelf(ModBlockss.WIZARD_AGRICULTURE_STATION.get());
    }

    private void dropOre()
    {
        dropSelf(ModBlockss.CRIMSON_STEEL_BLOCK.get());
        dropSelf(ModBlockss.RAW_CRIMSON_STEEL_BLOCK.get());
        add(ModBlockss.CRIMSON_STEEL_ORE.get(), (block) -> createOreDrop(ModBlockss.CRIMSON_STEEL_ORE.get(), ModItems.CRIMSON_STEEL_RAW.get()));
        add(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), (block) -> createOreDrop(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), ModItems.CRIMSON_STEEL_RAW.get()));
        add(ModBlockss.CRIMSON_STEEL_NETHER_ORE.get(), (block) -> createOreDrop(ModBlockss.CRIMSON_STEEL_ORE.get(), ModItems.CRIMSON_STEEL_RAW.get()));
        add(ModBlockss.BLOCK_CRYSTAL_ENDER.get(), (block) -> createOreDrop(ModBlockss.BLOCK_CRYSTAL_ENDER.get(), ModItems.CRYSTAL_ENDER_SMALL.get()));

        dropSelf(ModBlockss.ORICHALCUM_BLOCK.get());
        dropSelf(ModBlockss.RAW_ORICHALCUM_BLOCK.get());
        add(ModBlockss.ORICHALCUM_ORE.get(), (block) -> createOreDrop(ModBlockss.CRIMSON_STEEL_ORE.get(), ModItems.CRIMSON_STEEL_RAW.get()));
        add(ModBlockss.ORICHALCUM_DEEPSLATE_ORE.get(), (block) -> createOreDrop(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), ModItems.CRIMSON_STEEL_RAW.get()));

        dropSelf(ModBlockss.MYTHRIL_BLOCK.get());
        dropSelf(ModBlockss.RAW_MYTHRIL_BLOCK.get());
        add(ModBlockss.MYTHRIL_ORE.get(), (block) -> createOreDrop(ModBlockss.CRIMSON_STEEL_ORE.get(), ModItems.CRIMSON_STEEL_RAW.get()));
        add(ModBlockss.MYTHRIL_DEEPSLATE_ORE.get(), (block) -> createOreDrop(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), ModItems.CRIMSON_STEEL_RAW.get()));

        dropSelf(ModBlockss.BLOOD_STONE_BLOCK.get());
        add(ModBlockss.BLOOD_STONE_ORE.get(), (block) -> createOreDrop(ModBlockss.CRIMSON_STEEL_ORE.get(), ModItems.CRIMSON_STEEL_RAW.get()));
        add(ModBlockss.BLOOD_STONE_DEEPSLATE_ORE.get(), (block) -> createOreDrop(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), ModItems.CRIMSON_STEEL_RAW.get()));
    }

    private void dropWood()
    {
        dropSelf(ModBlockss.GRAY_LEAF_LOG.get());
        dropSelf(ModBlockss.GRAY_LEAF_WOOD.get());
        dropSelf(ModBlockss.STRIPPED_GRAY_LEAF_LOG.get());
        dropSelf(ModBlockss.STRIPPED_GRAY_LEAF_WOOD.get());
        dropSelf(ModBlockss.GRAY_LEAF_PLANKS.get());
        dropSelf(ModBlockss.GRAY_LEAF_SAPLING.get());
        dropSelf(ModBlockss.GRAY_LEAF_STAIRS.get());
        dropSelf(ModBlockss.GRAY_LEAF_SLAB.get());
        dropSelf(ModBlockss.GRAY_LEAF_FENCE.get());
        dropSelf(ModBlockss.GRAY_LEAF_FENCE_GATE.get());
        dropSelf(ModBlockss.GRAY_LEAF_DOOR.get());
        dropSelf(ModBlockss.GRAY_LEAF_TRAP_DOOR.get());

        add(ModBlockss.GRAY_LEAF_LEAVES.get(), (block) -> createLeavesDrops(block, ModBlockss.GRAY_LEAF_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlockss.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
