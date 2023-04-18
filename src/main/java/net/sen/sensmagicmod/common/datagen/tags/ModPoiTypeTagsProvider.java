package net.sen.sensmagicmod.common.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.tags.PoiTypeTags;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.villager.ModVillagers;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypeTagsProvider extends PoiTypeTagsProvider
{
    public ModPoiTypeTagsProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @org.jetbrains.annotations.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper)
    {
        super(pOutput, pProvider, SensMagicMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider)
    {
        super.addTags(pProvider);

        this.tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).add(
                ModVillagers.WIZARD_CAULDRON_BLOCK_POI.getKey(),
                ModVillagers.WIZARD_ALCHEMY_STATION_BLOCK_POI.getKey(),
                ModVillagers.WIZARD_WRITING_STATION_BLOCK_POI.getKey(),
                ModVillagers.WIZARD_RITUAL_STONE_BLOCK_POI.getKey(),
                ModVillagers.WIZARD_STONE_CUTTER_BLOCK_POI.getKey(),
                ModVillagers.WIZARD_FABRIC_STATION_BLOCK_POI.getKey(),
                ModVillagers.WIZARD_FORGE_BLOCK_POI.getKey(),
                ModVillagers.WIZARD_ASTRONOMY_STATION_BLOCK_POI.getKey(),
                ModVillagers.WIZARD_AGRICULTURE_STATION_BLOCK_POI.getKey()
        );
    }
}
