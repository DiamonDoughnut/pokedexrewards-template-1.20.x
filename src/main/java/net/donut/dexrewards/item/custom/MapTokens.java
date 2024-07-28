package net.donut.dexrewards.item.custom;

import net.donut.dexrewards.item.ModItems;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class MapTokens {
    String id = "base";
    public MapTokens(){

    }
    public static final RegistryKey<MapToken> BASE = of("base");
    public static final RegistryKey<MapToken> KANTO = of("kanto");
    public static final RegistryKey<MapToken> JOHTO = of("johto");
    public static final RegistryKey<MapToken> HOENN = of("hoenn");
    public static final RegistryKey<MapToken> SINNOH = of("sinnoh");
    public static final RegistryKey<MapToken> UNOVA = of("unova");
    public static final RegistryKey<MapToken> KALOS = of("kalos");
    public static final RegistryKey<MapToken> ALOLA = of("alola");
    public static final RegistryKey<MapToken> GALAR = of("galar");
    public static final RegistryKey<MapToken> PALDEA = of("paldea");
    public static final RegistryKey<MapToken> DEX25 = of("dex25");
    public static final RegistryKey<MapToken> DEX50 = of("dex50");
    public static final RegistryKey<MapToken> DEX75 = of("dex75");
    public static final RegistryKey<MapToken> DEX100 = of("dex100");

    public static RegistryKey<MapToken> of(String id){
        return RegistryKey.of(ModItems.MAP_TOKEN, new Identifier(id));
    }

    public static MapToken registerAndGetDefault(Registry<MapToken> registry){
        Registry.register(registry, KANTO, new MapToken("1"));
        Registry.register(registry, JOHTO, new MapToken("2"));
        Registry.register(registry, HOENN, new MapToken("3"));
        Registry.register(registry, SINNOH, new MapToken("4"));
        Registry.register(registry, UNOVA, new MapToken("5"));
        Registry.register(registry, KALOS, new MapToken("6"));
        Registry.register(registry, ALOLA, new MapToken("7"));
        Registry.register(registry, GALAR, new MapToken("8"));
        Registry.register(registry, PALDEA, new MapToken("9"));
        Registry.register(registry, DEX25, new MapToken("25"));
        Registry.register(registry, DEX50, new MapToken("50"));
        Registry.register(registry, DEX75, new MapToken("75"));
        Registry.register(registry, DEX100, new MapToken("100"));
        return Registry.register(registry, BASE, new MapToken("0"));
    }
}
