package com.norbana.industrialcraft3.items;

import com.norbana.industrialcraft3.IndustrialCraft3;
import com.norbana.industrialcraft3.util.RegistryHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class UraniumIngot extends Item {

    public UraniumIngot() {
        super(new Item.Properties().group(IndustrialCraft3.TAB));
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        LivingEntity e = (LivingEntity) entityIn;

        if (!e.isPotionActive(RegistryHandler.RADIATION_EFFECT.get()))
            e.addPotionEffect(new EffectInstance(RegistryHandler.RADIATION_EFFECT.get(), 60, 0));
    }
}
