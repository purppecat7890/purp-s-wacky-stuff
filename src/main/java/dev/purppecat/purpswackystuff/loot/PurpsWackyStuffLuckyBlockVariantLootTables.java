package dev.purppecat.purpswackystuff.loot;

import dev.thomasglasser.tommylib.api.data.loot.ExtendedLootTableProvider;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class PurpsWackyStuffLuckyBlockVariantLootTables extends ExtendedLootTableProvider {
    public PurpsWackyStuffLuckyBlockVariantLootTables(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pOutput, Set.of(), List.of(
                new SubProviderEntry(PurpsWackyStuffBlockLoots::new, LootContextParamSets.BLOCK),
                new SubProviderEntry(PurpsWackyStuffLuckyBlockVariantLoot::new, PurpsWackyStuffLuckyBlockVariantLootContextParamSets.LUCKY_BLOCK)), lookupProvider);
    }
}
