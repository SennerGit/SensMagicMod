package net.sen.sensmagicmod.common.datagen.modonomicon;

import com.klikli_dev.modonomicon.api.ModonomiconAPI;
import com.klikli_dev.modonomicon.api.datagen.BookLangHelper;
import com.klikli_dev.modonomicon.api.datagen.BookProvider;
import com.klikli_dev.modonomicon.api.datagen.EntryLocationHelper;
import com.klikli_dev.modonomicon.api.datagen.book.BookCategoryModel;
import com.klikli_dev.modonomicon.api.datagen.book.BookEntryModel;
import com.klikli_dev.modonomicon.api.datagen.book.BookModel;
import com.klikli_dev.modonomicon.api.datagen.book.condition.BookEntryReadConditionModel;
import com.klikli_dev.modonomicon.api.datagen.book.page.BookMultiblockPageModel;
import com.klikli_dev.modonomicon.api.datagen.book.page.BookTextPageModel;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.LanguageProvider;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.block.ModBlockss;
import net.sen.sensmagicmod.common.item.ModCreativeModeTabs;
import net.sen.sensmagicmod.common.item.ModItems;
import net.sen.sensmagicmod.common.datagen.modonomicon.categories.*;

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

    private BookModel makeModBookModel(String name)
    {
        var helper = ModonomiconAPI.get().getLangHelper(SensMagicMod.MODID);
        helper.book(name);

        int sortNum = 1;
        var bookBasicFeaturesCategoryModel = new MakeBasicFeaturesCategoryProvider().makeBasicFeaturesCategory(helper).withSortNumber(sortNum++);
        var bookCauldronCategoryModel = new MakeCauldronCategoryProvider().makeCauldronCategory(helper).withSortNumber(sortNum++);
        var bookAlchemyCategoryModel = new MakeAlchemyCategoryProvider().makeAlchemyCategory(helper).withSortNumber(sortNum++);
        var bookWritingCategoryModel = new MakeWritingCategoryProvider().makeWritingCategory(helper).withSortNumber(sortNum++);
        var bookRitualCategoryModel = new MakeRitualCategoryProvider().makeRitualCategory(helper).withSortNumber(sortNum++);
        var bookStoneCuttingCategoryModel = new MakeStoneCuttingCategoryProvider().makeStoneCuttingCategory(helper).withSortNumber(sortNum++);
        var bookFabricCategoryModel = new MakeFabricCategoryProvider().makeFabricCategory(helper).withSortNumber(sortNum++);
        var bookForgeCategoryModel = new MakeForgeCategoryProvider().makeForgeCategory(helper).withSortNumber(sortNum++);
        var bookAstronomyCategoryModel = new MakeAstronomyCategoryProvider().makeAstronomyCategory(helper).withSortNumber(sortNum++);
        var bookAgricultureCategoryModel = new MakeAgricultureCategoryProvider().makeAgricultureCategory(helper).withSortNumber(sortNum++);

        BookModel bookModel = BookModel.create(this.modLoc(name), helper.bookName())
                .withModel(this.modLoc(name+ "_icon"))
                .withTooltip(helper.bookTooltip())
                .withGenerateBookItem(false)
                .withCustomBookItem(this.modLoc(name))
                .withCategories(
                        bookBasicFeaturesCategoryModel,
                        bookCauldronCategoryModel,
                        bookAlchemyCategoryModel,
                        bookWritingCategoryModel,
                        bookRitualCategoryModel,
                        bookStoneCuttingCategoryModel,
                        bookFabricCategoryModel,
                        bookForgeCategoryModel,
                        bookAstronomyCategoryModel,
                        bookAgricultureCategoryModel
                );

        return bookModel;
    }
}