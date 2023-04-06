package net.sen.sensmagicmod.client.magic;

public class ClientMagicCorruptionData
{
    private static int playerMagicCorruption;

    public static void setPlayerMagicCorruption(int magicCorruption)
    {
        ClientMagicCorruptionData.playerMagicCorruption = magicCorruption;
    }

    public static int getPlayerMagicCorruption()
    {
        return playerMagicCorruption;
    }
}
