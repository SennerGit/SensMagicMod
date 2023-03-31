package net.sen.sensmagicmod.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.block.ModBlockss;

import java.util.List;

public class ModConfiguredFeatures
{
    public static final ResourceKey<ConfiguredFeature<?, ?>> GRAY_LEAF_KEY = registerKey("gray_leaf");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CRIMSON_STEEL_KEY = registerKey("crimson_steel_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_CRIMSON_STEEL_KEY = registerKey("nether_crimson_steel_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_CRIMSON_STEEL_KEY = registerKey("end_crimson_steel_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context)
    {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldCrimsonSteelOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlockss.CRIMSON_STEEL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get().defaultBlockState()));

        register(context, GRAY_LEAF_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlockss.GRAY_LEAF_LOG.get()),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.simple(ModBlockss.GRAY_LEAF_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, OVERWORLD_CRIMSON_STEEL_KEY, Feature.ORE, new OreConfiguration(overworldCrimsonSteelOres, 9));
        register(context, NETHER_CRIMSON_STEEL_KEY, Feature.ORE, new OreConfiguration(netherReplaceables, ModBlockss.CRIMSON_STEEL_NETHER_ORE.get().defaultBlockState(), 9));
        register(context, END_CRIMSON_STEEL_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlockss.CRIMSON_STEEL_END_ORE.get().defaultBlockState(), 9));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(SensMagicMod.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration)
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
