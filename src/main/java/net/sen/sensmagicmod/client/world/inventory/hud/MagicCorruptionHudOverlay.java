package net.sen.sensmagicmod.client.world.inventory.hud;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.client.magic.ClientMagicCorruptionData;

public class MagicCorruptionHudOverlay
{
    private static final String hudLocation = "textures/gui/magic/";
    private static final ResourceLocation FILLED_MAGIC_CORRUPTION = new ResourceLocation(SensMagicMod.MODID, hudLocation + "filled_magic_corruption.png");
    private static final ResourceLocation EMPTY_MAGIC_CORRUPTION = new ResourceLocation(SensMagicMod.MODID, hudLocation + "empty_magic_corruption.png");

    public static  final IGuiOverlay HUD_MAGIC_CORRUPTION = ((gui, poseStack, partialTick, screenWidth, screenHeight) -> {
       int x = screenWidth / 2;
       int y = screenHeight;

        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, EMPTY_MAGIC_CORRUPTION);

        for (int i = 0; i < 10; i++)
        {
            GuiComponent.blit(poseStack, x - 94 + (i*9), y - 54, 0, 0, 12, 12, 12, 12);
        }

        RenderSystem.setShaderTexture(0, FILLED_MAGIC_CORRUPTION);

        for (int i = 0; i < 10; i++)
        {
            if (ClientMagicCorruptionData.getPlayerMagicCorruption() > i)
            {
                GuiComponent.blit(poseStack, x - 94 + (i*9), y - 54, 0, 0, 12, 12, 12, 12);
            }
            else
            {
                break;
            }
        }
    });
}
