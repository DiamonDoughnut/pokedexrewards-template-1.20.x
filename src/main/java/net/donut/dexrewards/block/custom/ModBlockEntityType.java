package net.donut.dexrewards.block.custom;

import com.mojang.datafixers.types.Type;
import jdk.jshell.spi.ExecutionControl;
import net.donut.dexrewards.DexRewards;
import net.donut.dexrewards.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;

import java.util.Set;

public class ModBlockEntityType<T> extends BlockEntity {

    public static final BlockEntityType DEX_MAP;
    static{
        DEX_MAP = create("dex_map", BlockEntityType.Builder.create(DexMapBlockEntity::new, ModBlocks.DEX_MAP_BLOCK));
    }




    private static <T extends BlockEntity> BlockEntityType create(String id, BlockEntityType.Builder<T> builder) {
        if (id == null){
            id = "check ModBlockEntityType.java";
            DexRewards.LOGGER.warn("Block entity type {} requires at least one valid path to be defined!", id);
        }

        Type<?> type = Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id);

        return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, builder.build(type));
    }


    public ModBlockEntityType(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }
}
