package net.donut.dexrewards;

import net.donut.dexrewards.block.ModBlocks;
import net.donut.dexrewards.block.custom.DexMapBlockEntity;
import net.donut.dexrewards.block.custom.ModBlockEntityType;
import net.donut.dexrewards.client.render.block.entity.DexMapEntityRenderer;
import net.donut.dexrewards.registry.ModRegistries;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.impl.client.rendering.BlockEntityRendererRegistryImpl;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

public class DexRewardsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register(ModBlockEntityType.DEX_MAP, DexMapEntityRenderer::new);
    }
}
