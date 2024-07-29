package net.donut.dexrewards.block.entities;

import net.donut.dexrewards.DexRewards;
import net.donut.dexrewards.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModBlockEntityType {

    public static final BlockEntityType<DexMapBlockEntity> DEX_MAP_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DexRewards.MOD_ID, "dex_map_be"),
                    FabricBlockEntityTypeBuilder.create(DexMapBlockEntity::new, ModBlocks.DEX_MAP_BLOCK).build());




    public static void registerBlockEntities() {
        DexRewards.LOGGER.info("Regisering Block entities for " + DexRewards.MOD_ID);
    }
}
