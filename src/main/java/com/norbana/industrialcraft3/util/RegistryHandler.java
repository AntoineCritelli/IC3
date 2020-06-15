package com.norbana.industrialcraft3.util;

import com.norbana.industrialcraft3.IndustrialCraft3;
import com.norbana.industrialcraft3.blocks.*;
import com.norbana.industrialcraft3.items.UraniumIngot;
import com.norbana.industrialcraft3.tileentity.QuarryTileEntity;
import com.norbana.industrialcraft3.world.feature.RubberTree;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, IndustrialCraft3.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, IndustrialCraft3.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, IndustrialCraft3.MOD_ID);

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // ITEMS
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new Item(new Item.Properties().group(IndustrialCraft3.TAB)));
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(new Item.Properties().group(IndustrialCraft3.TAB)));
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", UraniumIngot::new);

    // BLOCKS
    public static final RegistryObject<Block> TIN_BLOCK = BLOCKS.register("tin_block", () -> new Block(Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block", () -> new Block(Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> TIN_ORE_BLOCK = BLOCKS.register("tin_ore_block", () -> new Block(Block.Properties.from(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> COPPER_ORE_BLOCK = BLOCKS.register("copper_ore_block", () -> new Block(Block.Properties.from(Blocks.IRON_ORE)));
    public static final RegistryObject<Block> RUBBER_LOG_BLOCK = BLOCKS.register("rubber_log_block", RubberLogBlock::new);
    public static final RegistryObject<Block> RUBBER_LEAVES_BLOCK = BLOCKS.register("rubber_leaves_block", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> RUBBER_SAPLING_BLOCK = BLOCKS.register("rubber_sapling_block", () -> new RubberSaplingBlock(RubberTree::new, Block.Properties.from(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> QUARRY_BLOCK = BLOCKS.register("quarry_block", QuarryBlock::new);
    public static final RegistryObject<Block> URANIUM_ORE_BLOCK = BLOCKS.register("uranium_ore_block", () -> new Block(Block.Properties.from(Blocks.IRON_ORE)));


    // BLOCK ITEMS
    public static final RegistryObject<Item> TIN_BLOCK_ITEM = ITEMS.register("tin_block", () -> new BlockItem(TIN_BLOCK.get(), new Item.Properties().group(IndustrialCraft3.TAB)));
    public static final RegistryObject<Item> COPPER_BLOCK_ITEM = ITEMS.register("copper_block", () -> new BlockItem(COPPER_BLOCK.get(), new Item.Properties().group(IndustrialCraft3.TAB)));
    public static final RegistryObject<Item> TIN_ORE_BLOCK_ITEM = ITEMS.register("tin_ore_block", () -> new BlockItem(TIN_ORE_BLOCK.get(), new Item.Properties().group(IndustrialCraft3.TAB)));
    public static final RegistryObject<Item> COPPER_ORE_BLOCK_ITEM = ITEMS.register("copper_ore_block", () -> new BlockItem(COPPER_ORE_BLOCK.get(), new Item.Properties().group(IndustrialCraft3.TAB)));
    public static final RegistryObject<Item> RUBBER_LOG_BLOCK_ITEM = ITEMS.register("rubber_log_block", () -> new BlockItem(RUBBER_LOG_BLOCK.get(), new Item.Properties().group(IndustrialCraft3.TAB)));
    public static final RegistryObject<Item> RUBBER_LEAVES_BLOCK_ITEM = ITEMS.register("rubber_leaves_block", () -> new BlockItem(RUBBER_LEAVES_BLOCK.get(), new Item.Properties().group(IndustrialCraft3.TAB)));
    public static final RegistryObject<Item> RUBBER_SAPLING_BLOCK_ITEM = ITEMS.register("rubber_sapling_block", () -> new BlockItem(RUBBER_SAPLING_BLOCK.get(), new Item.Properties().group(IndustrialCraft3.TAB)));
    public static final RegistryObject<Item> QUARRY_BLOCK_ITEM = ITEMS.register("quarry_block", () -> new BlockItem(QUARRY_BLOCK.get(), new Item.Properties().group(IndustrialCraft3.TAB)));
    public static final RegistryObject<Item> URANIUM_ORE_BLOCK_ITEM = ITEMS.register("uranium_ore_block", () -> new BlockItem(URANIUM_ORE_BLOCK.get(), new Item.Properties().group(IndustrialCraft3.TAB)));


    // TILE ENTITY
    public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY_TILE_ENTITY = TILE_ENTITY_TYPES.register("quarry_entity", () -> TileEntityType.Builder.create(QuarryTileEntity::new, QUARRY_BLOCK.get()).build(null));

}
