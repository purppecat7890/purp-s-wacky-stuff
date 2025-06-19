package dev.purppecat.purpswackystuff.loot;

import dev.purppecat.purpswackystuff.PurpsWackyStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModLootKeys {
    public static final ResourceKey<LootTable> luckyblock = getLuckyblock("lucky_block_v");

    private static ResourceKey<LootTable> getLuckyblock(String name) {
        return modLoc("purpswackystuff/lucky_block_variants/" + name);
    }

    private static ResourceKey<LootTable> modLoc(String name) {
        return ResourceKey.create(Registries.LOOT_TABLE, PurpsWackyStuff.modLoc(name));
    }
}
