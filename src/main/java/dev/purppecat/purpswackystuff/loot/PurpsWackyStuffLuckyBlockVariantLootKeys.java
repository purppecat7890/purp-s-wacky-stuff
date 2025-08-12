package dev.purppecat.purpswackystuff.loot;

import dev.purppecat.purpswackystuff.PurpsWackyStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

public class PurpsWackyStuffLuckyBlockVariantLootKeys {
    public static final ResourceKey<LootTable> PURP_LOOT = create("purp_loot");

    private static ResourceKey<LootTable> create(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PurpsWackyStuff.MOD_ID, "lucky_block_variants/" + name));
    }
}
