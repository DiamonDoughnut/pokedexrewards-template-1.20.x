package net.donut.dexrewards.item;

import net.donut.dexrewards.DexRewards;

import net.donut.dexrewards.item.custom.MapToken;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {

    //Dex reward items for use in completion of pokedex
    public static final Item DEXREWARDKANTO = registerItem("dexreward_kanto", new MapToken(new FabricItemSettings().maxDamage(1)));
    public static final Item DEXREWARDJOHTO = registerItem("dexreward_johto", new MapToken(new FabricItemSettings().maxDamage(1)));
    public static final Item DEXREWARDHOENN = registerItem("dexreward_hoenn", new MapToken(new FabricItemSettings().maxDamage(1)));
    public static final Item DEXREWARDSINNOH = registerItem("dexreward_sinnoh", new MapToken(new FabricItemSettings().maxDamage(1)));
    public static final Item DEXREWARDUNOVA = registerItem("dexreward_unova", new MapToken(new FabricItemSettings().maxDamage(1)));
    public static final Item DEXREWARDKALOS = registerItem("dexreward_kalos", new MapToken(new FabricItemSettings().maxDamage(1)));
    public static final Item DEXREWARDALOLA = registerItem("dexreward_alola", new MapToken(new FabricItemSettings().maxDamage(1)));
    public static final Item DEXREWARDGALAR = registerItem("dexreward_galar", new MapToken(new FabricItemSettings().maxDamage(1)));
    public static final Item DEXREWARDPALDEA = registerItem("dexreward_paldea", new MapToken(new FabricItemSettings().maxDamage(1)));
    public static final Item DEXREWARD25 = registerItem("dexreward_25", new MapToken(new FabricItemSettings().maxDamage(1)));
    public static final Item DEXREWARD50 = registerItem("dexreward_50", new MapToken(new FabricItemSettings().maxDamage(1)));
    public static final Item DEXREWARD75 = registerItem("dexreward_75", new MapToken(new FabricItemSettings().maxDamage(1)));
    public static final Item DEXREWARD100 = registerItem("dexreward_100", new MapToken(new FabricItemSettings().maxDamage(1)));


//    public static final Block MAP_TOKEN = MapTokens.registerAndGetDefault(MapTokens.BASE);
    public static final Item ROCK = registerItem("rock", new Item(new FabricItemSettings().food(ModFoodComponents.ROCK)));
//    public static final Item COWPIE = registerItem("cowpie", new Item(new FabricItemSettings()));


    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(DexRewards.MOD_ID, name), item);
    }

    public static void RegisterModItems()   {
        DexRewards.LOGGER.info("Registering Mod Items for " + DexRewards.MOD_ID);
    }

}
