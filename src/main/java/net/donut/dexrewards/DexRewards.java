package net.donut.dexrewards;

import net.donut.dexrewards.block.ModBlocks;
import net.donut.dexrewards.item.ModItemGroups;
import net.donut.dexrewards.item.ModItems;
import net.donut.dexrewards.util.ModCustomTrades;
import net.donut.dexrewards.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DexRewards implements ModInitializer {
	public static final String MOD_ID = "dexrewards";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
		ModItems.RegisterModItems();

		ModCustomTrades.registerCustomTrades();
		ModVillagers.registerVillagers();

		FuelRegistry.INSTANCE.add(ModItems.COWPIE, 200);
	}
}