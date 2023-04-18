package net.sen.sensmagicmod.common.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.block.*;

public class ModBlockStateProvider extends BlockStateProvider
{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, SensMagicMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        this.registerBlocks();
        this.registerFunctionalBlocks();
        this.registerOres();
        this.registerTrees();
    }

    private void registerBlocks()
    {

    }

    private void registerFunctionalBlocks()
    {
        blockWithItem(ModBlockss.WIZARD_CAULDRON);
        blockWithItem(ModBlockss.WIZARD_ALCHEMY_STATION);
        blockWithItem(ModBlockss.WIZARD_WRITING_STATION);
        blockWithItem(ModBlockss.WIZARD_RITUAL_STONE);
        blockWithItem(ModBlockss.WIZARD_STONE_CUTTER);
        blockWithItem(ModBlockss.WIZARD_FABRIC_STATION);
        blockWithItem(ModBlockss.WIZARD_FORGE);
        blockWithItem(ModBlockss.WIZARD_ASTRONOMY_STATION);
        blockWithItem(ModBlockss.WIZARD_AGRICULTURE_STATION);
    }

    private void registerOres()
    {
        blockWithItem(ModBlockss.BLOCK_CRYSTAL_ENDER);

        blockWithItem(ModBlockss.CRIMSON_STEEL_ORE);
        blockWithItem(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE);
        blockWithItem(ModBlockss.CRIMSON_STEEL_NETHER_ORE);
        blockWithItem(ModBlockss.CRIMSON_STEEL_BLOCK);
        blockWithItem(ModBlockss.RAW_CRIMSON_STEEL_BLOCK);

        blockWithItem(ModBlockss.ORICHALCUM_ORE);
        blockWithItem(ModBlockss.ORICHALCUM_DEEPSLATE_ORE);
        blockWithItem(ModBlockss.ORICHALCUM_BLOCK);
        blockWithItem(ModBlockss.RAW_ORICHALCUM_BLOCK);

        blockWithItem(ModBlockss.MYTHRIL_ORE);
        blockWithItem(ModBlockss.MYTHRIL_DEEPSLATE_ORE);
        blockWithItem(ModBlockss.MYTHRIL_BLOCK);
        blockWithItem(ModBlockss.RAW_MYTHRIL_BLOCK);

        blockWithItem(ModBlockss.BLOOD_STONE_ORE);
        blockWithItem(ModBlockss.BLOOD_STONE_DEEPSLATE_ORE);
        blockWithItem(ModBlockss.BLOOD_STONE_BLOCK);
    }

    private void registerTrees()
    {
        logBlock((RotatedPillarBlock) ModBlockss.GRAY_LEAF_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlockss.GRAY_LEAF_WOOD.get(), blockTexture(ModBlockss.GRAY_LEAF_LOG.get()), blockTexture(ModBlockss.GRAY_LEAF_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlockss.STRIPPED_GRAY_LEAF_LOG.get(), new ResourceLocation(SensMagicMod.MODID, "block/stripped_gray_leaf_log"), new ResourceLocation(SensMagicMod.MODID, "block/stripped_gray_leaf_log_top"));
        axisBlock((RotatedPillarBlock) ModBlockss.STRIPPED_GRAY_LEAF_WOOD.get(), new ResourceLocation(SensMagicMod.MODID, "block/stripped_gray_leaf_log"), new ResourceLocation(SensMagicMod.MODID, "block/stripped_gray_leaf_log"));

        blockWithItem(ModBlockss.GRAY_LEAF_LEAVES);
        blockWithItem(ModBlockss.GRAY_LEAF_PLANKS);

        stairsBlock((StairBlock) ModBlockss.GRAY_LEAF_STAIRS.get(), blockTexture(ModBlockss.GRAY_LEAF_PLANKS.get()));
        slabBlock((SlabBlock) ModBlockss.GRAY_LEAF_SLAB.get(), blockTexture(ModBlockss.GRAY_LEAF_PLANKS.get()), blockTexture(ModBlockss.GRAY_LEAF_PLANKS.get()));
        fenceBlock((FenceBlock) ModBlockss.GRAY_LEAF_FENCE.get(), blockTexture(ModBlockss.GRAY_LEAF_PLANKS.get()));
        fenceGateBlock((FenceGateBlock) ModBlockss.GRAY_LEAF_FENCE_GATE.get(), blockTexture(ModBlockss.GRAY_LEAF_PLANKS.get()));
        doorBlock((DoorBlock) ModBlockss.GRAY_LEAF_DOOR.get(), blockTexture(ModBlockss.GRAY_LEAF_PLANKS.get()), blockTexture(ModBlockss.GRAY_LEAF_PLANKS.get()));
        trapdoorBlock((TrapDoorBlock) ModBlockss.GRAY_LEAF_TRAP_DOOR.get(), blockTexture(ModBlockss.GRAY_LEAF_PLANKS.get()), false);

        simpleBlockItem(ModBlockss.GRAY_LEAF_LOG.get(), models().withExistingParent("sensmagicmod:gray_leaf_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlockss.GRAY_LEAF_WOOD.get(), models().withExistingParent("sensmagicmod:gray_leaf_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlockss.STRIPPED_GRAY_LEAF_LOG.get(), models().withExistingParent("sensmagicmod:stripped_gray_leaf_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlockss.STRIPPED_GRAY_LEAF_WOOD.get(), models().withExistingParent("sensmagicmod:stripped_gray_leaf_wood", "minecraft:block/cube_column"));

        saplingBlock(ModBlockss.GRAY_LEAF_SAPLING);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(), models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
