package net.sen.sensmagicmod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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
    private static final Logger LOGGER = LogUtils.getLogger();

    public SensMagicMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.Register(modEventBus);
        ModBlocks.Register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == ModCreativeModeTabs.SENS_MAGIC_TAB)
        {
            //Items
            event.accept(ModItems.CRYSTAL_ENDER);
            event.accept(ModItems.CRYSTAL_RAW);
            event.accept(ModItems.CRIMSON_STEEL_RAW);
            event.accept(ModItems.CRIMSON_STEEL_INGOT);
            event.accept(ModItems.CRIMSON_STEEL_NUGGET);

            //Blocks
            event.accept(ModBlocks.BLOCK_CRYSTAL_ENDER);
            event.accept(ModBlocks.CRIMSON_STEEL_ORE);
            event.accept(ModBlocks.CRIMSON_STEEL_BLOCK);
            event.accept(ModBlocks.CRIMSON_STEEL_DEEPSLATE_ORE);
            event.accept(ModBlocks.RAW_CRIMSON_STEEL_BLOCK);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
