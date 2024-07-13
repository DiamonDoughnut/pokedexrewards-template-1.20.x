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

    public static void addToCreativeTabGroup(FabricItemGroupEntries entries){
        entries.add(DEXREWARD1);
        entries.add(DEXREWARD2);
        entries.add(DEXREWARD3);
        entries.add(DEXREWARD4);
        entries.add(DEXREWARD5);
        entries.add(DEXREWARD6);
        entries.add(DEXREWARD7);
        entries.add(DEXREWARD8);
        entries.add(DEXREWARD9);
        entries.add(DEXREWARD10);
    }

    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(DexRewards.MOD_ID, name), item);
    }

    public static void RegisterModItems()   {
        DexRewards.LOGGER.info("Registering Mod Items for " + DexRewards.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addToCreativeTabGroup);
    }
}
