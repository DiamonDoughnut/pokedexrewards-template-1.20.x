package net.donut.dexrewards.registry;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Lifecycle;
import net.donut.dexrewards.item.custom.MapToken;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.entry.RegistryEntryOwner;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Stream;

public class ModRegistries {
    public static final RenderLayer MAP_RENDER_LAYER;
    public static final Identifier MAP_TOKEN_ATLAS_TEXTURE = new Identifier("net/donut/dexrewards/resources/assets/dexrewards/textures/atlases");
    public static SpriteIdentifier getMapPatternTextureId(RegistryKey<MapToken> token){
        return new SpriteIdentifier(MAP_TOKEN_ATLAS_TEXTURE, MapToken.getSpriteId(token, true));
    }
    static{
        MAP_RENDER_LAYER = RenderLayer.getEntityNoOutline(MAP_TOKEN_ATLAS_TEXTURE);
    }
    public static final Registry<MapToken> MAP_TOKEN = new Registry<MapToken>() {
        @Override
        public RegistryKey<? extends Registry<MapToken>> getKey() {
            return null;
        }

        @Nullable
        @Override
        public Identifier getId(MapToken value) {
            return null;
        }

        @Override
        public Optional<RegistryKey<MapToken>> getKey(MapToken entry) {
            return Optional.empty();
        }

        @Override
        public int getRawId(@Nullable MapToken value) {
            return 0;
        }

        @Nullable
        @Override
        public MapToken get(@Nullable RegistryKey<MapToken> key) {
            return null;
        }

        @Nullable
        @Override
        public MapToken get(@Nullable Identifier id) {
            return null;
        }

        @Override
        public Lifecycle getEntryLifecycle(MapToken entry) {
            return null;
        }

        @Override
        public Lifecycle getLifecycle() {
            return null;
        }

        @Override
        public Set<Identifier> getIds() {
            return Set.of();
        }

        @Override
        public Set<Map.Entry<RegistryKey<MapToken>, MapToken>> getEntrySet() {
            return Set.of();
        }

        @Override
        public Set<RegistryKey<MapToken>> getKeys() {
            return Set.of();
        }

        @Override
        public Optional<RegistryEntry.Reference<MapToken>> getRandom(Random random) {
            return Optional.empty();
        }

        @Override
        public boolean containsId(Identifier id) {
            return false;
        }

        @Override
        public boolean contains(RegistryKey<MapToken> key) {
            return false;
        }

        @Override
        public Registry<MapToken> freeze() {
            return null;
        }

        @Override
        public RegistryEntry.Reference<MapToken> createEntry(MapToken value) {
            return null;
        }

        @Override
        public Optional<RegistryEntry.Reference<MapToken>> getEntry(int rawId) {
            return Optional.empty();
        }

        @Override
        public Optional<RegistryEntry.Reference<MapToken>> getEntry(RegistryKey<MapToken> key) {
            return Optional.empty();
        }

        @Override
        public RegistryEntry<MapToken> getEntry(MapToken value) {
            return null;
        }

        @Override
        public Stream<RegistryEntry.Reference<MapToken>> streamEntries() {
            return Stream.empty();
        }

        @Override
        public Optional<RegistryEntryList.Named<MapToken>> getEntryList(TagKey<MapToken> tag) {
            return Optional.empty();
        }

        @Override
        public RegistryEntryList.Named<MapToken> getOrCreateEntryList(TagKey<MapToken> tag) {
            return null;
        }

        @Override
        public Stream<Pair<TagKey<MapToken>, RegistryEntryList.Named<MapToken>>> streamTagsAndEntries() {
            return Stream.empty();
        }

        @Override
        public Stream<TagKey<MapToken>> streamTags() {
            return Stream.empty();
        }

        @Override
        public void clearTags() {

        }

        @Override
        public void populateTags(Map<TagKey<MapToken>, List<RegistryEntry<MapToken>>> tagEntries) {

        }

        @Override
        public RegistryEntryOwner<MapToken> getEntryOwner() {
            return null;
        }

        @Override
        public RegistryWrapper.Impl<MapToken> getReadOnlyWrapper() {
            return null;
        }

        @Nullable
        @Override
        public MapToken get(int index) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @NotNull
        @Override
        public Iterator<MapToken> iterator() {
            return null;
        }
    };
}
