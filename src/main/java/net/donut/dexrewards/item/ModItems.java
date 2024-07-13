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

    public static void addToCreativeTabGroup(FabricItemGroupEntries entries){
        entries.add(DEXREWARD1);
    }

    public static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(DexRewards.MOD_ID, name), item);
    }

    public static void RegisterModItems()   {
        DexRewards.LOGGER.info("Registering Mod Items for " + DexRewards.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addToCreativeTabGroup);
    }
}
