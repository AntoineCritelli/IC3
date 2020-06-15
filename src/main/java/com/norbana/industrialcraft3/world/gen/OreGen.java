package com.norbana.industrialcraft3.world.gen;

import com.norbana.industrialcraft3.util.RegistryHandler;
import net.minecraft.item.BlockItem;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
    public static void generateOre() {
        for(Biome biome : ForgeRegistries.BIOMES){

            // Tin and Copper generation
            ConfiguredPlacement customeConfiguration = Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 63));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                            RegistryHandler.TIN_ORE_BLOCK.get().getDefaultState(), 10))
                                    .withPlacement(customeConfiguration));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                            RegistryHandler.COPPER_ORE_BLOCK.get().getDefaultState(), 10))
                                    .withPlacement(customeConfiguration));

            // Uranium generation
            ConfiguredPlacement uraniumConfiguration = Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 20));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                            RegistryHandler.URANIUM_ORE_BLOCK.get().getDefaultState(), 2))
                                    .withPlacement(uraniumConfiguration));

        }
    }
}
