package net.donut.dexrewards.block.entity.renderer;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.systems.RenderSystem;
import net.donut.dexrewards.DexRewards;
import net.donut.dexrewards.block.entity.DexMapBlockEntity;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

import java.util.*;

//public class DexMapBlockRenderer implements BlockEntityRenderer<DexMapBlockEntity> {
//    public DexMapBlockRenderer(BlockEntityRendererFactory.Context ctx) {
//
//    }
//
//    public static final Identifier DEX_MAP_ATLAS_TEXTURE = new Identifier(DexRewards.MOD_ID, "textures/atlas/dex_map.png");
//    public static final RenderLayer DEX_MAP_RENDER_LAYER;
//    //(Collectors.toMap(Function.identity(), TexturedRenderLayers::createBannerPatternTextureId));
//    static {
//        DEX_MAP_RENDER_LAYER = RenderLayer.getEntityCutout(DEX_MAP_ATLAS_TEXTURE);
//    }
//
//    private static final Map<TokenLayer, Identifier> TEXTURES = Util.make(Maps.newEnumMap(TokenLayer.class), map -> {
//        map.put(TokenLayer.DEX_BASE, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex_map_block.png"));
//        map.put(TokenLayer.DEX_25, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//        map.put(TokenLayer.DEX_50, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//        map.put(TokenLayer.DEX_75, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//        map.put(TokenLayer.DEX_100, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//        map.put(TokenLayer.KANTO, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//        map.put(TokenLayer.JOHTO, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//        map.put(TokenLayer.HOENN, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//        map.put(TokenLayer.SINNOH, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//        map.put(TokenLayer.UNOVA, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//        map.put(TokenLayer.KALOS, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//        map.put(TokenLayer.ALOLA, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//        map.put(TokenLayer.GALAR, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//        map.put(TokenLayer.PALDEA, new Identifier(DexRewards.MOD_ID, "textures/entity/dex_map/dex25_ribbon.png"));
//    });
//    private static final List<TokenLayer> token = List.of(TokenLayer.DEX_BASE, TokenLayer.DEX_25, TokenLayer.DEX_50, TokenLayer.DEX_75, TokenLayer.DEX_100,
//    TokenLayer.KANTO, TokenLayer.JOHTO, TokenLayer.HOENN, TokenLayer.SINNOH, TokenLayer.UNOVA, TokenLayer.KALOS, TokenLayer.ALOLA, TokenLayer.GALAR, TokenLayer.PALDEA);
//
//
//    @Override
//    public void render(DexMapBlockEntity entity, float tickDelta, MatrixStack matrices,
//                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
//        DexMapBlockEntity map = (DexMapBlockEntity) entity;
//        map.markDirty();
//        NbtCompound nbt = map.nbt;
//        BlockPos pos = entity.getPos();
//        boolean bl = entity.getWorld() == null;
//        long l;
//        List<Boolean> states = List.of();
//
//        if (bl){l = 0L;for(int i = 0; i <= 13; i++){states.set(i, false);}}
//        else {
//            states = entity.getRenderState(nbt);
//            l = map.getWorld().getTime();
//        }
//        float h;
//
//        matrices.push();
//        Matrix4f positionMatrix = matrices.peek().getPositionMatrix();
//        Tessellator tesselator = Tessellator.getInstance();
//        BufferBuilder buffer = tesselator.getBuffer();
//        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//        buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//        buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//        buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//        buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
//        RenderSystem.setShaderTexture(0, TEXTURES.get(token.get(0)));
//        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//        RenderSystem.disableCull();
//        RenderSystem.depthFunc(GL11.GL_ALWAYS);
//        RenderSystem.depthFunc(GL11.GL_EQUAL);
//        RenderSystem.enableCull();
//
//            if(states.get(1)) {
//                RenderSystem.setShaderTexture(1, TEXTURES.get(token.get(1)));
//                buffer.end();matrices.push();
//                buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//                buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//                buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//                buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//                buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//                RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//                RenderSystem.disableCull();
//                RenderSystem.depthFunc(GL11.GL_ALWAYS);
//                RenderSystem.depthFunc(GL11.GL_EQUAL);
//                RenderSystem.enableCull();
//                tesselator.draw();
//            }
//            if(states.get(2)) {
//                RenderSystem.setShaderTexture(2, TEXTURES.get(token.get(2)));
//                buffer.end();matrices.push();
//                buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//                buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//                buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//                buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//                buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//                RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//                RenderSystem.disableCull();
//                RenderSystem.depthFunc(GL11.GL_ALWAYS);
//                RenderSystem.depthFunc(GL11.GL_EQUAL);
//                RenderSystem.enableCull();
//                tesselator.draw();
//            }
//        if(states.get(3)) {
//            RenderSystem.setShaderTexture(3, TEXTURES.get(token.get(3)));
//            buffer.end();matrices.push();
//            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//            buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//            buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//            RenderSystem.disableCull();
//            RenderSystem.depthFunc(GL11.GL_ALWAYS);
//            RenderSystem.depthFunc(GL11.GL_EQUAL);
//            RenderSystem.enableCull();
//        }
//        if(states.get(4)) {
//            RenderSystem.setShaderTexture(4, TEXTURES.get(token.get(4)));
//            buffer.end();matrices.push();
//            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//            buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//            buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//            RenderSystem.disableCull();
//            RenderSystem.depthFunc(GL11.GL_ALWAYS);
//            RenderSystem.depthFunc(GL11.GL_EQUAL);
//            RenderSystem.enableCull();
//            matrices.pop();
//        }
//        if(states.get(5)) {
//            RenderSystem.setShaderTexture(5, TEXTURES.get(token.get(5)));
//            buffer.end();matrices.push();
//            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//            buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//            buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//            RenderSystem.disableCull();
//            RenderSystem.depthFunc(GL11.GL_ALWAYS);
//            RenderSystem.depthFunc(GL11.GL_EQUAL);
//            RenderSystem.enableCull();
//        }
//        if(states.get(6)) {
//            RenderSystem.setShaderTexture(6, TEXTURES.get(token.get(6)));
//            buffer.end();matrices.push();
//            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//            buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//            buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//            RenderSystem.disableCull();
//            RenderSystem.depthFunc(GL11.GL_ALWAYS);
//            RenderSystem.depthFunc(GL11.GL_EQUAL);
//            RenderSystem.enableCull();
//        }
//        if(states.get(7)) {
//            RenderSystem.setShaderTexture(7, TEXTURES.get(token.get(7)));
//            buffer.end();matrices.push();
//            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//            buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//            buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//            RenderSystem.disableCull();
//            RenderSystem.depthFunc(GL11.GL_ALWAYS);
//            RenderSystem.depthFunc(GL11.GL_EQUAL);
//            RenderSystem.enableCull();
//        }
//        if(states.get(8)) {
//            RenderSystem.setShaderTexture(8, TEXTURES.get(token.get(8)));
//            buffer.end();matrices.push();
//            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//            buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//            buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//            RenderSystem.disableCull();
//            RenderSystem.depthFunc(GL11.GL_ALWAYS);
//            RenderSystem.depthFunc(GL11.GL_EQUAL);
//            RenderSystem.enableCull();
//        }
//        if(states.get(9)) {
//            RenderSystem.setShaderTexture(9, TEXTURES.get(token.get(9)));
//            buffer.end();matrices.push();
//            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//            buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//            buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//            RenderSystem.disableCull();
//            RenderSystem.depthFunc(GL11.GL_ALWAYS);
//            RenderSystem.depthFunc(GL11.GL_EQUAL);
//            RenderSystem.enableCull();
//        }
//        if(states.get(10)) {
//            RenderSystem.setShaderTexture(10, TEXTURES.get(token.get(10)));
//            buffer.end();matrices.push();
//            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//            buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//            buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//            RenderSystem.disableCull();
//            RenderSystem.depthFunc(GL11.GL_ALWAYS);
//            RenderSystem.depthFunc(GL11.GL_EQUAL);
//            RenderSystem.enableCull();
//        }
//        if(states.get(11)) {
//            RenderSystem.setShaderTexture(11, TEXTURES.get(token.get(11)));
//            buffer.end();matrices.push();
//            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//            buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//            buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//            RenderSystem.disableCull();
//            RenderSystem.depthFunc(GL11.GL_ALWAYS);
//            RenderSystem.depthFunc(GL11.GL_EQUAL);
//            RenderSystem.enableCull();
//        }
//        if(states.get(12)) {
//            RenderSystem.setShaderTexture(12, TEXTURES.get(token.get(12)));
//            buffer.end();matrices.push();
//            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//            buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//            buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//            RenderSystem.disableCull();
//            RenderSystem.depthFunc(GL11.GL_ALWAYS);
//            RenderSystem.depthFunc(GL11.GL_EQUAL);
//            RenderSystem.enableCull();
//        }
//        if(states.get(13)) {
//            matrices.pop();
//            RenderSystem.setShaderTexture(13, TEXTURES.get(token.get(13)));
//            buffer.end();matrices.push();
//            buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
//            buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
//            buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
//            buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
//            RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
//            RenderSystem.disableCull();
//            RenderSystem.depthFunc(GL11.GL_ALWAYS);
//            RenderSystem.depthFunc(GL11.GL_EQUAL);
//            RenderSystem.enableCull();
//        }
//        tesselator.draw();
//        matrices.pop();
//
//    }




//}
