package net.donut.dexrewards.block.custom;

import net.donut.dexrewards.util.DexBlockNBTAssist;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class AbstractDexMapBlock<E extends BlockEntity> extends BlockWithEntity {
    protected Supplier<BlockEntityType<? extends E>> entityTypeRetriever = null;
    protected AbstractDexMapBlock(Settings settings, Supplier<BlockEntityType<? extends E>> entityTypeSupplier) {
        super(settings);
        this.entityTypeRetriever = entityTypeSupplier;
    }


    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {

        if (world.isClient) {
            world.getBlockEntity(pos, ModBlockEntityType.DEX_MAP).ifPresent((blockEntity) -> {
                new DexBlockNBTAssist(itemStack);
            });
        } else if (itemStack.hasCustomName()) {
            world.getBlockEntity(pos, ModBlockEntityType.DEX_MAP).ifPresent((blockEntity) -> {
                DexBlockNBTAssist.setCustomName(itemStack.getName());
            });
        }

    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}
