package net.donut.dexrewards.datagen;

import net.donut.dexrewards.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        //for dropping the block when broken, as per Oak Log or such
//        addDrop(ModBlocks.Dex_Block);
        addDrop(ModBlocks.DEX_CHECK_BLOCK);
        //delete once dependencies enabled
        addDrop(ModBlocks.BOTANIA_BLOCK);
        addDrop(ModBlocks.COBBLEMON_BLOCK);
        addDrop(ModBlocks.HEPHAESTUS_BLOCK);
        addDrop(ModBlocks.RUNE_BLOCK);
        addDrop(ModBlocks.ARCHAEO_BLOCK);

        //for dropping ore/similar items when broken, as per Diamond Ore, et.c.
        // this method drops 1 item:        dropped with silk touch     dropped with normal
        //addDrop(ModBlocks.Dex_Ore, oreDrops(ModBlocks.Dex_Ore, ModItems.LEGENDSHARDSMALL));

        //instead copying over the function for copper ore blocks and renaming it will allow us to drop more
//        addDrop(ModBlocks.Dex_Ore, copperLikeOreDrops(ModBlocks.Dex_Ore, ModItems.LEGENDSHARDSMALL));
//        addDrop(ModBlocks.Deepslate_Dex_Ore, copperLikeOreDrops(ModBlocks.Deepslate_Dex_Ore, ModItems.LEGENDSHARDSMALL));
//        addDrop(ModBlocks.Nether_Dex_Ore, copperLikeOreDrops(ModBlocks.Nether_Dex_Ore, ModItems.LEGENDSHARDSMALL));
//        addDrop(ModBlocks.End_Dex_Ore, copperLikeOreDrops(ModBlocks.End_Dex_Ore, ModItems.LEGENDSHARDSMALL));
    }

//    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
//        return dropsWithSilkTouch(
//                drop,
//                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
//                        drop,
//                        ItemEntry.builder(item)
//                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
//                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
//                )
//        );
//    }
}
