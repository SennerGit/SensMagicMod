package net.sen.sensmagicmod.common.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.sen.sensmagicmod.SensMagicMod;

public class ModTags
{
    public static class Blocks
    {
        public static final TagKey<Block> NEEDS_CRIMSON_STEEL = tag("needs_crimson_steel_tool");
        public static final TagKey<Block> NEEDS_ORICHALCUM = tag("needs_orichalcum_tool");
        public static final TagKey<Block> NEEDS_MYTHRIL = tag("needs_mythril_tool");

        private static TagKey<Block> tag(String name)
        {
            return BlockTags.create(new ResourceLocation(SensMagicMod.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name)
        {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
