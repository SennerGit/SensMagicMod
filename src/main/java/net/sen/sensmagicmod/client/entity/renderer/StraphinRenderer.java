package net.sen.sensmagicmod.client.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.client.entity.model.StraphinModel;
import net.sen.sensmagicmod.common.entity.custom.StraphinEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class StraphinRenderer extends GeoEntityRenderer<StraphinEntity>
{
    private static final float adultSize = 2.5f;
    private static final float childSize = 1f;
    public StraphinRenderer(EntityRendererProvider.Context renderManager)
    {
        super(renderManager, new StraphinModel());
    }

    @Override
    public ResourceLocation getTextureLocation(StraphinEntity animatable)
    {
        return new ResourceLocation(SensMagicMod.MODID, "textures/entity/straphin/straphin_texture.png");
    }

    @Override
    public void render(StraphinEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight)
    {
        if (entity.isBaby())
        {
            poseStack.scale(childSize, childSize, childSize);
        }
        else
        {
            poseStack.scale(adultSize, adultSize, adultSize);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
