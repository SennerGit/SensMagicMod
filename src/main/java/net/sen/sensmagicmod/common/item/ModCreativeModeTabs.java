package net.sen.sensmagicmod.common.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.block.ModBlockss;

@Mod.EventBusSubscriber(modid = SensMagicMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs
{
    public static CreativeModeTab SENS_MAGIC_BUILDING_BLOCKS_TAB;
    public static CreativeModeTab SENS_MAGIC_COLOURED_BLOCKS_TAB;
    public static CreativeModeTab SENS_MAGIC_NATURAL_BLOCKS_TAB;
    public static CreativeModeTab SENS_MAGIC_FUNCTIONAL_BLOCKS_TAB;
    public static CreativeModeTab SENS_MAGIC_TAB;
    public static CreativeModeTab SENS_MAGIC_TOOLS_AND_UTILS_TAB;
    public static CreativeModeTab SENS_MAGIC_COMBAT_TAB;
    public static CreativeModeTab SENS_MAGIC_FOOD_AND_DRINKS_TAB;
    public static CreativeModeTab SENS_MAGIC_INGREDIENTS_TAB;
    public static CreativeModeTab SENS_MAGIC_SPAWN_EGGS_TAB;

    @SubscribeEvent
    public static void  registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        /*SENS_MAGIC_TAB = event.registerCreativeModeTab(new ResourceLocation(SensMagicMod.MODID, "sens_magic_tab"), builder -> builder
                .icon(() -> new ItemStack(ModItems.CRYSTAL_RAW_SMALL.get()))
                .title(Component.translatable("creativemodetab.sens_magic_tab"))
        );*/

        SENS_MAGIC_BUILDING_BLOCKS_TAB = createTab(event, "sens_magic_building_blocks_tab", ModBlockss.CRIMSON_STEEL_BLOCK.get());
        SENS_MAGIC_COLOURED_BLOCKS_TAB = createTab(event, "sens_magic_coloured_blocks_tab", Items.PURPLE_DYE);
        SENS_MAGIC_NATURAL_BLOCKS_TAB = createTab(event, "sens_magic_natural_blocks_tab", ModBlockss.GRAY_LEAF_WOOD.get());
        SENS_MAGIC_FUNCTIONAL_BLOCKS_TAB = createTab(event, "sens_magic_functional_blocks_tab", ModBlockss.WIZARD_WRITING_STATION.get());
        SENS_MAGIC_TAB = createTab(event, "sens_magic_tab", ModItems.CRYSTAL_RAW_SMALL.get());
        SENS_MAGIC_TOOLS_AND_UTILS_TAB = createTab(event, "sens_magic_tools_and_utils_tab", ModItems.CRIMSON_STEEL_PICKAXE.get());
        SENS_MAGIC_COMBAT_TAB = createTab(event, "sens_magic_combat_tab", ModItems.CRIMSON_STEEL_SWORD.get());
        SENS_MAGIC_FOOD_AND_DRINKS_TAB = createTab(event, "sens_magic_food_and_drinks_tab", ModItems.COOKED_STRAPHIN_MEAT.get());
        SENS_MAGIC_INGREDIENTS_TAB = createTab(event, "sens_magic_ingredients_tab", ModItems.STRAPHIN_HORN.get());
        SENS_MAGIC_SPAWN_EGGS_TAB = createTab(event, "sens_magic_spawn_eggs_tab", ModItems.STRAPHIN_SPAWN_EGG.get());
    }

    public static CreativeModeTab createTab(CreativeModeTabEvent.Register event, String name, ItemLike item)
    {
        return event.registerCreativeModeTab(new ResourceLocation(SensMagicMod.MODID, name), builder -> builder
                .icon(() -> new ItemStack(item))
                .title(Component.translatable("creativemodetab."+name))
        );
    }

    public static void register(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == ModCreativeModeTabs.SENS_MAGIC_BUILDING_BLOCKS_TAB)
        {
            event.accept(ModBlockss.CRIMSON_STEEL_BLOCK);
            event.accept(ModBlockss.ORICHALCUM_BLOCK);
            event.accept(ModBlockss.MYTHRIL_BLOCK);
            event.accept(ModBlockss.BLOOD_STONE_BLOCK);
            event.accept(ModBlockss.GRAY_LEAF_LOG);
            event.accept(ModBlockss.GRAY_LEAF_WOOD);
            event.accept(ModBlockss.GRAY_LEAF_PLANKS);
            event.accept(ModBlockss.STRIPPED_GRAY_LEAF_LOG);
            event.accept(ModBlockss.STRIPPED_GRAY_LEAF_WOOD);
            event.accept(ModBlockss.GRAY_LEAF_STAIRS);
            event.accept(ModBlockss.GRAY_LEAF_SLAB);
            event.accept(ModBlockss.GRAY_LEAF_FENCE);
            event.accept(ModBlockss.GRAY_LEAF_FENCE_GATE);
            event.accept(ModBlockss.GRAY_LEAF_DOOR);
            event.accept(ModBlockss.GRAY_LEAF_TRAP_DOOR);
        }

        if (event.getTab() == ModCreativeModeTabs.SENS_MAGIC_COLOURED_BLOCKS_TAB)
        {

        }

        if (event.getTab() == ModCreativeModeTabs.SENS_MAGIC_NATURAL_BLOCKS_TAB)
        {
            event.accept(ModBlockss.BLOCK_CRYSTAL_ENDER);
            event.accept(ModBlockss.CRIMSON_STEEL_ORE);
            event.accept(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE);
            event.accept(ModBlockss.CRIMSON_STEEL_NETHER_ORE);
            event.accept(ModBlockss.RAW_CRIMSON_STEEL_BLOCK);
            event.accept(ModBlockss.ORICHALCUM_ORE);
            event.accept(ModBlockss.ORICHALCUM_DEEPSLATE_ORE);
            event.accept(ModBlockss.RAW_ORICHALCUM_BLOCK);
            event.accept(ModBlockss.MYTHRIL_ORE);
            event.accept(ModBlockss.MYTHRIL_DEEPSLATE_ORE);
            event.accept(ModBlockss.RAW_MYTHRIL_BLOCK);
            event.accept(ModBlockss.BLOOD_STONE_ORE);
            event.accept(ModBlockss.BLOOD_STONE_DEEPSLATE_ORE);
            event.accept(ModBlockss.GRAY_LEAF_LOG);
            event.accept(ModBlockss.GRAY_LEAF_WOOD);
            event.accept(ModBlockss.GRAY_LEAF_PLANKS);
            event.accept(ModBlockss.STRIPPED_GRAY_LEAF_LOG);
            event.accept(ModBlockss.STRIPPED_GRAY_LEAF_WOOD);
            event.accept(ModBlockss.GRAY_LEAF_LEAVES);
            event.accept(ModBlockss.GRAY_LEAF_SAPLING);
        }

        if (event.getTab() == ModCreativeModeTabs.SENS_MAGIC_FUNCTIONAL_BLOCKS_TAB)
        {
            event.accept(ModBlockss.WIZARD_CAULDRON);
            event.accept(ModBlockss.WIZARD_ALCHEMY_STATION);
            event.accept(ModBlockss.WIZARD_WRITING_STATION);
            event.accept(ModBlockss.WIZARD_RITUAL_STONE);
            event.accept(ModBlockss.WIZARD_STONE_CUTTER);
            event.accept(ModBlockss.WIZARD_FABRIC_STATION);
            event.accept(ModBlockss.WIZARD_FORGE);
            event.accept(ModBlockss.WIZARD_ASTRONOMY_STATION);
            event.accept(ModBlockss.WIZARD_AGRICULTURE_STATION);
        }

        if (event.getTab() == ModCreativeModeTabs.SENS_MAGIC_TAB)
        {
            event.accept(ModBlockss.BLOCK_CRYSTAL_ENDER);
            event.accept(ModItems.CRYSTAL_ENDER_SMALL);
            event.accept(ModItems.CRYSTAL_RAW_SMALL);
            event.accept(ModItems.BLOOD_STONE_WAND);
            event.accept(ModItems.SENS_MAGIC_MOD_BOOK);
        }

        if (event.getTab() == ModCreativeModeTabs.SENS_MAGIC_TOOLS_AND_UTILS_TAB)
        {
            event.accept(ModItems.CRIMSON_STEEL_SHOVEL);
            event.accept(ModItems.CRIMSON_STEEL_PICKAXE);
            event.accept(ModItems.CRIMSON_STEEL_AXE);
            event.accept(ModItems.CRIMSON_STEEL_HOE);
            event.accept(ModItems.ORICHALCUM_SHOVEL);
            event.accept(ModItems.ORICHALCUM_PICKAXE);
            event.accept(ModItems.ORICHALCUM_AXE);
            event.accept(ModItems.ORICHALCUM_HOE);
            event.accept(ModItems.MYTHRIL_SHOVEL);
            event.accept(ModItems.MYTHRIL_PICKAXE);
            event.accept(ModItems.MYTHRIL_AXE);
            event.accept(ModItems.MYTHRIL_HOE);
        }

        if (event.getTab() == ModCreativeModeTabs.SENS_MAGIC_COMBAT_TAB)
        {
            event.accept(ModItems.CRIMSON_STEEL_SWORD);
            event.accept(ModItems.ORICHALCUM_SWORD);
            event.accept(ModItems.MYTHRIL_SWORD);
        }

        if (event.getTab() == ModCreativeModeTabs.SENS_MAGIC_FOOD_AND_DRINKS_TAB)
        {
            event.accept(ModItems.STRAPHIN_MEAT);
            event.accept(ModItems.COOKED_STRAPHIN_MEAT);
        }

        if (event.getTab() == ModCreativeModeTabs.SENS_MAGIC_INGREDIENTS_TAB)
        {
            event.accept(ModItems.CRIMSON_STEEL_RAW);
            event.accept(ModItems.CRIMSON_STEEL_INGOT);
            event.accept(ModItems.CRIMSON_STEEL_NUGGET);
            event.accept(ModItems.ORICHALCUM_RAW);
            event.accept(ModItems.ORICHALCUM_INGOT);
            event.accept(ModItems.ORICHALCUM_NUGGET);
            event.accept(ModItems.MYTHRIL_RAW);
            event.accept(ModItems.MYTHRIL_INGOT);
            event.accept(ModItems.MYTHRIL_NUGGET);
            event.accept(ModItems.BLOOD_STONE_GEM);
            event.accept(ModItems.STRAPHIN_HIDE);
            event.accept(ModItems.STRAPHIN_HORN);
        }

        if (event.getTab() == ModCreativeModeTabs.SENS_MAGIC_SPAWN_EGGS_TAB)
        {
            event.accept(ModItems.STRAPHIN_SPAWN_EGG);
        }
    }
}
