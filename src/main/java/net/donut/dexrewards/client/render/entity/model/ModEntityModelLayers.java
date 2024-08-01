//package net.donut.dexrewards.client.render.entity.model;
//
//import com.google.common.collect.Sets;
//import net.donut.dexrewards.DexRewards;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.minecraft.block.WoodType;
//import net.minecraft.client.render.entity.model.EntityModelLayer;
//import net.minecraft.client.render.entity.model.EntityModelLayers;
//import net.minecraft.entity.vehicle.BoatEntity;
//import net.minecraft.util.Identifier;
//
//import java.util.Set;
//import java.util.stream.Stream;
//
//@Environment(EnvType.CLIENT)
//public class ModEntityModelLayers {
//    public static final Set<EntityModelLayer> LAYERS = (Set<EntityModelLayer>) EntityModelLayers.getLayers();
//    public static final EntityModelLayer DEX_MAP = registerMain("dex_map");
//
//    public ModEntityModelLayers() {
//    }
//
//    private static EntityModelLayer registerMain(String id) {
//        return register(id, "main");
//    }
//
//    private static EntityModelLayer register(String id, String layer) {
//        EntityModelLayer modEntityModelLayer = create(id, layer);
//        if (!LAYERS.add(modEntityModelLayer)) {
//            throw new IllegalStateException("Duplicate registration for " + modEntityModelLayer);
//        } else {
//            return modEntityModelLayer;
//        }
//    }
//
//    private static EntityModelLayer create(String id, String layer) {
//        return new EntityModelLayer(new Identifier(DexRewards.MOD_ID, id), layer);
//    }
//
//    private static EntityModelLayer createInnerArmor(String id) {
//        return register(id, "inner_armor");
//    }
//
//    private static EntityModelLayer createOuterArmor(String id) {
//        return register(id, "outer_armor");
//    }
//
//    public static EntityModelLayer createRaft(BoatEntity.Type type) {
//        return create("raft/" + type.getName(), "main");
//    }
//
//    public static EntityModelLayer createChestRaft(BoatEntity.Type type) {
//        return create("chest_raft/" + type.getName(), "main");
//    }
//
//    public static EntityModelLayer createBoat(BoatEntity.Type type) {
//        return create("boat/" + type.getName(), "main");
//    }
//
//    public static EntityModelLayer createChestBoat(BoatEntity.Type type) {
//        return create("chest_boat/" + type.getName(), "main");
//    }
//
//    public static EntityModelLayer createSign(WoodType type) {
//        return create("sign/" + type.name(), "main");
//    }
//
//    public static EntityModelLayer createHangingSign(WoodType type) {
//        return create("hanging_sign/" + type.name(), "main");
//    }
//
//    public static Stream<EntityModelLayer> getLayers() {
//        return LAYERS.stream();
//    }
//}
