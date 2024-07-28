package net.donut.dexrewards.block.custom;

import com.google.common.collect.Lists;
import net.donut.dexrewards.registry.ModRegistries;
import net.donut.dexrewards.item.custom.MapToken;
import net.donut.dexrewards.item.custom.MapTokens;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Nameable;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DexMapBlockEntity extends BlockEntity implements Nameable {
    public static final String TOKENS_KEY = "Tokens";
    public static final String TOKEN_KEY = "Pattern";
    @Nullable
    private Text customName;
    @Nullable
    private NbtList tokenListNbt;
    @Nullable
    private List<RegistryEntry<MapToken>> tokens;

    public DexMapBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.DEX_MAP, pos, state);
    }

    public DexMapBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }



    @Nullable
    public static NbtList getTokenListNbt(ItemStack stack) {
        NbtList nbtList = null;
        NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);
        if (nbtCompound != null && nbtCompound.contains("Tokens", 14)) {
            nbtList = nbtCompound.getList("Tokens", 14).copy();
        }

        return nbtList;
    }

    public void readFrom(ItemStack stack) {
        this.tokenListNbt = getTokenListNbt(stack);
        this.tokens = null;
        this.customName = stack.hasCustomName() ? stack.getName() : null;
    }

    public Text getName() {
        return (Text)(this.customName != null ? this.customName : Text.translatable("block.minecraft.token"));
    }

    @Nullable
    public Text getCustomName() {
        return this.customName;
    }

    public void setCustomName(Text customName) {
        this.customName = customName;
    }

    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        if (this.tokenListNbt != null) {
            nbt.put("Tokens", this.tokenListNbt);
        }

        if (this.customName != null) {
            nbt.putString("CustomName", Text.Serializer.toJson(this.customName));
        }

    }

    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        if (nbt.contains("CustomName", 15)) {
            this.customName = Text.Serializer.fromJson(nbt.getString("CustomName"));
        }

        this.tokenListNbt = nbt.getList("Tokens", 14);
        this.tokens = null;
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    public NbtCompound toInitialChunkDataNbt() {
        return this.createNbt();
    }

    public static int getTokenCount(ItemStack stack) {
        NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);
        return nbtCompound != null && nbtCompound.contains("Tokens") ? nbtCompound.getList("Tokens", 14).size() : 0;
    }

    public  List<RegistryEntry<MapToken>> getTokens() {
        if (tokens == null) {
            tokens = getTokensFromNbt(tokenListNbt);
        }

        return tokens;
    }

    public static List<RegistryEntry<MapToken>> getTokensFromNbt(@Nullable NbtList tokenListNbt) {
        List<RegistryEntry<MapToken>> list = Lists.newArrayList();
        list.add(ModRegistries.MAP_TOKEN.entryOf(MapTokens.BASE));
        if (tokenListNbt != null) {
            for(int i = 0; i < tokenListNbt.size(); ++i) {
                NbtCompound nbtCompound = tokenListNbt.getCompound(i);
                @Nullable RegistryEntry<MapToken> registryEntry = MapToken.byId(nbtCompound.getString("Pattern"));
                if (registryEntry != null) {
                    list.add(registryEntry);
                }
            }
        }

        return list;
    }

    public static void loadFromItemStack(ItemStack stack) {
        NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);
        if (nbtCompound != null && nbtCompound.contains("Patterns", 9)) {
            NbtList nbtList = nbtCompound.getList("Patterns", 10);
            if (!nbtList.isEmpty()) {
                nbtList.remove(nbtList.size() - 1);
                if (nbtList.isEmpty()) {
                    nbtCompound.remove("Patterns");
                }

                BlockItem.setBlockEntityNbt(stack, BlockEntityType.BANNER, nbtCompound);
            }
        }
    }

}
