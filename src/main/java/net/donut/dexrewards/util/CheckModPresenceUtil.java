package net.donut.dexrewards.util;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class CheckModPresenceUtil {


    public boolean checkModPresence(String namespace, String key){
        Optional<Item> modItemFinal = Registries.ITEM.stream().filter(item -> Identifier.of(namespace, key).equals(Registries.ITEM.getId(item))).findFirst();
        return modItemFinal.isPresent();
    }
}
