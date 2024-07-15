package net.donut.dexrewards.item;

import net.donut.dexrewards.DexRewards;
import net.donut.dexrewards.block.ModBlocks;
import net.donut.dexrewards.block.custom.DexCheckBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.donut.dexrewards.item.ModItems.*;

public class ModItemGroups {

    //Creative Item tab for Dex Reward Items
    public static final ItemGroup DEX_REWARDS = Registry.register(Registries.ITEM_GROUP, new Identifier(DexRewards.MOD_ID, "dexrewards"), FabricItemGroup.builder().displayName(Text.translatable("itemgroup.dexrewards")).icon(() -> new ItemStack(ModItems.DEXREWARD10)).entries((displayContext, entries) -> {
        //dex completion items
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

        //blocks to be commented out/changed later
        entries.add(ModBlocks.Dex_Block);
        entries.add(ModBlocks.Raw_Dex_Block);
        entries.add(ModBlocks.Dex_Ore);
        entries.add(ModBlocks.Deepslate_Dex_Ore);
        entries.add(ModBlocks.Nether_Dex_Ore);
        entries.add(ModBlocks.End_Dex_Ore);
        entries.add(ModBlocks.Dex_Check_Block);
    }).build());

    //Creative Item tab for Legend crystals
    public static final ItemGroup LEGEND_CRYSTALS = Registry.register(Registries.ITEM_GROUP, new Identifier(DexRewards.MOD_ID,"legendcrysts"), FabricItemGroup.builder().displayName(Text.of("Legend Crystals")).icon(() -> new ItemStack(LEGENDCRYST)).entries((displayContext, entries) -> {
        //legend crystals
        entries.add(LEGENDSHARDSMALL);
        entries.add(SUBLEGENDCRYST);
        entries.add(LEGENDCRYST);
        entries.add(MYTHCRYST);
        entries.add(LEGENDCATALYST);
        //type crystals
        entries.add(NORMALCRYST);
        entries.add(GRASSCRYST);
        entries.add(FIRECRYST);
        entries.add(WATERCRYST);
        entries.add(FAIRYCRYST);
        entries.add(DARKCRYST);
        entries.add(STEELCRYST);
        entries.add(GHOSTCRYST);
        entries.add(GROUNDCRYST);
        entries.add(ELECTRICCRYST);
        entries.add(FIGHTINGCRYST);
        entries.add(FLYINGCRYST);
        entries.add(ICECRYST);
        entries.add(POISONCRYST);
        entries.add(PSYCHICCRYST);
        entries.add(ROCKCRYST);
        entries.add(BUGCRYST);
        entries.add(DRAGONCRYST);
    }).build());

    public static void registerItemGroups() {
        DexRewards.LOGGER.info("Registering Item Groups for " + DexRewards.MOD_ID);
    }
}
