package net.donut.dexrewards.block;

import net.donut.dexrewards.DexRewards;
import net.donut.dexrewards.block.custom.*;
import net.donut.dexrewards.item.custom.MapToken;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;

public class ModBlocks {
//    public static final Block Dex_Block = registerBlock("dex_block", new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
//    public static final Block Raw_Dex_Block = registerBlock("raw_dex_block", new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));

    RegistryKey<Registry<MapToken>> MAP_TOKEN;




    //comment out once mod dependencies added and new job block chosen
    public static final Block BOTANIA_BLOCK = registerBlock("botania_block", new Block(FabricBlockSettings.copyOf(Blocks.FLETCHING_TABLE)));
    public static final Block COBBLEMON_BLOCK = registerBlock("cobblemon_block", new Block(FabricBlockSettings.copyOf(Blocks.FLETCHING_TABLE)));
    public static final Block COBBLEMON_BLOCK1 = registerBlock("cobblemon_block1", new Block(FabricBlockSettings.copyOf(Blocks.FLETCHING_TABLE)));
    public static final Block HEPHAESTUS_BLOCK = registerBlock("hephaestus_block", new Block(FabricBlockSettings.copyOf(Blocks.FLETCHING_TABLE)));
    public static final Block RUNE_BLOCK = registerBlock("rune_block", new Block(FabricBlockSettings.copyOf(Blocks.FLETCHING_TABLE)));
    public static final Block ARCHEO_BLOCK = registerBlock("archeo_block", new Block(FabricBlockSettings.copyOf(Blocks.FLETCHING_TABLE)));
    public static final Block DEX_MAP_BLOCK = registerBlock("dex_map_block", new DexMapBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
//    public static final Block Dex_Ore = registerBlock("dex_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2,5)));
//    public static final Block Deepslate_Dex_Ore = registerBlock("deepslate_dex_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(4f), UniformIntProvider.create(2,5)));
//    public static final Block Nether_Dex_Ore = registerBlock("nether_dex_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.NETHERRACK).strength(1.5f), UniformIntProvider.create(2,5)));
//    public static final Block End_Dex_Ore = registerBlock("end_dex_ore", new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).strength(4f), UniformIntProvider.create(2,5)));
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(DexRewards.MOD_ID, name), block);
    }


    public static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(DexRewards.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        DexRewards.LOGGER.info("Registering ModBlocks for " + DexRewards.MOD_ID);
    }

}
