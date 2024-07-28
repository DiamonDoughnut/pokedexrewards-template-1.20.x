package net.donut.dexrewards.client.render.block.entity;

import com.mojang.datafixers.util.Pair;
import net.donut.dexrewards.block.custom.DexMapBlock;
import net.donut.dexrewards.block.custom.DexMapBlockEntity;
import net.donut.dexrewards.datagen.ModModelProvider;
import net.donut.dexrewards.item.custom.MapToken;
import net.donut.dexrewards.item.custom.MapTokens;
import net.donut.dexrewards.registry.ModRegistries;
import net.donut.dexrewards.util.DexBlockNBTAssist;
import net.donut.dexrewards.util.ModResourceFinder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BannerPattern;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.data.client.TextureMap;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceFinder;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourcePack;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Environment(EnvType.CLIENT)
public class DexMapEntityRenderer implements BlockEntityRenderer<DexMapBlockEntity> {
    BlockEntityRendererFactory.Context context;

    public DexMapEntityRenderer(BlockEntityRendererFactory.Context ctx){
        this.context = ctx;
    }



    public ResourceManager manager = new ResourceManager() {
        @Override
        public Set<String> getAllNamespaces() {
            return Set.of();
        }

        @Override
        public List<Resource> getAllResources(Identifier id) {
            return List.of();
        }

        @Override
        public Map<Identifier, Resource> findResources(String startingPath, Predicate<Identifier> allowedPathPredicate) {
            return Map.of();
        }

        @Override
        public Map<Identifier, List<Resource>> findAllResources(String startingPath, Predicate<Identifier> allowedPathPredicate) {
            return Map.of();
        }

        @Override
        public Stream<ResourcePack> streamResourcePacks() {
            return Stream.empty();
        }

        @Override
        public Optional<Resource> getResource(Identifier id) {
            return Optional.empty();
        }
    };
    @Override
    public void render(DexMapBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        List<RegistryEntry<MapToken>> tokens = entity.getTokens();
        boolean bl = entity.getWorld() == null;
        long l;
        if(bl){
            l = 0l;
        }else{
            l = entity.getWorld().getTime();
            BlockState blockState = entity.getCachedState();
        }
        matrices.push();

        BlockPos pos = entity.getPos();




    }


    public void renderMap(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, ModelPart main, SpriteIdentifier baseSprite, boolean isMap, List<RegistryEntry<MapToken>> tokens) {
        renderMap(matrices, vertexConsumers, light, overlay, main, baseSprite, isMap, tokens, false);
    }

    public void renderMap(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, ModelPart main, SpriteIdentifier baseSprite, boolean isMap, List<RegistryEntry<MapToken>> tokens, boolean glint) {
        main.render(matrices, baseSprite.getVertexConsumer(vertexConsumers, RenderLayer::getEntitySolid, glint), light, overlay);

        for(int i = 0; i < 17 && i < tokens.size(); ++i) {
            main.render(matrices, baseSprite.getVertexConsumer(vertexConsumers, RenderLayer::getEntityNoOutline, glint), light, overlay );
            RegistryEntry<MapToken> token = tokens.get(i);
               token.getKey().map(ModRegistries::getMapPatternTextureId).ifPresent(sprite -> main.render(matrices, sprite.getVertexConsumer(vertexConsumers, RenderLayer::getEntityNoOutline), light, overlay));
            }
        }

    }


