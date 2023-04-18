package net.sen.sensmagicmod.common.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.datagen.loottables.ModLootTableProvider;
import net.sen.sensmagicmod.common.datagen.modonomicon.ModModonomiconBookProvider;
import net.sen.sensmagicmod.common.datagen.language.EnUsProvider;
import net.sen.sensmagicmod.common.datagen.tags.ModBlockTagsProvider;
import net.sen.sensmagicmod.common.datagen.tags.ModPoiTypeTagsProvider;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = SensMagicMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators
{
    @SubscribeEvent
    public static void GatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        LanguageProvider languageProvider = new EnUsProvider(packOutput);

        ForgeBlockTagsProvider blockTags = new ForgeBlockTagsProvider(packOutput, lookupProvider, existingFileHelper);

        generator.addProvider(true, new ModRecipeProvider(packOutput));
        generator.addProvider(true, ModLootTableProvider.create(packOutput));
        generator.addProvider(true, new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModPoiTypeTagsProvider(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(true, new ModBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
        //generator.addProvider(true, new ModItemTagsProvider(packOutput, lookupProvider, blockTags.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModModonomiconBookProvider(packOutput, languageProvider));
        generator.addProvider(event.includeClient(), languageProvider);
    }
}
