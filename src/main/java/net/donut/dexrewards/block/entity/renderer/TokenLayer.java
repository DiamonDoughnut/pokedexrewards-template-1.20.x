package net.donut.dexrewards.block.entity.renderer;

import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;

import java.util.function.IntFunction;

public enum TokenLayer implements StringIdentifiable {
    DEX_BASE(0, "base"),
    DEX_25(1, "dex_25"),
    DEX_50(2, "dex_50"),
    DEX_75(3, "dex_75"),
    DEX_100(4, "dex_100"),
    KANTO(5, "kanto"),
    JOHTO(6, "johto"),
    HOENN(7, "hoenn"),
    SINNOH(8, "sinnoh"),
    UNOVA(9, "unova"),
    KALOS(10, "kalos"),
    ALOLA(11, "alola"),
    GALAR(12, "galar"),
    PALDEA(13, "paldea");

    public static final Codec<TokenLayer> CODEC = StringIdentifiable.createCodec(TokenLayer::values);
    private static final IntFunction<TokenLayer> BY_ID = ValueLists.createIdToValueFunction(TokenLayer::getId, values(), ValueLists.OutOfBoundsHandling.WRAP);
    private final int id;
    private final String name;

    private TokenLayer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public static TokenLayer byId(int id) {
        return (TokenLayer)BY_ID.apply(id);
    }

    public String asString() {
        return this.name;
    }
}

