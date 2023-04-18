package net.sen.sensmagicmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sen.sensmagicmod.client.entity.renderer.StraphinRenderer;
import net.sen.sensmagicmod.common.config.ConfigSensMagicMod;
import net.sen.sensmagicmod.common.entity.ModEntities;
import net.sen.sensmagicmod.common.networking.ModMessages;
import net.sen.sensmagicmod.common.villager.ModVillagers;
import org.slf4j.Logger;
import net.sen.sensmagicmod.common.item.*;
import net.sen.sensmagicmod.common.block.*;

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
        ModEntities.register(modEventBus);

        ModVillagers.register(modEventBus);

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
            ModVillagers.registerPOIs();
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        ModCreativeModeTabs.register(event);
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.STRAPHIN.get(), StraphinRenderer::new);

            ItemProperties.register(ModItems.CRYSTAL_RAW_SMALL.get(), new ResourceLocation(SensMagicMod.MODID, ""), (stack, level, entity, i) -> {
                return ItemCrystal.getCurrentMagicCapacity() / (ItemCrystal.getMaxMagicCapacity(stack)*1.0f);
            });
        }
    }
}
