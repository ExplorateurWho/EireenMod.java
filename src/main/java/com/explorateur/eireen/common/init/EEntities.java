package com.explorateur.eireen.common.init;

import com.explorateur.eireen.EireenMod;
import com.explorateur.eireen.common.entity.EntityMutanic;
import com.explorateur.eireen.util.EntityBuilder;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class EEntities {

    public static RegistryObject<EntityType<EntityMutanic>> MUTANIC = create("mutanic").<EntityMutanic>entity(EntityMutanic::new, EntityClassification.MONSTER).size(0.6F, 1.95F).build();

    public static EntityBuilder create(String name) {
        EntityBuilder builder = EntityBuilder.create();
        builder.setName(name);
        builder.setId(new ResourceLocation(EireenMod.MODID, name));
        return builder;
    }
}



