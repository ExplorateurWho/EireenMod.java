package com.explorateur.eireen.common.itemgroup;

import com.explorateur.eireen.EireenMod;
import com.explorateur.eireen.common.init.*;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.item.*;

public class EireenModItemGroups {

    public static final ItemGroup BLOCKS = new ItemGroup(EireenMod.MODID + ".blocks") {
            @Override
            @MethodsReturnNonnullByDefault
            public ItemStack makeIcon() { return new ItemStack(EBlocks.ELECTRIC_ORE.get()); }
    };

    public static final ItemGroup TOOLS = new ItemGroup(EireenMod.MODID + ".tools") {
        @Override
        @MethodsReturnNonnullByDefault
        public ItemStack makeIcon() {
            return new ItemStack(EItems.ELECTRIC_PICKAXE.get());
        }
    };

    public static final ItemGroup COMBAT = new ItemGroup(EireenMod.MODID + ".combat") {
        @Override
        @MethodsReturnNonnullByDefault
        public ItemStack makeIcon() {
            return new ItemStack(EItems.ELECTRIC_SWORD.get());
        }
    };

    public static final ItemGroup MISC = new ItemGroup(EireenMod.MODID + ".misc") {
        @Override
        @MethodsReturnNonnullByDefault
        public ItemStack makeIcon() {
            return new ItemStack(EItems.ELECTRIC.get());
        }
    };

}
