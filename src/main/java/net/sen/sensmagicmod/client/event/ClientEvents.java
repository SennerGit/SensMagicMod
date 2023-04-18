package net.sen.sensmagicmod.client.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.client.world.inventory.hud.MagicCorruptionHudOverlay;
import net.sen.sensmagicmod.common.networking.ModMessages;
import net.sen.sensmagicmod.common.networking.packet.ExampleC2SPacket;
import net.sen.sensmagicmod.common.util.ModKeyBindings;

public class ClientEvents
{
    @Mod.EventBusSubscriber(modid = SensMagicMod.MODID, value = Dist.CLIENT)
    public static class ClientForgeEvents
    {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event)
        {
            if (ModKeyBindings.TEMP_KEY.consumeClick())
            {
                ModMessages.sendToServer(new ExampleC2SPacket());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = SensMagicMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents
    {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event)
        {
            event.register(ModKeyBindings.TEMP_KEY);
        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event)
        {
            event.registerAboveAll("magic_corruption", MagicCorruptionHudOverlay.HUD_MAGIC_CORRUPTION);
        }
    }
}
