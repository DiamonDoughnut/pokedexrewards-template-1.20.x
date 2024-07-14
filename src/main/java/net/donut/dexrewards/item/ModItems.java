package net.donut.dexrewards.item;

import net.donut.dexrewards.DexRewards;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    //Dex reward items for use in completion of pokedex
    public static final Item DEXREWARD1 = registerItem("dexreward1", new Item(new FabricItemSettings()));
    public static final Item DEXREWARD2 = registerItem("dexreward2", new Item(new FabricItemSettings()));
    public static final Item DEXREWARD3 = registerItem("dexreward3", new Item(new FabricItemSettings()));
    public static final Item DEXREWARD4 = registerItem("dexreward4", new Item(new FabricItemSettings()));
    public static final Item DEXREWARD5 = registerItem("dexreward5", new Item(new FabricItemSettings()));
    public static final Item DEXREWARD6 = registerItem("dexreward6", new Item(new FabricItemSettings()));
    public static final Item DEXREWARD7 = registerItem("dexreward7", new Item(new FabricItemSettings()));
    public static final Item DEXREWARD8 = registerItem("dexreward8", new Item(new FabricItemSettings()));
    public static final Item DEXREWARD9 = registerItem("dexreward9", new Item(new FabricItemSettings()));
    public static final Item DEXREWARD10 = registerItem("dexreward10", new Item(new FabricItemSettings()));

    //Legendary shard crystals for use in all legend summons
    public static final Item LEGENDSHARDSMALL = registerItem("shard_small", new Item(new FabricItemSettings()));
    public static final Item SUBLEGENDCRYST = registerItem("sub_legend_crystal", new Item(new FabricItemSettings()));
    public static final Item LEGENDCRYST = registerItem("legend_crystal", new Item(new FabricItemSettings()));
    public static final Item MYTHCRYST = registerItem("myth_crystal", new Item(new FabricItemSettings()));

    //type crystals for use in selecting legend summon
    public static final Item NORMALCRYST = registerItem("normal_essence", new Item(new FabricItemSettings()));
    public static final Item GRASSCRYST = registerItem("grass_essence", new Item(new FabricItemSettings()));
    public static final Item FIRECRYST = registerItem("fire_essence", new Item(new FabricItemSettings()));
    public static final Item WATERCRYST = registerItem("water_essence", new Item(new FabricItemSettings()));
    public static final Item ROCKCRYST = registerItem("rock_essence", new Item(new FabricItemSettings()));
    public static final Item ELECTRICCRYST = registerItem("electric_essence", new Item(new FabricItemSettings()));
    public static final Item POISONCRYST = registerItem("poison_essence", new Item(new FabricItemSettings()));
    public static final Item PSYCHICCRYST = registerItem("psychic_essence", new Item(new FabricItemSettings()));
    public static final Item GROUNDCRYST = registerItem("ground_essence", new Item(new FabricItemSettings()));
    public static final Item FLYINGCRYST = registerItem("flying_essence", new Item(new FabricItemSettings()));
    public static final Item BUGCRYST = registerItem("bug_essence", new Item(new FabricItemSettings()));
    public static final Item GHOSTCRYST = registerItem("ghost_essence", new Item(new FabricItemSettings()));
    public static final Item ICECRYST = registerItem("ice_essence", new Item(new FabricItemSettings()));
    public static final Item STEELCRYST = registerItem("steel_essence", new Item(new FabricItemSettings()));
    public static final Item DRAGONCRYST = registerItem("dragon_essence", new Item(new FabricItemSettings()));
    public static final Item DARKCRYST = registerItem("dark_essence", new Item(new FabricItemSettings()));
    public static final Item FAIRYCRYST = registerItem("fairy_essence", new Item(new FabricItemSettings()));
    public static final Item FIGHTINGCRYST = registerItem("fighting_essence", new Item(new FabricItemSettings()));



    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(DexRewards.MOD_ID, name), item);
    }

    public static void RegisterModItems()   {
        DexRewards.LOGGER.info("Registering Mod Items for " + DexRewards.MOD_ID);
    }
}
