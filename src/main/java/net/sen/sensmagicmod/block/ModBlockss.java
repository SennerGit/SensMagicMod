package net.sen.sensmagicmod.block;


import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.item.ModItems;
import net.sen.sensmagicmod.world.tree.GrayLeafGrower;

import java.util.function.Supplier;

public class ModBlockss
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SensMagicMod.MODID);

    //Crystals
    public static final RegistryObject<Block> BLOCK_CRYSTAL_ENDER = registerBlock("block_crystal_ender", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    /**********************
     METALLURGY
     **********************/
    //Crimson Steel
    public static final RegistryObject<Block> CRIMSON_STEEL_ORE = registerBlock("crimson_steel_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> CRIMSON_STEEL_DEEPSLATE_ORE = registerBlock("crimson_steel_deepslate_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> CRIMSON_STEEL_NETHER_ORE = registerBlock("nether_crimson_steel_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> CRIMSON_STEEL_END_ORE = registerBlock("end_crimson_steel_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> CRIMSON_STEEL_BLOCK = registerBlock("crimson_steel_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> RAW_CRIMSON_STEEL_BLOCK = registerBlock("raw_crimson_steel_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    /**********************
     TREE
     **********************/
    public static final RegistryObject<Block> GRAY_LEAF_LOG = registerBlock("gray_leaf_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5f)));
    public static final RegistryObject<Block> GRAY_LEAF_WOOD = registerBlock("gray_leaf_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(5f)));
    public static final RegistryObject<Block> STRIPPED_GRAY_LEAF_LOG = registerBlock("stripped_gray_leaf_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(5f)));
    public static final RegistryObject<Block> STRIPPED_GRAY_LEAF_WOOD = registerBlock("stripped_gray_leaf_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(5f)));

    public static final RegistryObject<Block> GRAY_LEAF_PLANKS = registerBlock("gray_leaf_planks", () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(5f)));
    public static final RegistryObject<Block> GRAY_LEAF_LEAVES = registerBlock("gray_leaf_leaves", () -> new ModFlammableLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> GRAY_LEAF_SAPLING = registerBlock("gray_leaf_sapling", () -> new SaplingBlock(new GrayLeafGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
