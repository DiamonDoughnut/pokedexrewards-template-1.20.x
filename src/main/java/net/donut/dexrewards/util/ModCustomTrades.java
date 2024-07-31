package net.donut.dexrewards.util;

import net.donut.dexrewards.block.ModBlocks;
import net.donut.dexrewards.item.ModItems;
import net.donut.dexrewards.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

import java.util.Objects;
import java.util.Optional;


public class ModCustomTrades {
    public static void registerCustomTrades(){
        //Add trades to villager with variables (profession, trade level, and trade)
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER, 1, factories -> {
//            //build a factory to create the trade in the function above
//            factories.add((entity, random) -> new TradeOffer(
//                    //Item the villager requests and how many - add an extra item stack before the item returned if cost is 2 different items
//                    new ItemStack(Items.EMERALD, 2),
//                    //Item the villager is selling and how many per sale - will always be the last ItemStack in the factory
//                    new ItemStack(ModItems.COWPIE, 5),
//                    //number of times trade can be done before being disabled by villager
//                    6,
//                    //amount of EXP given to villager
//                    5,
//                    //multiplier applied as either negative or positive based on reputation
//                    0.05f));
//        });

//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 1, factories ->{
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.ROCK, 1),
//                    new ItemStack(Items.BOOK, 1),
//                    //returning an enchanted book
//                    EnchantedBookItem.forEnchantment(new EnchantmentLevelEntry(Enchantments.MENDING, 1)),
//                    10, 2, 0.2f
//            ));
//        });

//        TradeOfferHelper.registerVillagerOffers(ModVillagers.TEST_PROFESSION, 1, factories ->{
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.ROCK, 1),
//                    //returning an enchanted book
//                    new ItemStack(ModBlocks.DEX_MAP_BLOCK),
//                    10, 2, 0.2f
//            ));
//        });

//        TradeOfferHelper.registerVillagerOffers(ModVillagers.TEST_PROFESSION, 2, factories ->{
//            factories.add((entity, random) -> new TradeOffer(
//                    new ItemStack(ModItems.ROCK, 1),
//                    //returning an enchanted book
//                    new ItemStack(ModItems.COWPIE),
//                    10, 4, 0.2f
//            ));
//        });

        //Import block and items for Botania trades
        Optional<Item> externalItem;
        Item modItem;
        Item modItem2;
        externalItem = Registries.ITEM.stream().filter(
                item -> Registries.ITEM.getId(item).equals(Identifier.of("botania", "rune_wrath"))
        ).findFirst();
        modItem = externalItem.map(Objects::requireNonNull).orElse(ModItems.ROCK);
        TradeOfferHelper.registerVillagerOffers(ModVillagers.BOTANIA_VILLAGER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(modItem, 1), new ItemStack(Items.EMERALD, 5),
                    2, 5, 0.2f
            ));
        });
    }
}
