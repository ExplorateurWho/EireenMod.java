package com.explorateur.eireen.client.models;

import com.explorateur.eireen.common.entity.EntityMutanic;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;

public class ModelMutanic extends EntityModel<EntityMutanic> {
    private final ModelRenderer mutanic;
    private final ModelRenderer Head;
    private final ModelRenderer RightArm;
    private final ModelRenderer LeftArm;
    private final ModelRenderer RightLeg;
    private final ModelRenderer LeftLeg;
    private final ModelRenderer Body;

    public ModelMutanic() {
        texWidth = 64;
        texHeight = 64;

        mutanic = new ModelRenderer(this);
        mutanic.setPos(0.0F, 24.0F, 0.0F);


        Head = new ModelRenderer(this);
        Head.setPos(0.0F, -28.0F, 0.0F);
        mutanic.addChild(Head);
        Head.texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        Head.texOffs(32, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

        RightArm = new ModelRenderer(this);
        RightArm.setPos(-6.0F, -22.0F, 0.0F);
        mutanic.addChild(RightArm);
        setRotationAngle(RightArm, -1.5708F, 0.0F, 0.0F);
        RightArm.texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        RightArm.texOffs(40, 32).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        LeftArm = new ModelRenderer(this);
        LeftArm.setPos(6.0F, -22.0F, 0.0F);
        mutanic.addChild(LeftArm);
        LeftArm.texOffs(32, 48).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        LeftArm.texOffs(40, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        RightLeg = new ModelRenderer(this);
        RightLeg.setPos(-1.9F, -12.0F, 0.0F);
        mutanic.addChild(RightLeg);
        RightLeg.texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        RightLeg.texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);

        LeftLeg = new ModelRenderer(this);
        LeftLeg.setPos(1.9F, -12.0F, 0.0F);
        mutanic.addChild(LeftLeg);
        LeftLeg.texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
        LeftLeg.texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0F, false);

        Body = new ModelRenderer(this);
        Body.setPos(0.0F, -24.0F, 0.0F);
        mutanic.addChild(Body);
        Body.texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
        Body.texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.25F, false);
    }

    @Override
    public void setupAnim(EntityMutanic p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        float f = MathHelper.sin(this.attackTime * (float) Math.PI);
        float f1 = MathHelper.sin((1.0F - (1.0F - this.attackTime) * (1.0F - this.attackTime)) * (float) Math.PI);
        this.RightArm.zRot = 0.0F;
        this.LeftArm.zRot = 0.0F;
        this.RightArm.yRot = -(0.1F - f * 0.6F);
        this.LeftArm.yRot = 0.1F - f * 0.6F;
        this.RightArm.xRot = -(float) Math.toRadians(90f);
        this.LeftArm.xRot = 0;
        this.RightArm.xRot += f * 1.2F - f1 * 0.4F;
        this.LeftArm.xRot += f * 1.2F - f1 * 0.4F;
        ModelHelper.bobArms(this.RightArm, this.LeftArm, p_225597_4_);

        boolean flag = p_225597_1_.getFallFlyingTicks() > 4;
        this.Head.yRot = p_225597_5_ * ((float) Math.PI / 180F);
        if (flag) {
            this.Head.xRot = (-(float) Math.PI / 4F);
        }

        this.Body.yRot = 0.0F;
       float fa = 1.0F;
        if (flag) {
            fa = (float) p_225597_1_.getDeltaMovement().lengthSqr();
            fa = fa / 0.2F;
            fa = fa * fa * fa;
        }

        if (fa < 1.0F) {
            fa = 1.0F;
        }


        this.RightArm.zRot = 0.0F;
        this.LeftArm.zRot = 0.0F;
        this.RightLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F) * 1.4F * p_225597_3_ / fa;
        this.LeftLeg.xRot = MathHelper.cos(p_225597_2_ * 0.6662F + (float) Math.PI) * 1.4F * p_225597_3_ / fa;
        this.RightLeg.yRot = 0.0F;
        this.LeftLeg.yRot = 0.0F;
        this.RightLeg.zRot = 0.0F;
        this.LeftLeg.zRot = 0.0F;
        if (this.riding) {
            this.RightArm.xRot += (-(float) Math.PI / 5F);
            this.LeftArm.xRot += (-(float) Math.PI / 5F);
            this.RightLeg.xRot = -1.4137167F;
            this.RightLeg.yRot = ((float) Math.PI / 10F);
            this.RightLeg.zRot = 0.07853982F;
            this.LeftLeg.xRot = -1.4137167F;
            this.LeftLeg.yRot = (-(float) Math.PI / 10F);
            this.LeftLeg.zRot = -0.07853982F;
        }

        this.RightArm.yRot = 0.0F;
        this.LeftArm.yRot = 0.0F;
        this.Body.xRot = 0.0F;
    }

    protected float rotlerpRad(float p_205060_1_, float p_205060_2_, float p_205060_3_) {
        float f = (p_205060_3_ - p_205060_2_) % ((float) Math.PI * 2F);
        if (f < -(float) Math.PI) {
            f += ((float) Math.PI * 2F);
        }

        if (f >= (float) Math.PI) {
            f -= ((float) Math.PI * 2F);
        }

        return p_205060_2_ + p_205060_1_ * f;
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    @Override
    public void renderToBuffer(MatrixStack p_225598_1_, IVertexBuilder p_225598_2_, int p_225598_3_, int p_225598_4_, float p_225598_5_, float p_225598_6_, float p_225598_7_, float p_225598_8_) {
        mutanic.render(p_225598_1_, p_225598_2_, p_225598_3_, p_225598_4_);
    }
}