package net.donut.dexrewards.loot.function;

import com.google.common.collect.ImmutableList;
import com.google.gson.*;
import net.donut.dexrewards.block.custom.ModBlockEntityType;
import net.donut.dexrewards.item.ModItems;
import net.donut.dexrewards.item.custom.MapToken;
import net.donut.dexrewards.registry.ModRegistries;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.function.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SetMapTokenFunction extends ConditionalLootFunction {
    final List<RegistryEntry<MapToken>> tokens;
    final boolean append;

    SetMapTokenFunction(LootCondition[] conditions, List<RegistryEntry<MapToken>> tokens, boolean append) {
        super(conditions);
        this.tokens = tokens;
        this.append = append;
    }

    protected ItemStack process(ItemStack stack, LootContext context) {
        NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);
        if (nbtCompound == null) {
            nbtCompound = new NbtCompound();
        }

        MapToken.Tokens tokens = new MapToken.Tokens();
        List<RegistryEntry<MapToken>> var10000 = this.tokens;
        Objects.requireNonNull(tokens);
        var10000.forEach(tokens::add);
        NbtList nbtList = tokens.toNbt();
        NbtList nbtList2;
        if (this.append) {
            nbtList2 = nbtCompound.getList("Tokens", 10).copy();
            nbtList2.addAll(nbtList);
        } else {
            nbtList2 = nbtList;
        }

        nbtCompound.put("Tokens", nbtList2);
        BlockItem.setBlockEntityNbt(stack, ModBlockEntityType.DEX_MAP, nbtCompound);
        return stack;
    }

    public LootFunctionType getType() {
        return ModLootFunctionTypes.SET_TOKEN_PATTERN;
    }

    public static SetMapTokenFunction.Builder builder(boolean append) {
        return new SetMapTokenFunction.Builder(append);
    }

    public static class Builder extends ConditionalLootFunction.Builder<SetMapTokenFunction.Builder> {
        private final ImmutableList.Builder<RegistryEntry<MapToken>> tokens = ImmutableList.builder();
        private final boolean append;

        Builder(boolean append) {
            this.append = append;
        }

        protected SetMapTokenFunction.Builder getThisBuilder() {
            return this;
        }

        public LootFunction build() {
            return new SetMapTokenFunction(this.getConditions(), this.tokens.build(), this.append);
        }

        public SetMapTokenFunction.Builder token(RegistryKey<MapToken> token) {
            return this.token((RegistryEntry) ModRegistries.MAP_TOKEN.entryOf(token));
        }

        public SetMapTokenFunction.Builder token(RegistryEntry<MapToken> token) {
            this.tokens.add(token);
            return this;
        }
    }

    public static class Serializer extends ConditionalLootFunction.Serializer<SetMapTokenFunction> {
        public Serializer() {
        }

        public void toJson(JsonObject jsonObject1, SetMapTokenFunction setMapTokenFunction, JsonSerializationContext jsonSerializationContext) {
            super.toJson(jsonObject1, setMapTokenFunction, jsonSerializationContext);
            JsonArray jsonArray = new JsonArray();
            setMapTokenFunction.tokens.forEach(RegistryEntry -> {
                JsonObject jsonObject = new JsonObject();
                String key = RegistryEntry.value().getId();
                    jsonObject.addProperty("token", key);


                jsonArray.add(jsonObject);
            });
            jsonObject1.add("tokens", jsonArray);
            jsonObject1.addProperty("append", setMapTokenFunction.append);
        }

        public SetMapTokenFunction fromJson(JsonObject jsonObject, JsonDeserializationContext jsonDeserializationContext, LootCondition[] lootConditions) {
            ImmutableList.Builder<RegistryEntry<MapToken>> builder = ImmutableList.builder();
            JsonArray jsonArray = JsonHelper.getArray(jsonObject, "tokens");

            for(int i = 0; i < jsonArray.size(); ++i) {
                JsonObject jsonObject2 = JsonHelper.asObject(jsonArray.get(i), "token[" + i + "]");
                String string = JsonHelper.getString(jsonObject2, "token");
                Optional<? extends RegistryEntry<MapToken>> optional = ModRegistries.MAP_TOKEN.getEntry(RegistryKey.of(ModItems.MAP_TOKEN, new Identifier(string)));
                if (optional.isEmpty()) {
                    throw new JsonSyntaxException("Unknown token: " + string);
                }



                builder.add((RegistryEntry)optional.get());
            }

            boolean bl = JsonHelper.getBoolean(jsonObject, "append");
            return new SetMapTokenFunction(lootConditions, builder.build(), bl);
        }
    }
}