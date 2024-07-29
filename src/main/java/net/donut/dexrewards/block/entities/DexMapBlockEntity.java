package net.donut.dexrewards.block.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIntArray;
import net.minecraft.nbt.NbtList;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.profiler.Sampler;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class DexMapBlockEntity extends BlockEntity implements Nameable {
    @Nullable
    private Text customName;
    int[] tokens = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    int tokenCount = Arrays.stream(tokens).findAny().orElse(2);
    int tokenTotal = Arrays.stream(tokens).sum();
    int[] activeTokens = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    boolean[] tokenCheck = new boolean[]{true, false, false, false, false, false, false, false, false, false, false, false, false};



    public DexMapBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.DEX_MAP_BLOCK_ENTITY, pos, state);

    }




    @Override
    public Text getName() {
        return null;
    }

    @Nullable
    public Text getCustomName() {
        return this.customName;
    }

    public void setCustomName(Text customName) {
        this.customName = customName;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        for(int i = 0; i <= 12; i++){
            tokenCheck[i] = nbt.getBoolean("Token" + i);
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        for(int i = 0; i <= 12; i++){
            nbt.putBoolean("Token" + i, tokenCheck[i]);
        }

    }

    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}