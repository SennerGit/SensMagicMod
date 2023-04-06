package net.sen.sensmagicmod.datagen.modonomicon;

import com.klikli_dev.modonomicon.api.ModonomiconAPI;
import com.klikli_dev.modonomicon.api.datagen.BookLangHelper;
import com.klikli_dev.modonomicon.api.datagen.BookProvider;
import com.klikli_dev.modonomicon.api.datagen.EntryLocationHelper;
import com.klikli_dev.modonomicon.api.datagen.book.BookCategoryModel;
import com.klikli_dev.modonomicon.api.datagen.book.BookEntryModel;
import com.klikli_dev.modonomicon.api.datagen.book.BookModel;
import com.klikli_dev.modonomicon.api.datagen.book.page.BookMultiblockPageModel;
import com.klikli_dev.modonomicon.api.datagen.book.page.BookTextPageModel;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.LanguageProvider;
import net.sen.sensmagicmod.SensMagicMod;

public class ModModonomiconBookProvider extends BookProvider
{
    public ModModonomiconBookProvider(PackOutput packOutput, LanguageProvider lang)
    {
        super(packOutput, SensMagicMod.MODID, lang);
    }

    @Override
    protected void generate()
    {
        BookModel bookModel = this.makeModBookModel("sens_magic_mod_book");

        this.add(bookModel);
    }

    private BookModel makeModBookModel(String bookName)
    {
        BookLangHelper helper = ModonomiconAPI.get().getLangHelper(SensMagicMod.MODID);

        helper.book(bookName);

        BookCategoryModel bookCategoryModel = this.makeFeaturesCategory(helper);

        BookModel bookModel = BookModel.create(
                this.modLoc(bookName),
                helper.bookName()
        )
                .withTooltip(helper.bookTooltip())
                .withGenerateBookItem(true)
                .withModel(new ResourceLocation("modonomicon:modonomicon_red"))
                .withCreativeTab(new ResourceLocation("modonomicon", "modonomicon"))
                .withCategories(bookCategoryModel);

        return bookModel;
    }

    private BookCategoryModel makeFeaturesCategory(BookLangHelper helper) {
        helper.category("features"); //tell our lang helper the category we are in

        //the entry helper is the second helper for book datagen
        //it allows us to place entries in the category without manually defining the coordinates.
        //each letter can be used to represent an entry
        var entryHelper = ModonomiconAPI.get().getEntryLocationHelper();
        entryHelper.setMap(
                "_____________________",
                "__m______________d___",
                "__________r__________",
                "__c__________________",
                "__________2___3___i__",
                "__s_____e____________"
        );

        //place the multiblock entry where we put the "m" in the map above
        var multiblockEntry = this.makeMultiblockEntry(helper, entryHelper, 'm');

        return BookCategoryModel.create(
                        this.modLoc(helper.category), //the id of the category, as stored in the lang helper. modLoc() prepends the mod id.
                        helper.categoryName() //the name of the category. The lang helper gives us the correct translation key.
                )
                .withIcon("minecraft:nether_star") //the icon for the category. In this case we simply use an existing item.
                .withEntries(multiblockEntry);
    }

    private BookEntryModel makeMultiblockEntry(BookLangHelper helper, EntryLocationHelper entryHelper, char location) {
        helper.entry("multiblock"); //tell our lang helper the entry we are in

        helper.page("intro"); //and now the page
        var multiBlockIntroPage =
                BookTextPageModel.builder() //we start with a text page
                        .withText(helper.pageText()) //lang key for the text
                        .withTitle(helper.pageTitle()) //and for the title
                        .build();

        helper.page("multiblock"); //next page
        var multiblockPreviewPage =
                BookMultiblockPageModel.builder() //now a page to show a multiblock
                        .withMultiblockId("modonomicon:blockentity") //sample multiblock from modonomicon
                        .withMultiblockName("multiblocks.modonomicon.blockentity") //and the lang key for its name
                        .withText(helper.pageText()) //plus a page text
                        .build();

        return BookEntryModel.builder()
                .withId(this.modLoc(helper.category + "/" + helper.entry)) //make entry id from lang helper data
                .withName(helper.entryName()) //entry name lang key
                .withDescription(helper.entryDescription()) //entry description lang key
                .withIcon("minecraft:furnace") //we use furnace as icon
                .withLocation(entryHelper.get(location)) //and we place it at the location we defined earlier in the entry helper mapping
                .withPages(multiBlockIntroPage, multiblockPreviewPage) //finally we add our pages to the entry
                .build();
    }
}
