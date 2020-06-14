package com.norbana.industrialcraft3.world.gen;

import com.norbana.industrialcraft3.world.feature.RubberTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class TreeGen {
    public static void generateTree() {
        for(Biome biome : ForgeRegistries.BIOMES){

           if (biome == Biomes.FLOWER_FOREST
                    || biome == Biomes.FOREST
                    || biome == Biomes.SWAMP){
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                        Feature.NORMAL_TREE.withConfiguration(RubberTree.RUBBER_TREE_CONFIG)
                                .withPlacement(Placement
                                        .COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1f, 1))));
            }

        }
    }
}
