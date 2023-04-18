package net.sen.sensmagicmod.common.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.sen.sensmagicmod.client.magic.ClientMagicCorruptionData;

import java.util.function.Supplier;

public class MagicCorruptionDataSyncS2CPacket
{
    private final int magicCorruption;

    public MagicCorruptionDataSyncS2CPacket(int magicCorruption)
    {
        this.magicCorruption = magicCorruption;
    }

    public MagicCorruptionDataSyncS2CPacket(FriendlyByteBuf buf)
    {
        this.magicCorruption = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf)
    {
        buf.writeInt(magicCorruption);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier)
    {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() ->
        {
            ClientMagicCorruptionData.setPlayerMagicCorruption(magicCorruption);
        });

        context.setPacketHandled(true);

        return true;
    }
}
