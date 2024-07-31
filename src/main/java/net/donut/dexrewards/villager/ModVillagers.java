package net.donut.dexrewards.villager;

import com.eliotlash.mclib.math.functions.classic.Mod;
import com.google.common.collect.ImmutableSet;
import net.donut.dexrewards.DexRewards;
import net.donut.dexrewards.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.Objects;
import java.util.Optional;

public class ModVillagers {
//    //initialize block sound key - name field is same used in most other related fields to reference here
//    public static final RegistryKey<PointOfInterestType> SOUND_POI_KEY = poiKey("soundpoi");
//    //define job block - name field must be same as above
//    public static final PointOfInterestType SOUND_POI = registerPoi("soundpoi", ModBlocks.DEX_MAP_BLOCK);
//    //initialize new job and connect to sound key - name field must be same as texture file
//    public static final VillagerProfession TEST_PROFESSION = registerProfession("test_profession", SOUND_POI_KEY);

    //soft dependency: botania
    public static String botaniaName = "botaniapoi";
    public static Optional<Block> botaniaBlock = null;
    public static Block modVillagersBotania(){
        if(checkModPresence("botania", "dreamwood_wand")){
            botaniaBlock = Registries.BLOCK.stream().filter(block -> Objects.equals(Identifier.of("botania", "apothecary_default"), Registries.BLOCK.getId(block))).findFirst();
            return botaniaBlock.orElse(ModBlocks.BOTANIA_BLOCK);
        }
        else {
            return ModBlocks.BOTANIA_BLOCK;
        }
    }

    public static final RegistryKey<PointOfInterestType> BOTANIA_POI_KEY = poiKey("botaniapoi");
    public static final PointOfInterestType BOTANIA_SOUND_POI = registerPoi("botaniapoi", modVillagersBotania());
    public static final VillagerProfession BOTANIA_VILLAGER = registerProfession("botania_villager", BOTANIA_POI_KEY);


    //soft dependency: cobblemon
    public static String cobblemonName = "cobblemonpoi";
    public static Optional<Block> cobblemonBlock = null;
    public static Block modVillagersCobblemon(){
        if(checkModPresence("cobblemon", "poke_ball")){
            cobblemonBlock = Registries.BLOCK.stream().filter(block -> Objects.equals(Identifier.of("cobblemon", "display_case"), Registries.BLOCK.getId(block))).findFirst();
            return cobblemonBlock.orElse(ModBlocks.COBBLEMON_BLOCK);
        }
        else {
            return ModBlocks.COBBLEMON_BLOCK;
        }
    }
    public static final RegistryKey<PointOfInterestType> COBBLEMON_POI_KEY = poiKey("cobblemonpoi");
    public static final PointOfInterestType COBBLEMON_SOUND_POI = registerPoi("cobblemonpoi", modVillagersCobblemon());
    public static final VillagerProfession COBBLEMON_VILLAGER = registerProfession("cobblemon_villager", COBBLEMON_POI_KEY);
    public static String cobblemonName1 = "cobblemonpoi1";
    public static Optional<Block> cobblemonBlock1 = null;
    public static Block modVillagersCobblemon1(){
        if(checkModPresence("cobblemon", "poke_ball")){
            cobblemonBlock1 = Registries.BLOCK.stream().filter(block -> Objects.equals(Identifier.of("cobblemon", "display_case"), Registries.BLOCK.getId(block))).findFirst();
            return cobblemonBlock1.orElse(ModBlocks.COBBLEMON_BLOCK1);
        }
        else {
            return ModBlocks.COBBLEMON_BLOCK1;
        }
    }
    public static final RegistryKey<PointOfInterestType> COBBLEMON_POI_KEY1 = poiKey("cobblemonpoi1");
    public static final PointOfInterestType COBBLEMON_SOUND_POI1 = registerPoi("cobblemonpoi1", modVillagersCobblemon1());
    public static final VillagerProfession COBBLEMON_VILLAGER1 = registerProfession("cobblemon_villager1", COBBLEMON_POI_KEY1);

    //soft dependency: hephaestus
    public static String hephaestusName = "hephaestuspoi";
    public static Optional<Block> hephaestusBlock = null;
    public static Block modVillagersHephaestus(){
        if(checkModPresence("tconstruct", "seared_brick")){
            hephaestusBlock = Registries.BLOCK.stream().filter(block -> Objects.equals(Identifier.of("tconstruct", "seared_melter"), Registries.BLOCK.getId(block))).findFirst();
            return hephaestusBlock.orElse(ModBlocks.HEPHAESTUS_BLOCK);
        }
        else {
            return ModBlocks.HEPHAESTUS_BLOCK;
        }
    }
    public static final RegistryKey<PointOfInterestType> HEPHAESTUS_POI_KEY = poiKey("hephaestuspoi");
    public static final PointOfInterestType HEPHAESTUS_SOUND_POI = registerPoi("hephaestuspoi", modVillagersHephaestus());
    public static final VillagerProfession HEPHAESTUS_VILLAGER = registerProfession("hephaestus_villager", HEPHAESTUS_POI_KEY);

    //soft dependency: runic enchanting
    public static String runeName = "runepoi";
    public static Optional<Block> runeBlock = null;
    public static Block modVillagersRunicEnchanting(){
        if(checkModPresence("runic_enchanting", "rune_chalk")){
            runeBlock = Registries.BLOCK.stream().filter(block -> Objects.equals(Identifier.of("runic_enchanting", "rune_enchanting_table"), Registries.BLOCK.getId(block))).findFirst();
            return runeBlock.orElse(ModBlocks.RUNE_BLOCK);
        }
        else {
            return ModBlocks.RUNE_BLOCK;
        }
    }
    public static final RegistryKey<PointOfInterestType> RUNE_POI_KEY = poiKey("runepoi");
    public static final PointOfInterestType RUNE_SOUND_POI = registerPoi("runepoi", modVillagersRunicEnchanting());
    public static final VillagerProfession RUNE_VILLAGER = registerProfession("rune_villager", RUNE_POI_KEY);

    //soft dependency: archaeology complex
    public static String archaeologyName = "archaeologypoi";
    public static Optional<Block> archaeologyBlock = null;
    public static Block modVillagersArchaeologyComplex(){
        if(checkModPresence("betterarcheology", "iron_brush")){
            archaeologyBlock = Registries.BLOCK.stream().filter(block -> Objects.equals(Identifier.of("betterarcheology", "archeology_table"), Registries.BLOCK.getId(block))).findFirst();
            return archaeologyBlock.orElse(ModBlocks.ARCHEO_BLOCK);
        }
        else {
            return ModBlocks.ARCHEO_BLOCK;
        }
    }
    public static final RegistryKey<PointOfInterestType> ARCHEO_POI_KEY = poiKey("archaeopoi");
    public static final PointOfInterestType ARCHEO_SOUND_POI = registerPoi("archaeopoi", modVillagersArchaeologyComplex());
    public static final VillagerProfession ARCHEO_VILLAGER = registerProfession("archeo_villager", ARCHEO_POI_KEY);

    public static boolean checkModPresence(String namespace, String key){
        Optional<Item> modItemFinal = Registries.ITEM.stream().filter(item -> Objects.equals(Identifier.of(namespace, key), Registries.ITEM.getId(item))).findFirst();
        return modItemFinal.isPresent();
    }

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(DexRewards.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_ARMORER)
        );
    }

    //helper methods and registry
    private static PointOfInterestType registerPoi(String name, Block block){
        return PointOfInterestHelper.register(new Identifier(DexRewards.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(DexRewards.MOD_ID, name));
    }

    public static void registerVillagers() {
        DexRewards.LOGGER.info("Registering Villagers for " + DexRewards.MOD_ID);
    }



}
