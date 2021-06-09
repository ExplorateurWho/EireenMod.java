package com.explorateur.eireen.common.entity;

import com.explorateur.eireen.EireenMod;
import com.explorateur.eireen.common.init.EEntities;
import com.explorateur.eireen.common.init.ESounds;
import com.google.common.collect.Lists;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.List;

public class EntityMutanic extends ZombieEntity {

    public static List<ResourceLocation> TYPE_LIST = Lists.newArrayList(new ResourceLocation[]{
            new ResourceLocation(EireenMod.MODID, "textures/entities/mutanicv1.png"),
            new ResourceLocation(EireenMod.MODID, "textures/entities/josia_mutanic.png")
    });

    public static DataParameter<Integer> TYPE = EntityDataManager.defineId(EntityMutanic.class, DataSerializers.INT);

    public EntityMutanic(EntityType<? extends ZombieEntity> p_i48549_1_, World p_i48549_2_) {
        super(p_i48549_1_, p_i48549_2_);
    }

    public EntityMutanic(World p_i48549_2_) {
        super(EEntities.MUTANIC.get(), p_i48549_2_);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TYPE, this.level.random.nextInt(TYPE_LIST.size()));
    }

    @Override
    protected boolean isSunSensitive() {
        return false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ESounds.MUTANIC_AMBIENT.get();
    }

    public void setTYPE(int id) {
        this.entityData.set(TYPE, id);
    }


}
