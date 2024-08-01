package net.donut.dexrewards.world;

import fzzyhmstrs.structurized_reborn.impl.FabricStructurePoolRegistry;
import net.donut.dexrewards.DexRewards;
import net.minecraft.util.Identifier;

import java.util.List;

public class VillageAdditions {
    public static int i = 0;
    public static List<String> biomes = List.of("plains", "desert", "savanna", "snowy", "taiga");

    public static void registerBotaniaStructures() {
        for(i = 0; i <=5; i++){
            registerNewStructuresToPool("minecraft:village/" + biomes.get(i) + "/houses","botania_villager_" + biomes.get(i), 2);
        }
    }
    public static void registerArcheoStructures() {
        for(i = 0; i <=5; i++){
            registerNewStructuresToPool("minecraft:village/" + biomes.get(i) + "/houses","archeo_villager_" + biomes.get(i), 2);
        }
    }
    public static void registerCobblemonStructures() {
        for(i = 0; i <=5; i++){
            registerNewStructuresToPool("minecraft:village/" + biomes.get(i) + "/houses","cobblemon_villager_" + biomes.get(i), 2);
        }
    }
    public static void registerPastureStructures() {
        for(i = 0; i <=5; i++){
            registerNewStructuresToPool("minecraft:village/" + biomes.get(i) + "/houses","cobblemon_pasture_" + biomes.get(i), 2);
        }
    }
    public static void registerHephaestusStructures() {
        for(i = 0; i <=5; i++){
            registerNewStructuresToPool("minecraft:village/" + biomes.get(i) + "/houses","hephaestus_villager_" + biomes.get(i), 2);
        }
    }
    public static void registerMedicStructures() {
        for(i = 0; i <=5; i++){
            registerNewStructuresToPool("minecraft:village/" + biomes.get(i) + "/houses","poke_medic_" + biomes.get(i), 2);
       }
    }
    public static void registerRuneStructures() {
        for(i = 0; i <=5; i++){
            registerNewStructuresToPool("minecraft:village/" + biomes.get(i) + "/houses", "rune_villager_" + biomes.get(i), 2);
        }
    }
    //using structurized reborn under MIT license
    public static void registerNewStructuresToPool(String pool, String structure, int weight){
        DexRewards.LOGGER.info("Registering Villager Housing for " + DexRewards.MOD_ID);
        FabricStructurePoolRegistry.registerSimple(new Identifier(pool),
                new Identifier(DexRewards.MOD_ID, structure),
                weight);
    }
}
