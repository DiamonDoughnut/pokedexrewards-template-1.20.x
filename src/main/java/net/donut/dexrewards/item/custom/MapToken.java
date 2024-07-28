package net.donut.dexrewards.item.custom;

import com.google.common.collect.Lists;
import net.donut.dexrewards.registry.ModRegistries;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Iterator;
import java.util.List;

public class MapToken {
    final String id;

    public MapToken(String id) {
        this.id = id;
    }

    public static Identifier getSpriteId(RegistryKey<MapToken> token, boolean banner) {
        String string = banner ? "banner" : "shield";
        return token.getValue().withPrefixedPath("entity/" + string + "/");
    }

    public String getId() {
        return this.id;
    }

    @Nullable
    public static RegistryEntry<MapToken> byId(String id) {
        return (RegistryEntry) ModRegistries.MAP_TOKEN.streamEntries().filter((pattern) -> {
            return ((MapToken)pattern.value()).id.equals(id);
        }).findAny().orElse((RegistryEntry.Reference<MapToken>) null);
    }

    public static class Tokens {
        private final List<RegistryEntry<MapToken>> entries = Lists.newArrayList();

        public Tokens() {
        }

        public MapToken.Tokens add(RegistryKey<MapToken> token) {
            return this.add((RegistryEntry)ModRegistries.MAP_TOKEN.entryOf(token));
        }

        public MapToken.Tokens add(RegistryEntry<MapToken> token) {
            this.entries.add(token);
            return this;
        }

        public NbtList toNbt() {
            NbtList nbtList = new NbtList();
            Iterator var2 = this.entries.iterator();

            while(var2.hasNext()) {
                RegistryEntry<MapToken> tokenCheck = (RegistryEntry<MapToken>) var2.next();
                NbtCompound nbtCompound = new NbtCompound();
                nbtCompound.putString("Token", tokenCheck.value().id);
                nbtList.add(nbtCompound);
            }

            return nbtList;
        }

    }
}
