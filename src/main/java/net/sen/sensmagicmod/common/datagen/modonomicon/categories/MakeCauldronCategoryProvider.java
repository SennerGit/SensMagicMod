package net.sen.sensmagicmod.common.datagen.modonomicon.categories;

import com.klikli_dev.modonomicon.api.ModonomiconAPI;
import com.klikli_dev.modonomicon.api.datagen.BookLangHelper;
import com.klikli_dev.modonomicon.api.datagen.book.BookCategoryModel;
import net.minecraft.resources.ResourceLocation;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.block.ModBlockss;

public class MakeCauldronCategoryProvider
{
    public BookCategoryModel makeCauldronCategory(BookLangHelper helper) {
        helper.category("cauldron_category"); //tell our lang helper the category we are in

        //the entry helper is the second helper for book datagen
        //it allows us to place entries in the category without manually defining the coordinates.
        //each letter can be used to represent an entry
        var entryHelper = ModonomiconAPI.get().getEntryLocationHelper();
        entryHelper.setMap(
                "_____________________",
                "_____________________",
                "_____________________",
                "_____________________",
                "_____________________",
                "_____________________"
        );

        return BookCategoryModel.create(
                        new ResourceLocation(SensMagicMod.MODID, helper.category), helper.categoryName())
                .withIcon(ModBlockss.WIZARD_CAULDRON.getId().toString());
    }
}
