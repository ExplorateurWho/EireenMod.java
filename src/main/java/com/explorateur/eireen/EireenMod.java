package com.explorateur.eireen;

import com.explorateur.eireen.client.init.EntityRenderRegistry;
import com.explorateur.eireen.common.init.EEntities;
import com.explorateur.eireen.registry.EireenRegistry;
import com.explorateur.eireen.world.OreGeneration;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EireenMod.MODID)
public class EireenMod {
    public static EireenMod INSTANCE;

    public static final String MODID = "eireenmod";
    public static final Logger LOGGER = LogManager.getLogger();

    public EireenMod() {
        LOGGER.info("Init Eireen Mod!");
        INSTANCE = this;

        EireenRegistry.register();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, OreGeneration::generateOres);
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Init Complete!");
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Setup Eireen Mod!");
        GlobalEntityTypeAttributes.put(EEntities.MUTANIC.get(), ZombieEntity.createAttributes().build());
        LOGGER.info("Setup Complete!");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderRegistry.registryEntityRenders();
    }
}
