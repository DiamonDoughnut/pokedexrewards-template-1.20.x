package net.donut.dexrewards.datagen;

import net.donut.dexrewards.DexRewards;
import net.minecraft.data.DataOutput;
import net.minecraft.data.server.tag.TagProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.PointOfInterestTypeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.concurrent.CompletableFuture;

public class ModPoiTagProvider extends TagProvider<PointOfInterestType> {

    public ModPoiTagProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookupFuture) {
        super(output, RegistryKeys.POINT_OF_INTEREST_TYPE, registryLookupFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE).addOptional(new Identifier(DexRewards.MOD_ID, "soundpoi"));
        //delete once dependencies installed?
        getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE).addOptional(new Identifier(DexRewards.MOD_ID, "botaniapoi"));
        getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE).addOptional(new Identifier(DexRewards.MOD_ID, "cobblemonpoi"));
        getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE).addOptional(new Identifier(DexRewards.MOD_ID, "hephaestuspoi"));
        getOrCreateTagBuilder(PointOfInterestTypeTags.ACQUIRABLE_JOB_SITE).addOptional(new Identifier(DexRewards.MOD_ID, "runepoi"));

    }
}
