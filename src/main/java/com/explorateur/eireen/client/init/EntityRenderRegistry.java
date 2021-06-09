package com.explorateur.eireen.client.init;

import com.explorateur.eireen.EireenMod;
import com.explorateur.eireen.client.models.ModelMutanic;
import com.explorateur.eireen.client.rendering.entity.RenderMutanic;
import com.explorateur.eireen.common.entity.EntityMutanic;
import com.explorateur.eireen.common.init.EEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class EntityRenderRegistry {

    public static void registryEntityRenders() {
        EireenMod.LOGGER.info("Registering Entity Renders");

       registerRender(EEntities.MUTANIC.get(), RenderMutanic::new);
    }


    public static <T extends Entity> void registerRender(EntityType<T> entityClass, IRenderFactory<? super T> renderFactory) {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
    }
}
