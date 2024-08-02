package net.donut.dexrewards;

import net.donut.dexrewards.block.entity.ModBlockEntityType;
//import net.donut.dexrewards.block.entity.renderer.DexMapBlockRenderer;
import net.donut.dexrewards.block.entity.renderer.DexMapBER;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

public class DexRewardsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntityType.DEX_MAP_BLOCK_ENTITY, DexMapBER::new);
    }
}
