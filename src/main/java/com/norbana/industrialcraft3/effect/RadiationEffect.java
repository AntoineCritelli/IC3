package com.norbana.industrialcraft3.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;

import javax.annotation.Nullable;

public class RadiationEffect extends Effect {


    public RadiationEffect(){
        super(EffectType.HARMFUL, 0x0dd914);
    }


    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        if (entityLivingBaseIn.getHealth() > 1.0F) {
            entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, 1.0F);
        }
    }


    @Override
    public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity entityLivingBaseIn, int amplifier, double health) {
        int j = (int)(health * (double)(6 << amplifier) + 0.5D);
        entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, (float)j);
    }


    @Override
    public boolean isReady(int duration, int amplifier) {
        int j = 25 >> amplifier;
        if (j > 0) {
            return duration % j == 0;
        } else {
            return true;
        }
    }

    @Override
    protected String getOrCreateDescriptionId() {
        return "Radiation Effect";
    }
}
