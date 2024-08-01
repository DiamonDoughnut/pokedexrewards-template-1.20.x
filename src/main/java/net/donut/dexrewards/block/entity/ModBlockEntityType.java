package net.donut.dexrewards.block.entity;

import net.donut.dexrewards.DexRewards;
import net.donut.dexrewards.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntityType {

    public static final BlockEntityType<DexMapBlockEntity> DEX_MAP_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DexRewards.MOD_ID, "dex_map_be"),
                    FabricBlockEntityTypeBuilder.create(DexMapBlockEntity::new, ModBlocks.DEX_MAP_BLOCK).build());




    public static void registerBlockEntities() {
        DexRewards.LOGGER.info("Regisering Block entity for " + DexRewards.MOD_ID);
    }
}
