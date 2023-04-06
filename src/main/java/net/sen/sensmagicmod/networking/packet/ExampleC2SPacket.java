package net.sen.sensmagicmod.networking.packet;

import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.sen.sensmagicmod.magic.PlayerMagicCorruptionProvider;
import net.sen.sensmagicmod.networking.ModMessages;

import java.util.function.Supplier;

public class ExampleC2SPacket
{
    public ExampleC2SPacket()
    {

    }

    public ExampleC2SPacket(FriendlyByteBuf buf)
    {

    }

    public void toBytes(FriendlyByteBuf buf)
    {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier)
    {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() ->
        {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            player.getCapability(PlayerMagicCorruptionProvider.PLAYER_MAGIC_CORRUPTION).ifPresent(magicCorruption -> {
                magicCorruption.addMagicCorruption(1);
                player.sendSystemMessage(Component.literal("Current Magic Corruption " + magicCorruption.getMagicCorruption()).withStyle(ChatFormatting.DARK_PURPLE));
                ModMessages.sendToPlayer(new MagicCorruptionDataSyncS2CPacket(magicCorruption.getMagicCorruption()), player);
            });
        });

        context.setPacketHandled(true);

        return true;
    }
}
