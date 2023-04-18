package net.sen.sensmagicmod.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.sen.sensmagicmod.SensMagicMod;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigSensMagicMod
{
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static Format values = new Format();
    public static void load()
    {
        File configFile = new File(new File("config/Sens Magic Mod"), "sens_magic_mod.json");
        SensMagicMod.LOGGER.info(String.format("[SensMagicMod] : Reloading configuration file '%s'", configFile.getAbsolutePath()));

        if (configFile.exists())
        {
            try (FileReader fileReader = new FileReader(configFile))
            {
                values = GSON.fromJson(fileReader, Format.class);
            }
            catch (IOException e)
            {
                SensMagicMod.LOGGER.error("[SensMagicMod]: Error while reading configuration file!", e);
            }
        }

        try (FileWriter fileWriter = new FileWriter(configFile))
        {
            GSON.toJson(values, fileWriter);
        }
        catch (IOException e)
        {
            SensMagicMod.LOGGER.error("[SensMagicMod]: Error while reading configuration file!", e);
        }

        SensMagicMod.LOGGER.info("[SensMagicMod]: Configuration reloaded successful!");
    }

    public static Format get()
    {
        return values;
    }

    public static class Format
    {
        public String _magic_capacity = "This defines the magic crystal capacity. Default: 20_000";
        public int small_magic_capacity = 20_000;
    }
}
