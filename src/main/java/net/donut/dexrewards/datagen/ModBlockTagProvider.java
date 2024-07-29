package net.donut.dexrewards.datagen;

import net.donut.dexrewards.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        //example for custom tags
 //       getOrCreateTagBuilder(ModTags.Blocks.METAL_DETECTOR_DETECTABLE_BLOCKS)
                //block from the current mod can be added with the basic add function
 //               .add(ModBlocks.Dex_Ore)


        //example for minecraft native tags
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)

                //leaving for failed dependencies
                .add(ModBlocks.BOTANIA_BLOCK)
                .add(ModBlocks.COBBLEMON_BLOCK)
                .add(ModBlocks.HEPHAESTUS_BLOCK)
                .add(ModBlocks.RUNE_BLOCK)
                .add(ModBlocks.ARCHEO_BLOCK);

    }
}
