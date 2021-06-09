package com.explorateur.eireen.registry;

import com.explorateur.eireen.EireenMod;
import com.explorateur.eireen.common.init.EBlocks;
import com.explorateur.eireen.common.init.EEntities;
import com.explorateur.eireen.common.init.EItems;
import com.explorateur.eireen.common.init.ESounds;
import com.explorateur.eireen.common.items.EItemTier;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EireenRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EireenMod.MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EireenMod.MODID);
    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(ForgeRegistries.ENTITIES, EireenMod.MODID);
    public static final DeferredRegister<SoundEvent>  SOUND_REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EireenMod.MODID);

    public static boolean initialized = false;

    public static EBlocks EBLOCKS;
    public static EItems EITEMS;
    public static EEntities EEntity;
    public static ESounds ESounds;

    public static void register() {

        // Can't call twice
        if(!initialized) {

            final IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

            // Load
            EBLOCKS = new EBlocks();
            EITEMS = new EItems();
            EEntity = new EEntities();
            ESounds = new ESounds();

            // Register
            BLOCKS.register(bus);
            ITEMS.register(bus);
            ENTITY.register(bus);
            SOUND_REGISTRY.register(bus);

            // Init
            initialized = true;
        }

    }
}
