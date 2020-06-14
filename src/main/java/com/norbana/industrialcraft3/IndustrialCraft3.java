package com.norbana.industrialcraft3;


import com.norbana.industrialcraft3.util.RegistryHandler;
import com.norbana.industrialcraft3.world.gen.OreGen;
import com.norbana.industrialcraft3.world.gen.TreeGen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("industrialcraft3")
public class IndustrialCraft3
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "industrialcraft3";

    public IndustrialCraft3() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);


        RegistryHandler.init();
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        OreGen.generateOre();
        TreeGen.generateTree();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(RegistryHandler.RUBBER_SAPLING_BLOCK.get(), RenderType.getCutout());
    }


    public static final ItemGroup TAB = new ItemGroup("industrialcraft3Tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.TIN_INGOT.get());
        }
    };


}
