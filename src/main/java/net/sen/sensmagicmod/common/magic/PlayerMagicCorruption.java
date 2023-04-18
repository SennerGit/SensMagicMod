package net.sen.sensmagicmod.common.magic;

import net.minecraft.nbt.CompoundTag;

public class PlayerMagicCorruption
{
    private int magicCorruption;
    private final int MIN_MAGIC_Corruption = 0;
    private final int MAX_MAGIC_Corruption = 10;

    public int getMagicCorruption()
    {
        return magicCorruption;
    }

    public void addMagicCorruption(int add)
    {
        this.magicCorruption = Math.min(magicCorruption + add, MAX_MAGIC_Corruption);
    }

    public void subMagicCorruption(int sub)
    {
        this.magicCorruption = Math.max(magicCorruption - sub, MIN_MAGIC_Corruption);
    }

    public void copyFrom(PlayerMagicCorruption source)
    {
        this.magicCorruption = source.magicCorruption;
    }

    public void saveNBTData(CompoundTag nbt)
    {
        nbt.putInt("magic_corruption", magicCorruption);
    }

    public void loadNBTData(CompoundTag nbt)
    {
        magicCorruption = nbt.getInt("magic_corruption");
    }
}
