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
                //blocks from the current mod can be added with the basic add function
 //               .add(ModBlocks.Dex_Ore)
                //blocks from minecraft or other mods need a forceAddTag function
 //               .forceAddTag(BlockTags.GOLD_ORES)
 //               .forceAddTag(BlockTags.EMERALD_ORES)
 //               .forceAddTag(BlockTags.REDSTONE_ORES)
 //               .forceAddTag(BlockTags.DIAMOND_ORES)
 //               .forceAddTag(BlockTags.IRON_ORES)
 //               .forceAddTag(BlockTags.COPPER_ORES)
 //               .forceAddTag(BlockTags.COAL_ORES)
//                .forceAddTag(BlockTags.LAPIS_ORES);

        //example for minecraft native tags
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
   //             .add(ModBlocks.Dex_Ore)
  //              .add(ModBlocks.Deepslate_Dex_Ore)
  //              .add(ModBlocks.End_Dex_Ore)
  //              .add(ModBlocks.Nether_Dex_Ore)
  //              .add(ModBlocks.Dex_Block)
  //              .add(ModBlocks.Raw_Dex_Block)
                .add(ModBlocks.DEX_CHECK_BLOCK)
                //delete once dependencies enabled
                .add(ModBlocks.BOTANIA_BLOCK)
                .add(ModBlocks.COBBLEMON_BLOCK)
                .add(ModBlocks.HEPHAESTUS_BLOCK)
                .add(ModBlocks.RUNE_BLOCK)
                .add(ModBlocks.ARCHAEO_BLOCK);

  //      getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
  //              .add(ModBlocks.Dex_Block);

   //     getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
   //             .add(ModBlocks.Raw_Dex_Block)
   //             .add(ModBlocks.Nether_Dex_Ore)
   //             .add(ModBlocks.Dex_Ore);

   //     getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
   //             .add(ModBlocks.Deepslate_Dex_Ore);

        //example for how to use Fabric native tags
   //     getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
   //             .add(ModBlocks.End_Dex_Ore);
    }
}
