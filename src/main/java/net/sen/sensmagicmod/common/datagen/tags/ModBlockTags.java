package net.sen.sensmagicmod.common.datagen.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.sen.sensmagicmod.SensMagicMod;

public class ModBlockTags
{
    public static final TagKey<Block> GRAY_LEAF_LOG = create("gray_leaf_log");
    public static final TagKey<Block> CRIMSON_STEEL_ORES = create("crimson_steel_ores");
    public static final TagKey<Block> ORICHALCUM_ORES = create("orichalcum_ores");
    public static final TagKey<Block> MYTHRIL_ORES = create("mythril_ores");
    public static final TagKey<Block> BLOOD_STONE_ORES = create("blood_stone_ores");
    public static final TagKey<Block> NEEDS_CRIMSON_STEEL_TOOL = create("needs_crimson_steel_tool");
    public static final TagKey<Block> NEEDS_ORICHALCUM_TOOL = create("needs_orichalcum_tool");
    public static final TagKey<Block> NEEDS_MYTHRIL_TOOL = create("needs_mythril_tool");

    private static TagKey<Block> create(String name)
    {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(SensMagicMod.MODID, name));
    }
}
