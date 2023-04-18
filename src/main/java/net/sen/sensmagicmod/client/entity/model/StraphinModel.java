package net.sen.sensmagicmod.client.entity.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.sen.sensmagicmod.SensMagicMod;
import net.sen.sensmagicmod.common.entity.custom.StraphinEntity;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animatable.model.CoreGeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.DataTicket;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class StraphinModel extends GeoModel<StraphinEntity>
{
    @Override
    public ResourceLocation getModelResource(StraphinEntity animatable)
    {
        return new ResourceLocation(SensMagicMod.MODID, "geo/straphin/straphin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StraphinEntity animatable)
    {
        return new ResourceLocation(SensMagicMod.MODID, "textures/entity/straphin/straphin_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StraphinEntity animatable)
    {
        return new ResourceLocation(SensMagicMod.MODID, "animations/straphin/straphin.animation.json");
    }

    @Override
    public void setCustomAnimations(StraphinEntity animatable, long instanceId, AnimationState<StraphinEntity> animationState)
    {
        CoreGeoBone head = getAnimationProcessor().getBone("Head");

        if (head != null)
        {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
