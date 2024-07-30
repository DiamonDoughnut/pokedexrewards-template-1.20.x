package net.donut.dexrewards.block.entities.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import net.donut.dexrewards.DexRewards;
import net.donut.dexrewards.block.custom.DexMapBlock;
import net.donut.dexrewards.block.entities.DexMapBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import org.joml.Matrix4f;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static net.donut.dexrewards.block.custom.DexMapBlock.*;

public class DexMapBlockRenderer implements BlockEntityRenderer<DexMapBlockEntity> {
    public DexMapBlockRenderer(BlockEntityRendererFactory.Context ctx) {

    }


    @Override
    public void render(DexMapBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        DexMapBlockEntity map = (DexMapBlockEntity) entity;
        NbtCompound nbt = map.nbt;

        List<String> pathlist = List.of("dex25_ribbon", "dex50_ribbon", "dex75_ribbon", "dex100_ribbon",
                "kanto_stamp", "johto_stamp", "hoenn_stamp", "sinnoh_stamp", "unova_stamp", "kalos_stamp",
                "alola_stamp", "galar_stamp", "paldea_stamp");

        boolean bl = entity.getWorld() == null;
        long l;
        List<Boolean> states = List.of();

        if (bl){l = 0L;for(int i = 0; i <= 12; i++){states.set(i, false);}}
        else {
            l = map.getWorld().getTime();
            states = entity.getRenderState(nbt);
        }
        matrices.push();

        BlockPos pos = entity.getPos();

        Matrix4f positionMatrix = matrices.peek().getPositionMatrix();
        Tessellator tesselator = Tessellator.getInstance();
        BufferBuilder buffer = tesselator.getBuffer();

        for(int i = 0; i <=12; i++){
            String path = pathlist.get(i);

            boolean state = states.get(i);
            if(state){
                buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);

                buffer.vertex(positionMatrix, 0, 1, 0).texture(0f, 0f).next();
                buffer.vertex(positionMatrix, 0, 0, 0).texture(0f, 1f).next();
                buffer.vertex(positionMatrix, 1, 0, 0).texture(1f, 1f).next();
                buffer.vertex(positionMatrix, 1, 1, 0).texture(1f, 0f).next();
                RenderSystem.setShader(GameRenderer::getPositionTexProgram);
                RenderSystem.setShaderTexture(i, new Identifier(DexRewards.MOD_ID, path));
                RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
                RenderSystem.disableCull();
                RenderSystem.depthFunc(GL11.GL_ALWAYS);
                if(i<12) {buffer.end();}
            }
            if(i == 12){tesselator.draw();}
        }
        RenderSystem.depthFunc(GL11.GL_EQUAL);
        RenderSystem.enableCull();
        matrices.pop();

    }


}
