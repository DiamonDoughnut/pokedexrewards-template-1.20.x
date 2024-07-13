package net.donut.dexrewards;

import net.donut.dexrewards.item.ModItemGroups;
import net.donut.dexrewards.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DexRewards implements ModInitializer {
	public static final String MOD_ID = "dexrewards";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.RegisterModItems();
	}
}