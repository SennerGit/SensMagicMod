package net.sen.sensmagicmod.common.magic;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerMagicCorruptionProvider implements ICapabilityProvider, INBTSerializable<CompoundTag>
{
    public static Capability<PlayerMagicCorruption> PLAYER_MAGIC_CORRUPTION = CapabilityManager.get(new CapabilityToken<PlayerMagicCorruption>() { });

    private PlayerMagicCorruption magicCorruption = null;
    private final LazyOptional<PlayerMagicCorruption> optional = LazyOptional.of(this::createPlayerMagicCorruption);

    private PlayerMagicCorruption createPlayerMagicCorruption()
    {
        if (this.magicCorruption == null)
        {
            this.magicCorruption = new PlayerMagicCorruption();
        }

        return this.magicCorruption;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side)
    {
        if (cap == PLAYER_MAGIC_CORRUPTION)
        {
            return optional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT()
    {
        CompoundTag nbt = new CompoundTag();
        createPlayerMagicCorruption().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt)
    {
        createPlayerMagicCorruption().loadNBTData(nbt);
    }
}
