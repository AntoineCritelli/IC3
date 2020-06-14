package com.norbana.industrialcraft3.tileentity;

import com.norbana.industrialcraft3.util.NBTHelper;
import com.norbana.industrialcraft3.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;

public class QuarryTileEntity extends TileEntity implements ITickableTileEntity {

    public int x, y, z, tick, offsetX, offsetY, offsetZ, maxX, maxZ;
    public boolean initialized = false;

    public QuarryTileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public QuarryTileEntity() {
        this(RegistryHandler.QUARRY_TILE_ENTITY.get());
    }

    @Override
    public void tick() {
        if (!this.initialized) init();
        if (++this.tick > 40) {
            this.tick = 0;
            if (this.y>2)
                execute();
        }
    }

    private void execute() {
        /*
        Block blockRemoved;
        for (int x=0; x<3; x++)
            for (int z=0; z<3; z++){
                BlockPos posToBreak = new BlockPos(this.x + x, this.y, this.z + z);
                blockRemoved = this.world.getBlockState(posToBreak).getBlock();
                destroyBlock(posToBreak, true, null);
            }
        this.y--;

         */

        // TODO changer pour placer dans un coin au lieu d'au milieu
        BlockPos posToBreak = new BlockPos(this.x + offsetX, this.y + offsetY, this.z + offsetZ);
        destroyBlock(posToBreak, false, null);

        if (++this.offsetX > maxX){
            this.offsetX = -maxX;
            if (++this.offsetZ > maxZ){
                this.offsetZ = -maxZ;
                this.offsetY--;
            }
        }
    }

    private boolean destroyBlock(BlockPos pos, boolean dropBlock, @Nullable Entity entity) {
        BlockState state = world.getBlockState(pos);
        if (state.isAir(world, pos)) return false;
        IFluidState iFluidState = world.getFluidState(pos);
        world.playEvent(2001, pos, Block.getStateId(state));
        if (dropBlock){
            TileEntity tileEntity = state.hasTileEntity() ? world.getTileEntity(pos) : null;
            Block.spawnDrops(state, world, this.pos.add(0, 1.5f, 0), tileEntity, entity, ItemStack.EMPTY);
        }
        return world.setBlockState(pos, iFluidState.getBlockState(), 3);
    }

    private void init() {
        initialized = true;
        this.x = this.pos.getX();
        this.y = this.pos.getY();
        this.z = this.pos.getZ();
        this.maxX = 2;
        this.maxZ = 2; // TODO changer pour delimiter avec des torches
        this.offsetX = -this.maxX;
        this.offsetY = -1;
        this.offsetZ = -this.maxZ;
        this.tick = 0;
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("initvalues", NBTHelper.toNBT(this));
        return super.write(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        CompoundNBT initValues = compound.getCompound("initvalues");
        if (initValues != null){
            this.x = initValues.getInt("x");
            this.y = initValues.getInt("y");
            this.z = initValues.getInt("z");
            this.offsetX = initValues.getInt("offsetX");
            this.offsetY = initValues.getInt("offsetY");
            this.offsetZ = initValues.getInt("offsetZ");
            this.maxX = 2;
            this.maxZ = 2; // TODO changer pour delimiter avec des torches
            this.tick = 0;
            this.initialized = true;
            return;
        }
        init();
    }
}
