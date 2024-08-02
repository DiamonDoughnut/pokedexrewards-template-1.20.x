package net.donut.dexrewards.block.entity;

import net.donut.dexrewards.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DexMapBlockEntity extends BlockEntity implements ImplementedInventory {

    private final DefaultedList<ItemStack> inventory =  DefaultedList.ofSize(13, ItemStack.EMPTY);
    public final Item[] list = {ModItems.DEXREWARD25, ModItems.DEXREWARD50, ModItems.DEXREWARD75, ModItems.DEXREWARD100,
    ModItems.DEXREWARDKANTO, ModItems.DEXREWARDJOHTO, ModItems.DEXREWARDHOENN, ModItems.DEXREWARDSINNOH,
    ModItems.DEXREWARDUNOVA, ModItems.DEXREWARDKALOS, ModItems.DEXREWARDALOLA, ModItems.DEXREWARDGALAR, ModItems.DEXREWARDPALDEA};

    public DexMapBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.DEX_MAP_BLOCK_ENTITY, pos, state);

    }

    public DefaultedList<ItemStack> getInventory() {
        return inventory;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        ImplementedInventory.super.setStack(slot, stack);
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction side) {
        for(int i = 0; i <= 12; i++){
            if(slot == i && stack.isOf(list[i])){return true;}
        }
        return false;
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public void modifyInventory(int slot, ItemStack stack){
        this.syncedInventoryModification(inventory -> setStack(slot, stack));
    }

    public void syncedInventoryModification(Consumer<DefaultedList<ItemStack>> inventoryConsumer){
        inventoryConsumer.accept(this.inventory);
        if(this.getWorld() instanceof ServerWorld serverWorld) {
            serverWorld.getChunkManager().markForUpdate(this.pos);
        }
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
     Inventories.readNbt(nbt, this.inventory);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public ItemStack getStack(int slot) {
        return ImplementedInventory.super.getStack(slot);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, this.inventory);
    }

}
