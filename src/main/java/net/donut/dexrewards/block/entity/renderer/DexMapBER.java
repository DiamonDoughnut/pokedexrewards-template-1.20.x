package net.donut.dexrewards.block.entity.renderer;

import net.donut.dexrewards.block.custom.DexMapBlock;
import net.donut.dexrewards.block.entity.DexMapBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class DexMapBER implements BlockEntityRenderer<DexMapBlockEntity> {
    public DexMapBER(BlockEntityRendererFactory.Context ctx){

    }

    @Override
    public void render(DexMapBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack slot0 = entity.getStack(0);
        ItemStack slot1 = entity.getStack(1);
        ItemStack slot2 = entity.getStack(2);
        ItemStack slot3 = entity.getStack(3);
        ItemStack slot4 = entity.getStack(4);
        ItemStack slot5 = entity.getStack(5);
        ItemStack slot6 = entity.getStack(6);
        ItemStack slot7 = entity.getStack(7);
        ItemStack slot8 = entity.getStack(8);
        ItemStack slot9 = entity.getStack(9);
        ItemStack slot10 = entity.getStack(10);
        ItemStack slot11 = entity.getStack(11);
        ItemStack slot12 = entity.getStack(12);
        int ROTATION;

        BlockState state = entity.getCachedState();
        Direction direction = state.get(HorizontalFacingBlock.FACING);

        //working out NORTH FACING
        matrices.push();
        if(direction.equals(Direction.EAST)){
            matrices.translate(0.07f, 0.21f, 1.41f);
            matrices.scale(0.35f, 0.4f, 0.3f);
        } else if (direction.equals(Direction.WEST)) {
            matrices.translate(0.93f, 0.21f, -0.41f);
            matrices.scale(0.35f, 0.4f, 0.3f);
        } else if (direction.equals(Direction.SOUTH)){
            matrices.translate(-0.41f, 0.21f, 0.07f);
            matrices.scale(0.3f, 0.4f, 0.35f);
        } else {
            matrices.translate(1.41f, 0.21f, 0.93f);
            matrices.scale(0.3f, 0.4f, 0.35f);
        }
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot0, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        //Working out WEST FACING
        matrices.push();
        if(direction.equals(Direction.EAST)){
            matrices.translate(0.07f, 0.21f, 0.829f);
            matrices.scale(0.35f, 0.37f, 0.3f);
        } else if (direction.equals(Direction.WEST)) {
            matrices.translate(0.93f, 0.21f, 0.171f);
            matrices.scale(0.35f, 0.37f, 0.3f);
        } else if (direction.equals(Direction.SOUTH)){
            matrices.translate(0.171f, 0.21f, 0.07f);
            matrices.scale(0.3f, 0.37f, 0.35f);
        } else {
            matrices.translate(0.829f, 0.21f, 0.93f);
            matrices.scale(0.3f, 0.37f, 0.35f);
        }
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot1, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        //working out SOUTH FACING
        matrices.push();
        if(direction.equals(Direction.EAST)){
            matrices.translate(0.07f, 0.23f, 0.238f);
            matrices.scale(0.35f, 0.43f, 0.3f);
        } else if (direction.equals(Direction.WEST)) {
            matrices.translate(0.93f, 0.23f, 0.762f);
            matrices.scale(0.35f, 0.43f, 0.3f);
        } else if (direction.equals(Direction.SOUTH)){
            matrices.translate(0.762f, 0.23f, 0.07f);
            matrices.scale(0.3f, 0.43f, 0.35f);
        } else {
            matrices.translate(0.238f, 0.23f, 0.93f);
            matrices.scale(0.3f, 0.43f, 0.35f);
        }
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot2, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        //working out EAST-FACING ROTATION
        matrices.push();
        if(direction.equals(Direction.EAST)){
            matrices.translate(0.07f, 0.23f, -0.353f);
            matrices.scale(0.35f, 0.46f, 0.3f);
        } else if (direction.equals(Direction.WEST)) {
            matrices.translate(0.93f, 0.23f, 1.353f);
            matrices.scale(0.35f, 0.46f, 0.3f);
        } else if (direction.equals(Direction.SOUTH)){
            matrices.translate(1.354f, 0.236f, 0.07f);
            matrices.scale(0.31f, 0.46f, 0.35f);
        } else {
            matrices.translate(-0.354f, 0.236f, 0.93f);
            matrices.scale(0.31f, 0.46f, 0.35f);
        }
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot3, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        matrices.push();
        if(direction.equals(Direction.EAST)){
            matrices.translate(0.07f, 1.0432f, 0.0382f);
            matrices.scale(0.35f, 0.31f, 0.388f);
        } else if (direction.equals(Direction.WEST)) {
            matrices.translate(0.93f, 1.0432f, 0.9618f);
            matrices.scale(0.35f, 0.31f, 0.388f);
        } else if (direction.equals(Direction.SOUTH)){
            matrices.translate(0.9618f, 1.0432f, 0.07f);
            matrices.scale(0.388f, 0.31f, 0.35f);
        } else {
            matrices.translate(0.0382f, 1.0432f, 0.93f);
            matrices.scale(0.388f, 0.31f, 0.35f);
        }
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot4, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        matrices.push();
        if(direction.equals(Direction.EAST)){
            matrices.translate(0.07f, 1.025f, 0.5f);
            matrices.scale(0.35f, 0.198f, 0.345f);
        } else if (direction.equals(Direction.WEST)) {
            matrices.translate(0.93f, 1.025f, 0.5f);
            matrices.scale(0.35f, 0.198f, 0.345f);
        } else if (direction.equals(Direction.SOUTH)){
            matrices.translate(0.5f, 1.025f, 0.07f);
            matrices.scale(0.345f, 0.198f, 0.35f);
        } else {
            matrices.translate(0.5f, 1.025f, 0.93f);
            matrices.scale(0.345f, 0.198f, 0.35f);
        }
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot5, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        matrices.push();
        if(direction.equals(Direction.EAST)){
            matrices.translate(0.07f, 0.506f, 0.092f);
            matrices.scale(0.35f, 0.215f, 0.2748f);
        } else if (direction.equals(Direction.WEST)) {
            matrices.translate(0.93f, 0.506f, 0.908f);
            matrices.scale(0.35f, 0.215f, 0.2748f);
        } else if (direction.equals(Direction.SOUTH)){
            matrices.translate(0.908f, 0.506f, 0.07f);
            matrices.scale(0.2748f, 0.215f, 0.35f);
        } else {
            matrices.translate(0.092f, 0.506f, 0.93f);
            matrices.scale(0.2748f, 0.215f, 0.35f);
        }
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot6, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        matrices.push();
        if(direction.equals(Direction.EAST)){
            matrices.translate(-0.28f, 1.096f, -0.566f);
            matrices.scale(0.7f, 0.683f, 0.733f);
        } else if (direction.equals(Direction.WEST)) {
            matrices.translate(0.571f, 1.096f, 0.827f);
            matrices.scale(0.7f, 0.683f, 0.745f);
        } else if (direction.equals(Direction.SOUTH)){
            matrices.translate(0.827f, 1.096f, -0.28f);
            matrices.scale(0.745f, 0.683f, 0.7f);
        } else {
            matrices.translate(-0.566f, 1.096f, 0.571f);
            matrices.scale(0.733f, 0.683f, 0.7f);
        }
        matrices.translate(0.5f, 0.5f, 0.5f);
        matrices.scale(0.35f, 0.35f, 0.35f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot7, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        matrices.push();
        if(direction.equals(Direction.EAST)){
            matrices.translate(0.07f, 0.78f, 0.8265f);
            matrices.scale(0.38f, 0.318f, 0.3065f);
        } else if (direction.equals(Direction.WEST)) {
            matrices.translate(0.93f, 0.78f, 0.1755f);
            matrices.scale(0.38f, 0.318f, 0.3065f);
        } else if (direction.equals(Direction.SOUTH)){
            matrices.translate(0.1755f, 0.78f, 0.07f);
            matrices.scale(0.3065f, 0.318f, 0.38f);
        } else {
            matrices.translate(0.8265f, 0.78f, 0.93f);
            matrices.scale(0.3065f, 0.318f, 0.38f);
        }
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot8, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        matrices.push();
        matrices.translate(0.5f, 0.5f, 0.5f);
        matrices.scale(0.35f, 0.35f, 0.35f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot9, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        matrices.push();
        matrices.translate(0.5f, 0.5f, 0.5f);
        matrices.scale(0.35f, 0.35f, 0.35f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot10, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        matrices.push();
        matrices.translate(0.5f, 0.5f, 0.5f);
        matrices.scale(0.35f, 0.35f, 0.35f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot11, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
        matrices.push();
        matrices.translate(0.5f, 0.5f, 0.5f);
        matrices.scale(0.35f, 0.35f, 0.35f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(getYRotation(direction)));
        renderer.renderItem(slot12, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(),
                entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();

    }
    private int getYRotation(Direction direction){
        int ROTATION;
        switch(direction) {

            case NORTH -> {
                return ROTATION = 180;
            }
            case EAST -> {
                return ROTATION = 90;
            }
            case WEST -> {
                return ROTATION = 270;
            }
            case SOUTH -> {
                return ROTATION = 0;
            }
            default -> {
                return ROTATION = 0;
            }
        }
    }
    private int getLightLevel(World world, BlockPos pos){
        int blight = world.getLightLevel(LightType.BLOCK, pos);
        int slight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(blight, slight);
    }
}
