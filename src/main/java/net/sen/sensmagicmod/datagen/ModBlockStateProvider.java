package net.sen.sensmagicmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.block.*;

public class ModBlockStateProvider extends BlockStateProvider
{

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, SensMagicMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        blockWithItem(ModBlockss.BLOCK_CRYSTAL_ENDER);
        blockWithItem(ModBlockss.CRIMSON_STEEL_ORE);
        blockWithItem(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE);
        blockWithItem(ModBlockss.CRIMSON_STEEL_NETHER_ORE);
        blockWithItem(ModBlockss.CRIMSON_STEEL_END_ORE);
        blockWithItem(ModBlockss.CRIMSON_STEEL_BLOCK);
        blockWithItem(ModBlockss.RAW_CRIMSON_STEEL_BLOCK);

        logBlock((RotatedPillarBlock) ModBlockss.GRAY_LEAF_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlockss.GRAY_LEAF_WOOD.get(), blockTexture(ModBlockss.GRAY_LEAF_LOG.get()), blockTexture(ModBlockss.GRAY_LEAF_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlockss.STRIPPED_GRAY_LEAF_LOG.get(), new ResourceLocation(SensMagicMod.MODID, "block/stripped_gray_leaf_log"), new ResourceLocation(SensMagicMod.MODID, "block/stripped_gray_leaf_log_top"));
        axisBlock((RotatedPillarBlock) ModBlockss.STRIPPED_GRAY_LEAF_WOOD.get(), new ResourceLocation(SensMagicMod.MODID, "block/stripped_gray_leaf_log"), new ResourceLocation(SensMagicMod.MODID, "block/stripped_gray_leaf_log"));

        blockWithItem(ModBlockss.GRAY_LEAF_LEAVES);
        blockWithItem(ModBlockss.GRAY_LEAF_PLANKS);

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
