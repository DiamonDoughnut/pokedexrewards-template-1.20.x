package net.donut.dexrewards.datagen;

import net.donut.dexrewards.item.ModItems;
import net.donut.dexrewards.item.custom.MapTokens;
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
                .add(MapTokens.BASE.getRegistry())
                .add(MapTokens.KANTO.getRegistry())
                .add(MapTokens.JOHTO.getRegistry())
                .add(MapTokens.HOENN.getRegistry())
                .add(MapTokens.SINNOH.getRegistry())
                .add(MapTokens.UNOVA.getRegistry())
                .add(MapTokens.KALOS.getRegistry())
                .add(MapTokens.ALOLA.getRegistry())
                .add(MapTokens.GALAR.getRegistry())
                .add(MapTokens.PALDEA.getRegistry())
                .add(MapTokens.DEX25.getRegistry())
                .add(MapTokens.DEX50.getRegistry())
                .add(MapTokens.DEX75.getRegistry())
                .add(MapTokens.DEX100.getRegistry());

    }
}

