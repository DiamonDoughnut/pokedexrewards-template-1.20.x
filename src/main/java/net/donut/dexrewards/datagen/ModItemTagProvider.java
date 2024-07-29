package net.donut.dexrewards.datagen;

import net.donut.dexrewards.block.ModBlocks;
import net.donut.dexrewards.item.ModItems;
import net.donut.dexrewards.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Items.DEX_REWARD_ITEMS)
                .add(ModItems.DEXREWARDKANTO)
                .add(ModItems.DEXREWARDJOHTO)
                .add(ModItems.DEXREWARDHOENN)
                .add(ModItems.DEXREWARDSINNOH)
                .add(ModItems.DEXREWARDUNOVA)
                .add(ModItems.DEXREWARDKALOS)
                .add(ModItems.DEXREWARDALOLA)
                .add(ModItems.DEXREWARDGALAR)
                .add(ModItems.DEXREWARDPALDEA)
                .add(ModItems.DEXREWARD25)
                .add(ModItems.DEXREWARD50)
                .add(ModItems.DEXREWARD75)
                .add(ModItems.DEXREWARD100);

    }
}

