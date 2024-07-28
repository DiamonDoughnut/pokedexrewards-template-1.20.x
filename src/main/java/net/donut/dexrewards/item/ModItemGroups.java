package net.donut.dexrewards.item;

import net.donut.dexrewards.DexRewards;
import net.donut.dexrewards.block.ModBlocks;
import net.donut.dexrewards.item.custom.MapTokens;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.donut.dexrewards.item.ModItems.*;
import static net.donut.dexrewards.item.custom.MapTokens.*;

public class ModItemGroups {

    //Creative Item tab for Dex Reward Items
    public static final ItemGroup DEX_REWARDS = Registry.register(Registries.ITEM_GROUP, new Identifier(DexRewards.MOD_ID, "dexrewards"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.dexrewards")).icon(() -> new ItemStack((ItemConvertible) DEX100)).entries((displayContext, entries) -> {
        //dex completion items
        entries.add((ItemConvertible) KANTO);
        entries.add((ItemConvertible) JOHTO);
        entries.add((ItemConvertible) HOENN);
        entries.add((ItemConvertible) SINNOH);
        entries.add((ItemConvertible) UNOVA);
        entries.add((ItemConvertible) KALOS);
        entries.add((ItemConvertible) ALOLA);
        entries.add((ItemConvertible) GALAR);
        entries.add((ItemConvertible) PALDEA);
        entries.add((ItemConvertible) DEX25);
        entries.add((ItemConvertible) DEX50);
        entries.add((ItemConvertible) DEX75);
        entries.add((ItemConvertible) DEX100);

        //block to be commented out/changed later
//        entries.add(ModBlocks.Dex_Block);
//        entries.add(ModBlocks.Raw_Dex_Block);
//        entries.add(ModBlocks.Dex_Ore);
//        entries.add(ModBlocks.Deepslate_Dex_Ore);
//        entries.add(ModBlocks.Nether_Dex_Ore);
//        entries.add(ModBlocks.End_Dex_Ore);
        entries.add(ModBlocks.DEX_MAP_BLOCK);
        entries.add(ROCK);
 //       entries.add(COWPIE);
    }).build());

    //remove when dependencies added
    public static final ItemGroup VILLAGER_TEMP_BLOCKS = Registry.register(Registries.ITEM_GROUP, new Identifier(DexRewards.MOD_ID, "villagertemp"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.villagertemp")).icon(() -> new ItemStack(ModBlocks.BOTANIA_BLOCK)).entries((displayContext, entries) -> {
        entries.add(ModBlocks.BOTANIA_BLOCK);
        entries.add(ModBlocks.COBBLEMON_BLOCK);
        entries.add(ModBlocks.HEPHAESTUS_BLOCK);
        entries.add(ModBlocks.RUNE_BLOCK);
    }).build());

    public static void registerItemGroups() {
        DexRewards.LOGGER.info("Registering Item Groups for " + DexRewards.MOD_ID);
    }
}
