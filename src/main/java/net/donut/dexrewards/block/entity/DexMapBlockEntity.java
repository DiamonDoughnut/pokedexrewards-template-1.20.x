package net.donut.dexrewards.block.entity;

import net.donut.dexrewards.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DexMapBlockEntity extends BlockEntity implements ImplementedInventory {
    public List<Boolean> tokenList = List.of(true, false, false, false, false, false, false, false, false, false, false, false, false, false);
    public List<Boolean> tokenMutable = new ArrayList<>(tokenList);
    public List<String> tokenNames = List.of("base", "dex25", "dex50", "dex75", "dex100", "kanto", "johto", "hoenn", "sinnoh", "unova", "kalos", "alola", "galar", "paldea");
    private static int slot0 = 0;
    private static int slot1 = 1;
    private static int slot2 = 2;
    private static int slot3 = 3;
    private static int slot4 = 4;
    private static int slot5 = 5;
    private static int slot6 = 6;
    private static int slot7 = 7;
    private static int slot8 = 8;
    private static int slot9 = 9;
    private static int slot10 = 10;
    private static int slot11 = 11;
    private static int slot12 = 12;
    private final DefaultedList<ItemStack> inventory =  DefaultedList.ofSize(13, ItemStack.EMPTY);


    public DexMapBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.DEX_MAP_BLOCK_ENTITY, pos, state);

    }

    public DefaultedList<ItemStack> getInventory() {
        return inventory;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        if(slot == 0 && stack.isOf(ModItems.DEXREWARD25)){return true;}
        else if (slot == 1 && stack.isOf(ModItems.DEXREWARD50)){return true;}
        else if (slot == 2 && stack.isOf(ModItems.DEXREWARD75)){return true;}
        else if (slot == 3 && stack.isOf(ModItems.DEXREWARD100)){return true;}
        else if (slot == 4 && stack.isOf(ModItems.DEXREWARDKANTO)){return true;}
        else if (slot == 5 && stack.isOf(ModItems.DEXREWARDJOHTO)){return true;}
        else if (slot == 6 && stack.isOf(ModItems.DEXREWARDHOENN)){return true;}
        else if (slot == 7 && stack.isOf(ModItems.DEXREWARDSINNOH)){return true;}
        else if (slot == 8 && stack.isOf(ModItems.DEXREWARDUNOVA)){return true;}
        else if (slot == 9 && stack.isOf(ModItems.DEXREWARDKALOS)){return true;}
        else if (slot == 10 && stack.isOf(ModItems.DEXREWARDALOLA)){return true;}
        else if (slot == 11 && stack.isOf(ModItems.DEXREWARDGALAR)){return true;}
        else if (slot == 12 && stack.isOf(ModItems.DEXREWARDPALDEA)){return true;}
        else{return false;}
    }

    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt();
    }



    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void markDirty() {
        world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        super.markDirty();
    }

    @Override
    public void readNbt(NbtCompound nbt) {
     super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
       for(int i = 1; i <= 13; i++) {
           if (tokenMutable.get(i) != tokenList.get(i)) {
               tokenMutable.set(i, nbt.getBoolean(tokenNames.get(i)));
           }else{
               tokenMutable.set(i, tokenList.get(i));
           }
       }
    }


    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        for (int i = 0; i <= 13; i++){
            nbt.putBoolean(tokenNames.get(i), tokenMutable.get(i));
        }

    }

}
