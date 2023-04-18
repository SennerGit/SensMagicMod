package net.sen.sensmagicmod.common.world;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.block.ModBlockss;

import java.util.List;

public class ModPlaceFeatures
{
    public static ResourceKey<PlacedFeature> GRAY_LEAF_PLACED_KEY = createKey("gray_leaf_placed");

    public static ResourceKey<PlacedFeature> BLOCK_CRYSTAL_ENDER_PLACED_KEY = createKey("block_crystal_ender_placed");

    /**********************
     METALLURGY
     **********************/
    //Crimson Steel
    public static ResourceKey<PlacedFeature> CRIMSON_STEEL_PLACED_KEY = createKey("crimson_steel_placed");
    public static ResourceKey<PlacedFeature> NETHER_CRIMSON_STEEL_PLACED_KEY = createKey("nether_crimson_steel_placed");

    //Orichalcum
    public static ResourceKey<PlacedFeature> ORICHALCUM_PLACED_KEY = createKey("orichalcum_placed");

    //Mythril
    public static ResourceKey<PlacedFeature> MYTHRIL_PLACED_KEY = createKey("mythril_placed");

    //Blood stone
    public static ResourceKey<PlacedFeature> BLOOD_STONE_PLACED_KEY = createKey("blood_stone_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, GRAY_LEAF_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GRAY_LEAF_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2), ModBlockss.GRAY_LEAF_SAPLING.get()));

        /**********************
         CRYSTAL
         **********************/
        register(context, BLOCK_CRYSTAL_ENDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLOCK_CRYSTAL_ENDER_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        /**********************
         METALLURGY
         **********************/
        //Crimson Steel
        register(context, CRIMSON_STEEL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_CRIMSON_STEEL_KEY),
                ModOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, NETHER_CRIMSON_STEEL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_CRIMSON_STEEL_KEY),
                ModOrePlacement.commonOrePlacement(9,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        //Orichalcum
        register(context, ORICHALCUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ORICHALCUM_KEY),
                ModOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        //Mythril
        register(context, MYTHRIL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MYTHRIL_KEY),
                ModOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        //Blood stone
        register(context, BLOOD_STONE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_BLOOD_STONE_KEY),
                ModOrePlacement.commonOrePlacement(16,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

    }

    private static ResourceKey<PlacedFeature> createKey(String name)
    {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(SensMagicMod.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers)
    {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, PlacementModifier...modifiers)
    {
        register(context, key, configuration, List.of(modifiers));
    }
}
