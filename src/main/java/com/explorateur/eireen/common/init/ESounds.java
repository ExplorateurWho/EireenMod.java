package com.explorateur.eireen.common.init;

import com.explorateur.eireen.EireenMod;
import com.explorateur.eireen.common.entity.EntityMutanic;
import com.explorateur.eireen.registry.EireenRegistry;
import com.explorateur.eireen.util.EntityBuilder;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;

public class ESounds {

    public static RegistryObject<SoundEvent> MUTANIC_AMBIENT = addSound("mutanic");

    public static RegistryObject<SoundEvent> addSound(String name) {
        ResourceLocation location = new ResourceLocation(EireenMod.MODID, name);
        SoundEvent soundEvent = new SoundEvent(location);
        return EireenRegistry.SOUND_REGISTRY.register(name, () -> soundEvent);
    }
}



