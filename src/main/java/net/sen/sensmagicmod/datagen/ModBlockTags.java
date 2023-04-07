package net.sen.sensmagicmod.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.sen.sensmagicmod.SensMagicMod;

public class ModBlockTags
{
    public static final TagKey<Block> CRIMSON_STEEL_ORES = create("crimson_steel_ores");

    private static TagKey<Block> create(String name)
    {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(SensMagicMod.MODID, name));
    }
}
