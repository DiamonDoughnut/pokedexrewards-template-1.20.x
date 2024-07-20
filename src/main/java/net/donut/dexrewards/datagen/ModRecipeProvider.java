package net.donut.dexrewards.datagen;

import net.donut.dexrewards.block.ModBlocks;
import net.donut.dexrewards.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    //make a list for all smeltable blocks so future uses are compact
//    private static final List<ItemConvertible> DEX_SMELTABLES =
//            List.of(
//                    ModItems.DEXREWARD1,
//                    ModBlocks.Dex_Ore,
//                    ModBlocks.End_Dex_Ore,
//                    ModBlocks.Nether_Dex_Ore,
//                    ModBlocks.Deepslate_Dex_Ore
//                    );

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //call offerSmelting and offerBlasting, passing in exporter and the list from above of smeltables, followed by normal variables
 //       offerSmelting(exporter, DEX_SMELTABLES, RecipeCategory.MISC, ModItems.LEGENDSHARDSMALL, 0.7f, 200, "dex");
 //       offerBlasting(exporter, DEX_SMELTABLES, RecipeCategory.MISC, ModItems.LEGENDSHARDSMALL, 0.7f, 100, "dex");

        //offerReversableCompactingRecipes is available and creates two recipes for either 4x4 or 9x9 recipes with the same item in all slots
 //       offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.DEXREWARD1, RecipeCategory.DECORATIONS, ModBlocks.Dex_Block);

        //Custom Shaped recipes must be done this way
 //       ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SUBLEGENDCRYST, 1)
 //               .pattern("###")
 //               .pattern("#*#")
 //               .pattern("###")
 //               .input('#', ModItems.LEGENDSHARDSMALL)
 //               .input('*', ModItems.LEGENDCATALYST)
                //must add criterion for recipe book unlock
 //               .criterion(hasItem(ModItems.LEGENDSHARDSMALL), conditionsFromItem(ModItems.LEGENDSHARDSMALL))
 //               .criterion(hasItem(ModItems.LEGENDCATALYST), conditionsFromItem(ModItems.LEGENDCATALYST))
                //finally the offerTo function allows us to name the recipe
 //               .offerTo(exporter, new Identifier("sub_legend_from_catalysed_shards"));

 //       ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.MEWTWOSUMMON, 1)
 //               .pattern(" C ")
 //               .pattern("CYC")
 //               .pattern(" C ")
 //               .input('C', ModItems.PSYCHICCRYST)
 //               .input('Y', ModItems.SUBLEGENDCRYST)
 //               .criterion(hasItem(ModItems.SUBLEGENDCRYST), conditionsFromItem(ModItems.SUBLEGENDCRYST))
 //               .offerTo(exporter, new Identifier("sub_legend_cryst_to_mewtwo_summon"));

        //middlemouse on offer-phrase to look at recipeProvider class for ease of use
    }
}
