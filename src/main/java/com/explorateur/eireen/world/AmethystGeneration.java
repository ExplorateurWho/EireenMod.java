package com.explorateur.eireen.world;

import com.explorateur.eireen.common.init.EBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class AmethystGeneration {

    public static void generateOres(final BiomeLoadingEvent event) {
        if (!(event.getCategory().equals(Biome.Category.NETHER) && event.getCategory().equals(Biome.Category.THEEND))) {
            generateOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, EBlocks.AMETHYST_ORE.get().defaultBlockState(), 4, 5, 60, 4);
        }
    }

    private static void generateOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int amount) {
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.configured(
                new OreFeatureConfig(fillerType, state, veinSize))
                .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                .squared().count(amount));
    }

}
