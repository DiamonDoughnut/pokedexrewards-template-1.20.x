package net.donut.dexrewards.datagen;

import net.donut.dexrewards.block.ModBlocks;
import net.donut.dexrewards.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //this works for blocks with the same texture on all sides
        //generates both block and model json files
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.End_Dex_Ore);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Dex_Ore);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Nether_Dex_Ore);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Deepslate_Dex_Ore);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Dex_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEX_CHECK_BLOCK);
        //delete once dependencies enabled
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BOTANIA_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COBBLEMON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.HEPHAESTUS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUNE_BLOCK);
//        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.Raw_Dex_Block);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //generates Item texture json files
        //                              item with path              parent
//        itemModelGenerator.register(ModItems.LEGENDSHARDSMALL, Models.GENERATED);
//        itemModelGenerator.register(ModItems.SUBLEGENDCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.LEGENDCATALYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.LEGENDCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.MYTHCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.MEWTWOSUMMON, Models.GENERATED);
//        itemModelGenerator.register(ModItems.BUGCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.DARKCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.DRAGONCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.NORMALCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.ROCKCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.WATERCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.ELECTRICCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.GRASSCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.POISONCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.PSYCHICCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.FIRECRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.GROUNDCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.FLYINGCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.GHOSTCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.FIGHTINGCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.STEELCRYST, Models.GENERATED);
//        itemModelGenerator.register(ModItems.ICECRYST, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEXREWARD1, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEXREWARD2, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEXREWARD3, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEXREWARD4, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEXREWARD5, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEXREWARD6, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEXREWARD7, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEXREWARD8, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEXREWARD9, Models.GENERATED);
        itemModelGenerator.register(ModItems.DEXREWARD10, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.COWPIE, Models.GENERATED);
    }
}