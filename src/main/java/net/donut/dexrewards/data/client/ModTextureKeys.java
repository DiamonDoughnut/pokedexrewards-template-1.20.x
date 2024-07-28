package net.donut.dexrewards.data.client;

import com.eliotlash.mclib.math.functions.classic.Mod;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class ModTextureKeys {
    public static final TextureKey DEX_MAP = TextureKey.of("dex_map");
    private final String name;
    @Nullable
    private final TextureKey parent;
    public static final TextureMap dex_map = new TextureMap().register(DEX_MAP, new Identifier("dex_map", "dexrewards/textures/mapatlas"));

    public static ModTextureKeys of(String name) {
        return new ModTextureKeys(name, null);
    }

    public static ModTextureKeys of(String name, TextureKey parent) {
        return new ModTextureKeys(name, parent);
    }

    private ModTextureKeys(String name, @Nullable TextureKey parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public TextureKey getParent() {
        return this.parent;
    }

    public String toString() {
        return "#" + this.name;
    }


}
