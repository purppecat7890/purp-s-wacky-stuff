package dev.purppecat.purpswackystuff.loot;

import dev.purppecat.purpswackystuff.blocks.ModBlocks;
import dev.thomasglasser.tommylib.api.data.loot.ExtendedBlockLootSubProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.flag.FeatureFlags;

import java.util.Set;

public class ModBlockLoots extends ExtendedBlockLootSubProvider {
    protected ModBlockLoots(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider, ModBlocks.BLOCKS);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.PURP_LUCKY_BLOCK.get());
    }
}
