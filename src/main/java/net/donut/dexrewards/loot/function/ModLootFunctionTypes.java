package net.donut.dexrewards.loot.function;

import net.minecraft.loot.function.LootFunction;
import net.minecraft.loot.function.LootFunctionType;
import net.minecraft.loot.function.LootFunctionTypes;
import net.minecraft.loot.function.SetBannerPatternFunction;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonSerializer;

public class ModLootFunctionTypes {
    public static final LootFunctionType SET_TOKEN_PATTERN = register("set_banner_pattern", new SetMapTokenFunction.Serializer());

    private static LootFunctionType register(String id, JsonSerializer<? extends LootFunction> jsonSerializer) {
        return (LootFunctionType) Registry.register(Registries.LOOT_FUNCTION_TYPE, new Identifier(id), new LootFunctionType(jsonSerializer));
    }
}
