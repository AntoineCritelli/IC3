package com.norbana.industrialcraft3.world.feature;

import com.norbana.industrialcraft3.util.RegistryHandler;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class RubberTree extends Tree {

    public static final TreeFeatureConfig RUBBER_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegistryHandler.RUBBER_LOG_BLOCK.get().getDefaultState()),
            new SimpleBlockStateProvider(RegistryHandler.RUBBER_LEAVES_BLOCK.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0)))
            .baseHeight(4)
            .heightRandA(2)
            .foliageHeight(3)
            .ignoreVines()
            .setSapling((IPlantable) RegistryHandler.RUBBER_SAPLING_BLOCK.get())
            .build();

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.withConfiguration(RUBBER_TREE_CONFIG);
    }
}
