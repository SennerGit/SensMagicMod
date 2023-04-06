package net.sen.sensmagicmod.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.networking.packet.ExampleC2SPacket;
import net.sen.sensmagicmod.networking.packet.MagicCorruptionDataSyncS2CPacket;

public class ModMessages
{
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id()
    {
        return packetId++;
    }

    public static void register()
    {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(SensMagicMod.MODID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(ExampleC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(ExampleC2SPacket::new)
                .encoder(ExampleC2SPacket::toBytes)
                .consumerMainThread(ExampleC2SPacket::handle)
                .add();

        net.messageBuilder(MagicCorruptionDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(MagicCorruptionDataSyncS2CPacket::new)
                .encoder(MagicCorruptionDataSyncS2CPacket::toBytes)
                .consumerMainThread(MagicCorruptionDataSyncS2CPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message)
    {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player)
    {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
