package net.donut.dexrewards.block.entities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.nbt.*;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.profiler.Sampler;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.donut.dexrewards.block.custom.DexMapBlock.*;

public class DexMapBlockEntity extends BlockEntity implements Nameable {
    @Nullable
    private Text customName;
    int[] tokens = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    public boolean[] tokenCheck = new boolean[]{true, false, false, false, false, false, false, false, false, false, false, false, false, false};
    public String [] tokenNames = new String[]{"base", "kanto", "johto", "hoenn", "sinnoh", "unova", "kalos", "alola", "galar", "paldea", "dex25", "dex50", "dex75", "dex100"};
    public NbtCompound nbt = new NbtCompound();



    public DexMapBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.DEX_MAP_BLOCK_ENTITY, pos, state);

    }


    public List<Boolean> getRenderState(NbtCompound nbt) {
        if (nbt.isEmpty()){
            for (int t = 0; t <= 13; t++){
                nbt.putBoolean(tokenNames[t], tokenCheck[t]);
            }
        }
        List<Boolean> checks = List.of(true, false, false, false, false, false, false, false, false, false, false, false, false, false);
        for(int i = 0; i <=13; i++){
            checks.set(i, nbt.getBoolean(tokenNames[i]));
        }

        return checks;
    }

    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt();
    }

    @Override
    public Text getName() {
        return null;
    }

    @Nullable
    public Text getCustomName() {
        return this.customName;
    }

    @Override
    public void markDirty() {
        world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        super.markDirty();
    }

    public void setCustomName(Text customName) {
        this.customName = customName;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (nbt.isEmpty()){
            for (int t = 0; t <= 13; t++){
                nbt.putBoolean(tokenNames[t], tokenCheck[t]);
            }
        }
        for(int i = 0; i <= 12; i++){
            tokenCheck[i] = nbt.getBoolean(tokenNames[i]);
        }
    }
    public NbtCompound pullNbt(){
        return nbt;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        for(int i = 0; i <= 12; i++){
            nbt.putBoolean(tokenNames[i], tokenCheck[i]);
        }

    }

}
