package net.sen.sensmagicmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding
{
    public static final String KEY_CATEGORY_SENS_MAGIC_MOD = "key.category.sensmagicmod.sens_magic_mod";
    public static final String KEY_TEMP = "key.sensmagicmod.temp";

    public static final KeyMapping TEMP_KEY = new KeyMapping(KEY_TEMP, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O, KEY_CATEGORY_SENS_MAGIC_MOD);
}
