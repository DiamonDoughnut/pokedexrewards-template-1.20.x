package net.donut.dexrewards.block.entity;

import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.Iterator;
import java.util.List;

public class MapToken {
    final String id;
    public MapToken(String id) {this.id = id;}
    public static Identifier getSpriteId(RegistryKey<Item> token) {
        return token.getValue().withPrefixedPath("entity/dex_map/");
    }
    public String getId(){return this.id;}
    public static class Tokens{
        private final List<RegistryEntry<MapToken>> entries = Lists.newArrayList();
        public Tokens(){}
        public Tokens add(RegistryKey<Item> token){
            return this.add((RegistryEntry) Registries.ITEM.entryOf(token));
        }
        public Tokens add(RegistryEntry<MapToken> pattern) {
            this.entries.add(pattern);
            return this;
        }
        public NbtList toNbt(){
            NbtList list = new NbtList();
            Iterator var2 = this.entries.iterator();

            while(var2.hasNext()){
                RegistryEntry<MapToken> token = (RegistryEntry<MapToken>) var2.next();
                NbtCompound compound = new NbtCompound();
                compound.putString("Token", token.value().id);
                list.add(compound);
            }
            return list;
        }
    }
}
