package net.sen.sensmagicmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sen.sensmagicmod.SensMagicMod;

@Mod.EventBusSubscriber(modid = SensMagicMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs
{
    public static CreativeModeTab SENS_MAGIC_TAB;

    @SubscribeEvent
    public static void  registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        SENS_MAGIC_TAB = event.registerCreativeModeTab(new ResourceLocation(SensMagicMod.MODID, "sens_magic_tab"), builder -> builder
                .icon(() -> new ItemStack(ModItems.CRYSTAL_RAW_SMALL.get()))
                .title(Component.translatable("creativemodetab.sens_magic_tab"))
        );
    }
}
