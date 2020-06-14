package com.norbana.industrialcraft3.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class RubberLogBlock extends RotatedPillarBlock {
    private final MaterialColor verticalColor;

    public RubberLogBlock() {
        super(Block.Properties.from(Blocks.OAK_LOG));
        this.verticalColor = MaterialColor.WOOD;
    }

    public MaterialColor getMaterialColor(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.get(AXIS) == Direction.Axis.Y ? this.verticalColor : this.materialColor;
    }
}
