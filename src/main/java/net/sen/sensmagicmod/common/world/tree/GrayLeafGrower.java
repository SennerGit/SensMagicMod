package net.sen.sensmagicmod.common.world.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.sen.sensmagicmod.common.world.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class GrayLeafGrower extends AbstractTreeGrower
{
    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_)
    {
        return ModConfiguredFeatures.GRAY_LEAF_KEY;
    }
}