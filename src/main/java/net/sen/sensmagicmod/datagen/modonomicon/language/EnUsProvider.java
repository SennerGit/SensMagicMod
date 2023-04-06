package net.sen.sensmagicmod.datagen.modonomicon.language;

import com.klikli_dev.modonomicon.api.ModonomiconAPI;
import com.klikli_dev.modonomicon.api.datagen.BookLangHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.block.ModBlockss;
import net.sen.sensmagicmod.item.ModCreativeModeTabs;
import net.sen.sensmagicmod.item.ModItems;

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
        this.addItem();
        this.addCreativeTab();
        this.addToolTip();
        this.addGuiElement();
        this.addKeyBinding();
    }

    private void addModBook()
    {
        BookLangHelper helper = ModonomiconAPI.get().getLangHelper(SensMagicMod.MODID);
        helper.book("sens_magic_mod_book");
        this.add(helper.bookName(), "SensMagicMod");
        this.add(helper.bookTooltip(), "A book to showcase & test SensMagicMod features.");

        this.addModBookFeaturesCategory(helper);
    }

    private void addModBookFeaturesCategory(BookLangHelper helper)
    {
        helper.category("features");
        this.add(helper.categoryName(), "Features Category");

        this.addModBookMultiblockEntry(helper);
    }

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

    private void addBlock()
    {
        this.add(ModBlockss.BLOCK_CRYSTAL_ENDER.get(), "Ender Crytsal Block");
        this.add(ModBlockss.CRIMSON_STEEL_ORE.get(), "Crimson Steel Ore");
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
        this.add(ModBlockss.GRAY_LEAF_SAPLING.get(), "Gray Leaf Sapling");

    }

    private void addItem()
    {
        this.add(ModItems.CRYSTAL_ENDER_SMALL.get(), "Small Ender Magic Crystal");
        this.add(ModItems.CRYSTAL_RAW_SMALL.get(), "Small Raw Magic Crystal");
        this.add(ModItems.CRIMSON_STEEL_RAW.get(), "Crimson Steel Raw");
        this.add(ModItems.CRIMSON_STEEL_INGOT.get(), "Crimson Steel Ingot");
        this.add(ModItems.CRIMSON_STEEL_NUGGET.get(), "Crimson Steel Nugget");
    }

    private void addCreativeTab()
    {
        add("creativemodetab.sens_magic_tab", "Sen's Magic Tab");
    }

    private void addToolTip()
    {
        add("item.sensmagicmod.crystal.magic.element", "Element: %d");
        add("item.sensmagicmod.crystal.magic.capacity", "Current Magic Capacity: %dME/%dME");
        add("item.sensmagicmod.crystal.guide", "Press SHIFT for more info");
    }

    private void addGuiElement()
    {

    }

    private void addKeyBinding()
    {
        add("key.category.sensmagicmod.sens_magic_mod", "Sens Magic Mod");
        add("key.sensmagicmod.temp", "Temp Key Binding");
    }
}
