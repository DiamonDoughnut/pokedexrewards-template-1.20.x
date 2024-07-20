package net.donut.dexrewards.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent ROCK = new FoodComponent.Builder().alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1), 1f).build();
}
