package net.donut.dexrewards.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.*;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DexMapBlockEntity extends BlockEntity implements Nameable {
    @Nullable
    private Text customName;
    int[] tokens = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    public static List<Boolean> tokenList = List.of(true, false, false, false, false, false, false, false, false, false, false, false, false, false);
    public static List<Boolean> tokenMutable = new ArrayList<>(tokenList);
    public static List<String> tokenNames = List.of("base", "dex25", "dex50", "dex75", "dex100", "kanto", "johto", "hoenn", "sinnoh", "unova", "kalos", "alola", "galar", "paldea");





    public DexMapBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.DEX_MAP_BLOCK_ENTITY, pos, state);

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
       for(int i = 1; i <= 13; i++){
           tokenMutable.set(i, nbt.getBoolean(tokenNames.get(i)));
       }
    }


    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        for (int i = 0; i <= 13; i++){
            nbt.putBoolean(tokenNames.get(i), tokenMutable.get(i));
        }

    }

}
