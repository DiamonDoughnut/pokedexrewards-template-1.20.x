package net.donut.dexrewards;

import net.donut.dexrewards.block.entity.ModBlockEntityType;
//import net.donut.dexrewards.block.entity.renderer.DexMapBlockRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class DexRewardsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
   //     BlockEntityRendererFactories.register(ModBlockEntityType.DEX_MAP_BLOCK_ENTITY, DexMapBlockRenderer::new);
    }
}
