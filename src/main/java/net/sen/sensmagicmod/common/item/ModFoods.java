package net.sen.sensmagicmod.common.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods
{
    public static final FoodProperties STRAPHIN_MEAT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_STRAPHIN_MEAT = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).meat().build();
}
