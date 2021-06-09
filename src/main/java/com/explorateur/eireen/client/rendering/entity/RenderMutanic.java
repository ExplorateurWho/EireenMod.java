package com.explorateur.eireen.client.rendering.entity;

import com.explorateur.eireen.client.models.ModelMutanic;
import com.explorateur.eireen.common.entity.EntityMutanic;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderMutanic extends LivingRenderer<EntityMutanic, ModelMutanic> {

    public RenderMutanic(EntityRendererManager p_i50965_1_) {
        super(p_i50965_1_, new ModelMutanic(), 1);
    }

    @Override
    public void render(EntityMutanic p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityMutanic p_110775_1_) {
        return EntityMutanic.TYPE_LIST.get(p_110775_1_.getEntityData().get(EntityMutanic.TYPE));
    }

    @Override
    protected boolean shouldShowName(EntityMutanic p_177070_1_) {
        return false;
    }
}
