package net.sen.sensmagicmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
        BlockWithItem(ModBlocks.BLOCK_CRYSTAL_ENDER);
        BlockWithItem(ModBlocks.CRIMSON_STEEL_ORE);
        BlockWithItem(ModBlocks.CRIMSON_STEEL_DEEPSLATE_ORE);
        BlockWithItem(ModBlocks.CRIMSON_STEEL_BLOCK);
        BlockWithItem(ModBlocks.RAW_CRIMSON_STEEL_BLOCK);
    }

    private void BlockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
