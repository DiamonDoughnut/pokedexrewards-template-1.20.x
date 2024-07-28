package net.donut.dexrewards.util;

import net.donut.dexrewards.item.custom.MapToken;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mutable;

import java.util.List;

public class DexBlockNBTAssist {
    @Mutable
    NbtList tokenListNbt = new NbtList();
    @Nullable
    List<RegistryEntry<MapToken>> tokens = List.of();
    @Nullable
    static Text customName = null;

    @Nullable
    public NbtList getTokenListNbt(ItemStack stack) {
        NbtList nbtList = null;
        NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);
        if (nbtCompound != null && nbtCompound.contains("Tokens", 14)) {
            nbtList = nbtCompound.getList("Tokens", 14).copy();
        }
        return nbtList;


    }
    public DexBlockNBTAssist(ItemStack stack){
        this.tokenListNbt = getTokenListNbt(stack);
        this.tokens = null;
        customName = stack.hasCustomName() ? stack.getName() : null;
    }

    public static void setCustomName(Text Name) {
        customName = Name;
    }



}
