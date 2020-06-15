package com.norbana.industrialcraft3.items;

import com.norbana.industrialcraft3.IndustrialCraft3;
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

    // TODO creer un effet de potion et trouver comment l'appliquer proprement
    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        LivingEntity e = (LivingEntity) entityIn;
        e.addPotionEffect(new EffectInstance(Effects.POISON, 60, 0));
    }
}
