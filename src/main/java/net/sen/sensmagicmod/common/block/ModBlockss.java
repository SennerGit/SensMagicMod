package net.sen.sensmagicmod.common.block;


import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.item.ModItems;
import net.sen.sensmagicmod.common.world.tree.GrayLeafGrower;

import java.util.Set;
import java.util.function.Supplier;

public class ModBlockss
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SensMagicMod.MODID);

    //Crystals
    public static final RegistryObject<Block> BLOCK_CRYSTAL_ENDER = registerBlock("block_crystal_ender", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    /**
     FUNCTIONAL BLOCKS
     */
    public static final RegistryObject<Block> WIZARD_CAULDRON = registerBlock("wizard_cauldron", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(.7F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WIZARD_ALCHEMY_STATION = registerBlock("wizard_alchemy_station", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(.7F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WIZARD_WRITING_STATION = registerBlock("wizard_writing_station", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(.7F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WIZARD_RITUAL_STONE = registerBlock("wizard_ritual_stone", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(.7F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WIZARD_STONE_CUTTER = registerBlock("wizard_stone_cutter", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(.7F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WIZARD_FABRIC_STATION = registerBlock("wizard_fabric_station", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(.7F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WIZARD_FORGE = registerBlock("wizard_forge", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(.7F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WIZARD_ASTRONOMY_STATION = registerBlock("wizard_astronomy_station", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(.7F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WIZARD_AGRICULTURE_STATION = registerBlock("wizard_agriculture_station", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(.7F).requiresCorrectToolForDrops()));

    /**
     METALLURGY
     */
    //Crimson Steel
    public static final RegistryObject<Block> CRIMSON_STEEL_ORE = registerBlock("crimson_steel_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> CRIMSON_STEEL_DEEPSLATE_ORE = registerBlock("crimson_steel_deepslate_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> CRIMSON_STEEL_NETHER_ORE = registerBlock("nether_crimson_steel_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> CRIMSON_STEEL_BLOCK = registerBlock("crimson_steel_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> RAW_CRIMSON_STEEL_BLOCK = registerBlock("raw_crimson_steel_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    //Orichalcum
    public static final RegistryObject<Block> ORICHALCUM_ORE = registerBlock("orichalcum_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> ORICHALCUM_DEEPSLATE_ORE = registerBlock("orichalcum_deepslate_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> ORICHALCUM_BLOCK = registerBlock("orichalcum_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> RAW_ORICHALCUM_BLOCK = registerBlock("raw_orichalcum_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    //Mythril
    public static final RegistryObject<Block> MYTHRIL_ORE = registerBlock("mythril_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> MYTHRIL_DEEPSLATE_ORE = registerBlock("mythril_deepslate_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
   public static final RegistryObject<Block> MYTHRIL_BLOCK = registerBlock("mythril_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> RAW_MYTHRIL_BLOCK = registerBlock("raw_mythril_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    //Blood stone
    public static final RegistryObject<Block> BLOOD_STONE_ORE = registerBlock("blood_stone_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> BLOOD_STONE_DEEPSLATE_ORE = registerBlock("blood_stone_deepslate_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> BLOOD_STONE_BLOCK = registerBlock("blood_stone_block", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));

    /**
     TREE
     */
    public static final RegistryObject<Block> GRAY_LEAF_LOG = registerBlock("gray_leaf_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5f)));
    public static final RegistryObject<Block> GRAY_LEAF_WOOD = registerBlock("gray_leaf_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(5f)));
    public static final RegistryObject<Block> STRIPPED_GRAY_LEAF_LOG = registerBlock("stripped_gray_leaf_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(5f)));
    public static final RegistryObject<Block> STRIPPED_GRAY_LEAF_WOOD = registerBlock("stripped_gray_leaf_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(5f)));

    public static final RegistryObject<Block> GRAY_LEAF_PLANKS = registerBlock("gray_leaf_planks", () -> new ModFlammableBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(5f)));
    public static final RegistryObject<Block> GRAY_LEAF_STAIRS = registerBlock("gray_leaf_stairs", () -> new ModFlammableStairsBlock(GRAY_LEAF_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(GRAY_LEAF_PLANKS.get())));
    public static final RegistryObject<Block> GRAY_LEAF_SLAB = registerBlock("gray_leaf_slab", () -> new ModFlammableSlabBlock(BlockBehaviour.Properties.copy(GRAY_LEAF_PLANKS.get())));
    public static final RegistryObject<Block> GRAY_LEAF_FENCE = registerBlock("gray_leaf_fence", () -> new ModFlammableFenceBlock(BlockBehaviour.Properties.copy(GRAY_LEAF_PLANKS.get())));
    public static final RegistryObject<Block> GRAY_LEAF_FENCE_GATE = registerBlock("gray_leaf_fence_gate", () -> new ModFlammableFenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.copy(GRAY_LEAF_PLANKS.get())));
    public static final RegistryObject<Block> GRAY_LEAF_DOOR = registerBlock("gray_leaf_door", () -> new ModFlammableDoorBlock(BlockSetType.f_271198_, BlockBehaviour.Properties.copy(GRAY_LEAF_PLANKS.get())));
    public static final RegistryObject<Block> GRAY_LEAF_TRAP_DOOR = registerBlock("gray_leaf_trap_door", () -> new ModFlammableTrapDoorBlock(BlockSetType.f_271198_, BlockBehaviour.Properties.copy(GRAY_LEAF_PLANKS.get())));

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
