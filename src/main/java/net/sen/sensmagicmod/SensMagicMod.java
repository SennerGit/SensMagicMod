package net.sen.sensmagicmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sen.sensmagicmod.config.ConfigSensMagicMod;
import net.sen.sensmagicmod.networking.ModMessages;
import org.slf4j.Logger;
import net.sen.sensmagicmod.item.*;
import net.sen.sensmagicmod.block.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SensMagicMod.MODID)
public class SensMagicMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "sensmagicmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public SensMagicMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlockss.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ConfigSensMagicMod.load();
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            ModMessages.register();
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == ModCreativeModeTabs.SENS_MAGIC_TAB)
        {
            //Items
            event.accept(ModItems.CRYSTAL_ENDER_SMALL);
            event.accept(ModItems.CRYSTAL_RAW_SMALL);
            event.accept(ModItems.CRIMSON_STEEL_RAW);
            event.accept(ModItems.CRIMSON_STEEL_INGOT);
            event.accept(ModItems.CRIMSON_STEEL_NUGGET);

            //Blocks
            event.accept(ModBlockss.BLOCK_CRYSTAL_ENDER);
            event.accept(ModBlockss.CRIMSON_STEEL_ORE);
            event.accept(ModBlockss.CRIMSON_STEEL_BLOCK);
            event.accept(ModBlockss.CRIMSON_STEEL_DEEPSLATE_ORE);
            event.accept(ModBlockss.CRIMSON_STEEL_NETHER_ORE);
            event.accept(ModBlockss.CRIMSON_STEEL_END_ORE);
            event.accept(ModBlockss.RAW_CRIMSON_STEEL_BLOCK);
            event.accept(ModBlockss.GRAY_LEAF_LOG);
            event.accept(ModBlockss.GRAY_LEAF_WOOD);
            event.accept(ModBlockss.GRAY_LEAF_PLANKS);
            event.accept(ModBlockss.STRIPPED_GRAY_LEAF_LOG);
            event.accept(ModBlockss.STRIPPED_GRAY_LEAF_WOOD);
            event.accept(ModBlockss.GRAY_LEAF_LEAVES);
            event.accept(ModBlockss.GRAY_LEAF_SAPLING);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ItemProperties.register(ModItems.CRYSTAL_RAW_SMALL.get(), new ResourceLocation(SensMagicMod.MODID, ""), (stack, level, entity, i) -> {
                return ItemCrystal.getCurrentMagicCapacity() / (ItemCrystal.getMaxMagicCapacity(stack)*1.0f);
            });
        }
    }
}
