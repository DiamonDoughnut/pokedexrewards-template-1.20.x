package net.donut.dexrewards;

import net.donut.dexrewards.block.ModBlocks;
import net.donut.dexrewards.block.entity.ModBlockEntityType;
import net.donut.dexrewards.item.ModItemGroups;
import net.donut.dexrewards.item.ModItems;
import net.donut.dexrewards.util.ModCustomTrades;
import net.donut.dexrewards.villager.ModVillagers;
import net.donut.dexrewards.world.VillageAdditions;
import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

import java.util.Objects;
import java.util.Optional;

public class DexRewards implements ModInitializer {
	public static final String MOD_ID = "dexrewards";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
		ModItems.RegisterModItems();
		GeckoLib.initialize();
		ModCustomTrades.registerCustomTrades();
		ModVillagers.registerVillagers();
		ModBlockEntityType.registerBlockEntities();

		//register village structures by mod with soft depend
		if(checkModPresence("betterarcheology", "iron_brush") &&
			checkModPresence("runic_enchanting", "rune_chalk") &&
			checkModPresence("tconstruct", "seared_brick") &&
			checkModPresence("cobblemon", "poke_ball") &&
			checkModPresence("adorn", "guide_book") &&
			checkModPresence("stoneexpansion", "quartz_tiles") &&
			checkModPresence("create", "powered_latch") &&
			checkModPresence("create", "powered_latch") &&
			checkModPresence("amendments", "dye_bottle") &&
			checkModPresence("arts_and_crafts", "bleachdew") &&
			checkModPresence("mcwroofs", "roofing_hammer") &&
			checkModPresence("mcwdoors", "print_oak") &&
			checkModPresence("mcwfurnitures", "cabinet_door") &&
			checkModPresence("geode_plus", "wrappist_glass") &&
			checkModPresence("pyrite", "poisonous_dye") &&
			checkModPresence("deeperdarker", "soul_dust") &&
			checkModPresence("createdeco", "netherite_coin") &&
			checkModPresence("mcwlights", "white_lamp") &&
			checkModPresence("botania", "dreamwood_wand")){
				VillageAdditions.registerArcheoStructures();
				VillageAdditions.registerBotaniaStructures();
				VillageAdditions.registerCobblemonStructures();
				VillageAdditions.registerHephaestusStructures();
				VillageAdditions.registerMedicStructures();
				VillageAdditions.registerPastureStructures();
				VillageAdditions.registerRuneStructures();
			}



//		FuelRegistry.INSTANCE.add(ModItems.COWPIE, 200);
	}

	public static boolean checkModPresence(String namespace, String key){
		Optional<Item> modItemFinal = Registries.ITEM.stream().filter(item -> Objects.equals(Identifier.of(namespace, key), Registries.ITEM.getId(item))).findFirst();
		return modItemFinal.isPresent();
	}
}