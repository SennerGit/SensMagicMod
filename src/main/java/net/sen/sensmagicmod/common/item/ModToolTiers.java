package net.sen.sensmagicmod.common.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.sen.sensmagicmod.SensMagicMod;

import java.util.List;

public class ModToolTiers
{
    public static Tier CRIMSON_STEEL;
    public static Tier ORICHALCUM;
    public static Tier MYTHRIL;

    static {
        CRIMSON_STEEL = TierSortingRegistry.registerTier(
                new ForgeTier(2, 250, 6.0F, 2.0F, 14,
                        ModTags.Blocks.NEEDS_CRIMSON_STEEL, () -> Ingredient.of(ModItems.CRIMSON_STEEL_INGOT.get())),
                new ResourceLocation(SensMagicMod.MODID, "crimson_steel"), List.of(Tiers.NETHERITE), List.of());

        ORICHALCUM = TierSortingRegistry.registerTier(
                new ForgeTier(2, 250, 6.0F, 2.0F, 14,
                        ModTags.Blocks.NEEDS_ORICHALCUM, () -> Ingredient.of(ModItems.ORICHALCUM_INGOT.get())),
                new ResourceLocation(SensMagicMod.MODID, "orichalcum"), List.of(Tiers.NETHERITE), List.of());

        MYTHRIL = TierSortingRegistry.registerTier(
                new ForgeTier(2, 250, 6.0F, 2.0F, 14,
                        ModTags.Blocks.NEEDS_MYTHRIL, () -> Ingredient.of(ModItems.MYTHRIL_INGOT.get())),
                new ResourceLocation(SensMagicMod.MODID, "mythril"), List.of(Tiers.NETHERITE), List.of());
    }
}
