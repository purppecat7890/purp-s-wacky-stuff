package dev.purppecat.purpswackystuff.loot;

import dev.purppecat.purpswackystuff.blocks.PurpsWackyStuffBlocks;
import dev.thomasglasser.tommylib.api.data.loot.ExtendedBlockLootSubProvider;
import java.util.Set;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.flag.FeatureFlags;

public class PurpsWackyStuffBlockLoots extends ExtendedBlockLootSubProvider {
    protected PurpsWackyStuffBlockLoots(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider, PurpsWackyStuffBlocks.BLOCKS);
    }

    @Override
    protected void generate() {
        dropSelf(PurpsWackyStuffBlocks.PURP_LUCKY_BLOCK.get());
    }
}
