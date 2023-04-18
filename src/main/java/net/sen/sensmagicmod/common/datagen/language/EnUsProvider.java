package net.sen.sensmagicmod.common.datagen.language;

import com.klikli_dev.modonomicon.api.ModonomiconAPI;
import com.klikli_dev.modonomicon.api.datagen.BookLangHelper;
import net.minecraft.data.PackOutput;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraftforge.common.data.LanguageProvider;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.block.ModBlockss;
import net.sen.sensmagicmod.common.entity.ModEntities;
import net.sen.sensmagicmod.common.item.ModCreativeModeTabs;
import net.sen.sensmagicmod.common.item.ModItems;
import net.sen.sensmagicmod.common.util.ModKeyBindings;
import net.sen.sensmagicmod.common.villager.ModVillagers;

public class EnUsProvider extends LanguageProvider
{
    public EnUsProvider(PackOutput output)
    {
        super(output, SensMagicMod.MODID, "en_us");
    }

    @Override
    protected void addTranslations()
    {
        this.addModBook();

        this.addBlock();
        this.addFunctionalBlocks();
        this.addOre();
        this.addTree();
        this.addItem();
        this.addTools();
        this.addMagic();
        this.addIngredients();
        this.addFood();
        this.addCreativeTab();
        this.addToolTip();
        this.addGuiElement();
        this.addKeyBinding();
        this.addEntity();
        this.addVillager();
    }

    private void addBlock()
    {
        this.add(ModBlockss.BLOCK_CRYSTAL_ENDER.get(), "Ender Crytsal Block");
            /*this.add(ModBlockss.CRIMSON_STEEL_ORE.get(), "Crimson Steel Ore");
            this.add(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(), "Deepslate Crimson Steel Ore");
            this.add(ModBlockss.CRIMSON_STEEL_NETHER_ORE.get(), "Nether Crimson Steel Ore");
            this.add(ModBlockss.CRIMSON_STEEL_END_ORE.get(), "End Crimson Steel Ore");
            this.add(ModBlockss.CRIMSON_STEEL_BLOCK.get(), "Crimson Steel Block");
            this.add(ModBlockss.RAW_CRIMSON_STEEL_BLOCK.get(), "Raw Crimson Steel Block");
            this.add(ModBlockss.GRAY_LEAF_LOG.get(), "Gray Leaf Log");
            this.add(ModBlockss.GRAY_LEAF_WOOD.get(), "Gray Leaf Wood");
            this.add(ModBlockss.STRIPPED_GRAY_LEAF_LOG.get(), "Stripped Gray Leaf Log");
            this.add(ModBlockss.STRIPPED_GRAY_LEAF_WOOD.get(), "Stripped Gray Leaf Wood");
            this.add(ModBlockss.GRAY_LEAF_PLANKS.get(), "Gray Leaf Planks");
            this.add(ModBlockss.GRAY_LEAF_LEAVES.get(), "Gray Leaf Leaves");
            this.add(ModBlockss.GRAY_LEAF_SAPLING.get(), "Gray Leaf Sapling");*/
    }

    private void addFunctionalBlocks()
    {
        add(ModBlockss.WIZARD_CAULDRON.get(), "Wizard Cauldron");
        add(ModBlockss.WIZARD_ALCHEMY_STATION.get(), "Wizard Alchemy Station");
        add(ModBlockss.WIZARD_WRITING_STATION.get(), "Wizard Writing Station");
        add(ModBlockss.WIZARD_RITUAL_STONE.get(), "Wizard Ritual Stone");
        add(ModBlockss.WIZARD_STONE_CUTTER.get(), "Wizard Stone Cutter");
        add(ModBlockss.WIZARD_FABRIC_STATION.get(), "Wizard Fabric Station");
        add(ModBlockss.WIZARD_FORGE.get(), "Wizard Forge");
        add(ModBlockss.WIZARD_ASTRONOMY_STATION.get(), "Wizard Astronomy Station");
        add(ModBlockss.WIZARD_AGRICULTURE_STATION.get(), "Wizard Agriculture Station");
    }

    private void addMagic()
    {
        this.add(ModItems.BLOOD_STONE_WAND.get(), "Blood Stone Wand");
        this.add(ModItems.STRAPHIN_HORN.get(), "Straphin Horn");
    }

    private void addIngredients()
    {
        this.add(ModItems.STRAPHIN_HIDE.get(), "Straphin Hide");
    }

    private void addTree()
    {
        this.addTreeLang("Gray Leaf",
                ModBlockss.GRAY_LEAF_LOG.get(),
                ModBlockss.GRAY_LEAF_WOOD.get(),
                ModBlockss.STRIPPED_GRAY_LEAF_LOG.get(),
                ModBlockss.STRIPPED_GRAY_LEAF_WOOD.get(),
                ModBlockss.GRAY_LEAF_PLANKS.get(),
                ModBlockss.GRAY_LEAF_LEAVES.get(),
                ModBlockss.GRAY_LEAF_SAPLING.get(),
                ModBlockss.GRAY_LEAF_STAIRS.get(),
                ModBlockss.GRAY_LEAF_SLAB.get(),
                ModBlockss.GRAY_LEAF_FENCE.get(),
                ModBlockss.GRAY_LEAF_FENCE_GATE.get(),
                ModBlockss.GRAY_LEAF_DOOR.get(),
                ModBlockss.GRAY_LEAF_TRAP_DOOR.get()
        );
    }

    private void addOre()
    {
        this.addOreLang("Crimson Steel",
                ModBlockss.CRIMSON_STEEL_ORE.get(),
                ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE.get(),
                ModBlockss.CRIMSON_STEEL_NETHER_ORE.get(),
                ModBlockss.CRIMSON_STEEL_BLOCK.get(),
                ModBlockss.RAW_CRIMSON_STEEL_BLOCK.get(),
                ModItems.CRIMSON_STEEL_INGOT.get(),
                ModItems.CRIMSON_STEEL_RAW.get(),
                ModItems.CRIMSON_STEEL_NUGGET.get()
        );

        this.addOreLang("Orichalcum",
                ModBlockss.ORICHALCUM_ORE.get(),
                ModBlockss.ORICHALCUM_DEEPSLATE_ORE.get(),
                ModBlockss.ORICHALCUM_BLOCK.get(),
                ModBlockss.RAW_ORICHALCUM_BLOCK.get(),
                ModItems.ORICHALCUM_INGOT.get(),
                ModItems.ORICHALCUM_RAW.get(),
                ModItems.ORICHALCUM_NUGGET.get()
        );

        this.addOreLang("Mythril",
                ModBlockss.MYTHRIL_ORE.get(),
                ModBlockss.MYTHRIL_DEEPSLATE_ORE.get(),
                ModBlockss.MYTHRIL_BLOCK.get(),
                ModBlockss.RAW_MYTHRIL_BLOCK.get(),
                ModItems.MYTHRIL_INGOT.get(),
                ModItems.MYTHRIL_RAW.get(),
                ModItems.MYTHRIL_NUGGET.get()
        );

        this.addOreLang("Blood Stone",
                ModBlockss.BLOOD_STONE_ORE.get(),
                ModBlockss.BLOOD_STONE_DEEPSLATE_ORE.get(),
                ModBlockss.BLOOD_STONE_BLOCK.get(),
                ModItems.BLOOD_STONE_GEM.get()
        );
    }

    private void addItem()
    {
        this.add(ModItems.CRYSTAL_ENDER_SMALL.get(), "Small Ender Magic Crystal");
        this.add(ModItems.CRYSTAL_RAW_SMALL.get(), "Small Raw Magic Crystal");
        /*this.add(ModItems.CRIMSON_STEEL_RAW.get(), "Crimson Steel Raw");
        this.add(ModItems.CRIMSON_STEEL_INGOT.get(), "Crimson Steel Ingot");
        this.add(ModItems.CRIMSON_STEEL_NUGGET.get(), "Crimson Steel Nugget");*/
    }

    private void addTools()
    {
        addToolsLang("Crimson Steel",
                ModItems.CRIMSON_STEEL_SWORD.get(),
                ModItems.CRIMSON_STEEL_SHOVEL.get(),
                ModItems.CRIMSON_STEEL_PICKAXE.get(),
                ModItems.CRIMSON_STEEL_AXE.get(),
                ModItems.CRIMSON_STEEL_HOE.get()
        );

        addToolsLang("Orichalcum",
                ModItems.ORICHALCUM_SWORD.get(),
                ModItems.ORICHALCUM_SHOVEL.get(),
                ModItems.ORICHALCUM_PICKAXE.get(),
                ModItems.ORICHALCUM_AXE.get(),
                ModItems.ORICHALCUM_HOE.get()
        );

        addToolsLang("Mythril",
                ModItems.MYTHRIL_SWORD.get(),
                ModItems.MYTHRIL_SHOVEL.get(),
                ModItems.MYTHRIL_PICKAXE.get(),
                ModItems.MYTHRIL_AXE.get(),
                ModItems.MYTHRIL_HOE.get()
        );
    }

    private void addEntity()
    {
        this.addEntityLang("Straphin Stag", ModEntities.STRAPHIN.get(), ModItems.STRAPHIN_SPAWN_EGG.get());
        /*this.add(ModEntities.STRAPHIN.get(), "Straphin Stag");
        this.add(ModItems.STRAPHIN_SPAWN_EGG.get(), "Straphin Stag Spawn Egg");*/
    }

    private void addCreativeTab()
    {
        addCreativeTabLang(ModCreativeModeTabs.SENS_MAGIC_BUILDING_BLOCKS_TAB, "Magic Building Blocks");
        addCreativeTabLang(ModCreativeModeTabs.SENS_MAGIC_COLOURED_BLOCKS_TAB, "Magic Colored Blocks");
        addCreativeTabLang(ModCreativeModeTabs.SENS_MAGIC_NATURAL_BLOCKS_TAB, "Magic Natural Blocks");
        addCreativeTabLang(ModCreativeModeTabs.SENS_MAGIC_FUNCTIONAL_BLOCKS_TAB, "Magic Functional Blocks");
        addCreativeTabLang(ModCreativeModeTabs.SENS_MAGIC_TAB, "Magic");
        addCreativeTabLang(ModCreativeModeTabs.SENS_MAGIC_TOOLS_AND_UTILS_TAB, "Magic Tools & Utils");
        addCreativeTabLang(ModCreativeModeTabs.SENS_MAGIC_COMBAT_TAB, "Magic Combat");
        addCreativeTabLang(ModCreativeModeTabs.SENS_MAGIC_FOOD_AND_DRINKS_TAB, "Magic Food & Drinks");
        addCreativeTabLang(ModCreativeModeTabs.SENS_MAGIC_INGREDIENTS_TAB, "Magic Ingredients");
        addCreativeTabLang(ModCreativeModeTabs.SENS_MAGIC_SPAWN_EGGS_TAB, "Magic Spawn Eggs");
    }

    private void addToolTip()
    {
        addToolTipLang("crystal.magic.element", "Element: %d");
        addToolTipLang("crystal.magic.capacity", "Current Magic Capacity: %dME/%dME");
        addToolTipLang("crystal.guide", "Press SHIFT for more info");
    }

    private void addGuiElement()
    {

    }

    private void addKeyBinding()
    {
        addKeyBindingCategoryLang(ModKeyBindings.KEY_CATEGORY_SENS_MAGIC_MOD, "Sens Magic Mod");
        addKeyBindingLang(ModKeyBindings.KEY_TEMP, "Temp Key Binding");
    }

    private void addVillager()
    {
        addVillagerLang(ModVillagers.WIZARD_INGREDIENTS_SELLER.get(), "Wizard Ingredients Seller");
        addVillagerLang(ModVillagers.WIZARD_POTION_SELLER.get(), "Wizard Potions Seller");
        addVillagerLang(ModVillagers.WIZARD_SCROLL_SELLER.get(), "Wizard Scrolls Seller");
        addVillagerLang(ModVillagers.WIZARD_RITUAL_SELLER.get(), "Wizard Rituals Seller");
        addVillagerLang(ModVillagers.WIZARD_RUNE_SELLER.get(), "Wizard Runes Seller");
        addVillagerLang(ModVillagers.WIZARD_FABRIC_SELLER.get(), "Wizard Fabrics Seller");
        addVillagerLang(ModVillagers.WIZARD_SMITH_SELLER.get(), "Wizard Smiths Seller");
        addVillagerLang(ModVillagers.WIZARD_ASTRONOMER_SELLER.get(), "Wizard Astronomers Seller");
        addVillagerLang(ModVillagers.WIZARD_FARMING_SELLER.get(), "Wizard Farmings Seller");
    }

    private void addFood()
    {
        add(ModItems.STRAPHIN_MEAT.get(), "Straphin Meat");
        add(ModItems.COOKED_STRAPHIN_MEAT.get(), "Cooked Straphin Meat");
    }

    private void addToolsLang(String name, Item sword, Item shovel, Item pickaxe, Item axe, Item hoe)
    {
        add(sword, name + " Sword");
        add(shovel, name + " Shovel");
        add(pickaxe, name + " Pickaxe");
        add(axe, name + " Axe");
        add(hoe, name + " Hoe");
    }

    private void addToolTipLang(String type, String name)
    {
        add(String.format("item.%s.%s", SensMagicMod.MODID, type), name);
    }

    private void addKeyBindingCategoryLang(String category, String name)
    {
        add(category, name);
    }

    private void addKeyBindingLang(String binding, String name)
    {
        add(binding, name);
    }

    private void addEntityLang(String name, EntityType<?> entity, Item egg)
    {
        add(entity, name);
        add(egg, name + " Spawn Egg");
    }

    private void addCreativeTabLang(CreativeModeTab key, String name)
    {
        add(key.getDisplayName().getString(), name);
    }

    private void addVillagerLang(VillagerProfession profession, String name)
    {
        add(String.format("entity.minecraft.villager.%s.%s", SensMagicMod.MODID, profession.name()), name);
    }

    private void addOreLang(String name, Block ore, Block oreDeepslate, Block oreNether, Block oreEnd, Block oreBlock, Block oreRawBlock, Item ingot, Item ingotRaw, Item ingotNugget)
    {
        add(ore, name + " Ore");
        add(oreDeepslate, String.format("Deepslate %s Ore", name));
        add(oreNether, String.format("Nether %s Ore", name));
        add(oreEnd, String.format("End %s Ore", name));
        add(oreBlock, name + " Block");
        add(oreRawBlock, String.format("Raw %s Block", name));

        add(ingot, name + " Ingot");
        add(ingotRaw, name + " Raw");
        add(ingotNugget, name + " Nugget");
    }

    private void addOreLang(String name, Block ore, Block oreDeepslate, Block oreBlock, Block oreRawBlock, Item ingot, Item ingotRaw, Item ingotNugget)
    {
        add(ore, name + " Ore");
        add(oreDeepslate, String.format("Deepslate %s Ore", name));
        add(oreBlock, name + " Block");
        add(oreRawBlock, String.format("Raw %s Block", name));

        add(ingot, name + " Ingot");
        add(ingotRaw, name + " Raw");
        add(ingotNugget, name + " Nugget");
    }

    private void addOreLang(String name, Block ore, Block oreDeepslate, Block oreNether, Block oreBlock, Block oreRawBlock, Item ingot, Item ingotRaw, Item ingotNugget)
    {
        add(ore, name + " Ore");
        add(oreDeepslate, String.format("Deepslate %s Ore", name));
        add(oreNether, String.format("Nether %s Ore", name));
        add(oreBlock, name + " Block");
        add(oreRawBlock, String.format("Raw %s Block", name));

        add(ingot, name + " Ingot");
        add(ingotRaw, name + " Raw");
        add(ingotNugget, name + " Nugget");
    }

    private void addOreLang(String name, Block ore, Block oreDeepslate, Block oreNether, Block oreEnd, Block oreBlock, Item gem)
    {
        add(ore, name + " Ore");
        add(oreDeepslate, String.format("Deepslate %s Ore", name));
        add(oreNether, String.format("Nether %s Ore", name));
        add(oreEnd, String.format("End %s Ore", name));
        add(oreBlock, name + " Block");

        add(gem, name + " Gem");
    }

    private void addOreLang(String name, Block ore, Block oreDeepslate, Block oreNether, Block oreBlock, Item gem)
    {
        add(ore, name + " Ore");
        add(oreDeepslate, String.format("Deepslate %s Ore", name));
        add(oreNether, String.format("Nether %s Ore", name));
        add(oreBlock, name + " Block");

        add(gem, name + " Gem");
    }

    private void addOreLang(String name, Block ore, Block oreDeepslate, Block oreBlock, Item gem)
    {
        add(ore, name + " Ore");
        add(oreDeepslate, String.format("Deepslate %s Ore", name));
        add(oreBlock, name + " Block");

        add(gem, name + " Gem");
    }

    private void addTreeLang(String name, Block log, Block wood, Block logStripped, Block woodStripped, Block planks, Block leaves, Block sapling, Block stairs, Block slab, Block fence, Block gate, Block door, Block trapDoor)
    {
        add(log, name + " Log");
        add(wood, name + " Wood");
        add(logStripped, String.format("Stripped %s Log", name));
        add(woodStripped, String.format("Stripped Gray Leaf Wood", name));
        add(planks, name + " Planks");
        add(leaves, name + " Leaves");
        add(sapling, name + " Sapling");
        add(stairs, name + " Stairs");
        add(slab, name + " Slab");
        add(fence, name + " Fence");
        add(gate, name + " Gate");
        add(door, name + " Door");
        add(trapDoor, name + " Trap Door");
    }

    /**
     * Books
     */

    private void addModBook()
    {
        BookLangHelper helper = ModonomiconAPI.get().getLangHelper(SensMagicMod.MODID);
        helper.book("sens_magic_mod_book");
        this.add(helper.bookName(), "SensMagicMod");
        this.add(helper.bookTooltip(), "A book to showcase & test SensMagicMod features.");

        this.addModBookBasicFeaturesCategory(helper);
        this.addModBookCauldronCategory(helper);
        this.addModBookAlchemyCategory(helper);
        this.addModBookWritingCategory(helper);
        this.addModBookRitualCategory(helper);
        this.addModBookStoneCuttingCategory(helper);
        this.addModBookFabricCategory(helper);
        this.addModBookForgeCategory(helper);
        this.addModBookAstronomyCategory(helper);
        this.addModBookAgricultureCategory(helper);
    }

    /**
     * Categories
     */

    private void addModBookBasicFeaturesCategory(BookLangHelper helper)
    {
        helper.category("basic_features_category");
        this.add(helper.categoryName(), "Basic Features Category");

        this.addModBookMultiblockEntry(helper);
    }

    private void addModBookCauldronCategory(BookLangHelper helper)
    {
        helper.category("cauldron_category");
        this.add(helper.categoryName(), "Cauldron Category");
    }

    private void addModBookAlchemyCategory(BookLangHelper helper)
    {
        helper.category("alchemy_category");
        this.add(helper.categoryName(), "Alchemy Category");
    }

    private void addModBookWritingCategory(BookLangHelper helper)
    {
        helper.category("writing_category");
        this.add(helper.categoryName(), "Writing Category");
    }

    private void addModBookRitualCategory(BookLangHelper helper)
    {
        helper.category("ritual_category");
        this.add(helper.categoryName(), "Ritual Category");
    }

    private void addModBookStoneCuttingCategory(BookLangHelper helper)
    {
        helper.category("stone_cutter_category");
        this.add(helper.categoryName(), "Stone Cutter Category");
    }

    private void addModBookFabricCategory(BookLangHelper helper)
    {
        helper.category("fabric_category");
        this.add(helper.categoryName(), "Fabric Category");
    }

    private void addModBookForgeCategory(BookLangHelper helper)
    {
        helper.category("forge_category");
        this.add(helper.categoryName(), "Forge Category");
    }

    private void addModBookAstronomyCategory(BookLangHelper helper)
    {
        helper.category("astronomy_category");
        this.add(helper.categoryName(), "Astronomy Category");
    }

    private void addModBookAgricultureCategory(BookLangHelper helper)
    {
        helper.category("agriculture_category");
        this.add(helper.categoryName(), "Agriculture Category");
    }

    /**
     * Entries
     */
    private void addModBookMultiblockEntry(BookLangHelper helper)
    {
        helper.entry("multiblock");
        this.add(helper.entryName(), "Multiblock Entry");
        this.add(helper.entryDescription(), "An entry showcasing a multiblock");

        helper.page("intro");
        this.add(helper.pageTitle(), "Multiblock Page");
        this.add(helper.pageText(), "Multiblock pages allow to preview multiblocks both in the book and in the world.");

        helper.page("multiblock");
        this.add("multiblocks.modonomicon.blockentity", "Blockentity Multiblock.");
        this.add(helper.pageText(), "A sample multiblock.");
    }
}
