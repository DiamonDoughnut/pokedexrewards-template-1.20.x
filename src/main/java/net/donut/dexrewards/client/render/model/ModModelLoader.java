package net.donut.dexrewards.client.render.model;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.donut.dexrewards.item.custom.MapToken;
import net.donut.dexrewards.registry.ModRegistries;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.registry.RegistryKey;
import net.minecraft.resource.ResourceFinder;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;
import java.util.function.Consumer;

@Environment(EnvType.CLIENT)
public class ModModelLoader {
    public static SpriteIdentifier DEX_MAP_BASE;
    public static Map<RegistryKey<MapToken>, SpriteIdentifier> MAP_TOKEN_TEXTURES;
    public static ResourceFinder BLOCK_STATES_FINDER;
    public static RenderLayer MAP_TOKEN_RENDER_LAYER;
    private final Object2IntMap<BlockState> stateLookup = (Object2IntMap) Util.make(new Object2IntOpenHashMap(), (map) -> {
        map.defaultReturnValue(-1);
    });


    public static RenderLayer getMapTokens() {return MAP_TOKEN_RENDER_LAYER;}

    public static void addDefaultTextures(Consumer<SpriteIdentifier> adder) {
        MAP_TOKEN_TEXTURES.values().forEach(adder);
    }

    public Object2IntMap<BlockState> getStateLookup() {
        return this.stateLookup;
    }


    static {
        DEX_MAP_BASE = new SpriteIdentifier(ModRegistries.MAP_TOKEN_ATLAS_TEXTURE, new Identifier("block/entity/dex_map_base"));

    }
}
