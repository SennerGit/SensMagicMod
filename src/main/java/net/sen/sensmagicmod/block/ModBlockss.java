package net.sen.sensmagicmod.block;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlockss
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SensMagicMod.MODID);

    //Crystals
    public static final RegistryObject<Block> BLOCK_CRYSTAL_ENDER = RegisterBlock("block_crystal_ender", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    /**********************
     METALLURGY
     **********************/
    //Crimson Steel
    public static final RegistryObject<Block> CRIMSON_STEEL_ORE = RegisterBlock("crimson_steel_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> CRIMSON_STEEL_DEEPSLATE_ORE = RegisterBlock("crimson_steel_deepslate_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> CRIMSON_STEEL_BLOCK = RegisterBlock("crimson_steel_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> RAW_CRIMSON_STEEL_BLOCK = RegisterBlock("raw_crimson_steel_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    /**********************
     TREE
     **********************/
    public static final RegistryObject<Block> GRAY_LEAF_LOG = RegisterBlock("gray_leaf_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5f)));
    public static final RegistryObject<Block> GRAY_LEAF_WOOD = RegisterBlock("gray_leaf_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(5f)));
    public static final RegistryObject<Block> STRIPPED_GRAY_LEAF_LOG = RegisterBlock("stripped_gray_leaf_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(5f)));
    public static final RegistryObject<Block> STRIPPED_GRAY_LEAF_WOOD = RegisterBlock("stripped_gray_leaf_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(5f)));

    public static final RegistryObject<Block> GRAY_LEAF_PLANKS = RegisterBlock("gray_leaf_planks", () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(5f)));
    public static final RegistryObject<Block> GRAY_LEAF_LEAVES = RegisterBlock("gray_leaf_leaves", () -> new ModFlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> GRAY_LEAF_SAPLING = RegisterBlock("gray_leaf_sapling", () -> new SaplingBlock(null, BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    private static <T extends Block> RegistryObject<T> RegisterBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        RegisterBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> RegisterBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void Register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
