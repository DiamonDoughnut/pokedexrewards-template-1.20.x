package net.donut.dexrewards.item;

import net.donut.dexrewards.DexRewards;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DEX_REWARDS = Registry.register(Registries.ITEM_GROUP, new Identifier(DexRewards.MOD_ID, "dexrewards"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.dexrewards")).icon(() -> new ItemStack(ModItems.DEXREWARD10)).entries((displayContext, entries) -> {
        entries.add(ModItems.DEXREWARD1);
        entries.add(ModItems.DEXREWARD2);
        entries.add(ModItems.DEXREWARD3);
        entries.add(ModItems.DEXREWARD4);
        entries.add(ModItems.DEXREWARD5);
        entries.add(ModItems.DEXREWARD6);
        entries.add(ModItems.DEXREWARD7);
        entries.add(ModItems.DEXREWARD8);
        entries.add(ModItems.DEXREWARD9);
        entries.add(ModItems.DEXREWARD10);
    }).build());

    public static void registerItemGroups() {
        DexRewards.LOGGER.info("Registering Item Groups for " + DexRewards.MOD_ID);
    }
}
