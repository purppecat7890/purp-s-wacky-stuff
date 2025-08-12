package dev.purppecat.purpswackystuff.registries;

import dev.purppecat.purpswackystuff.PurpsWackyStuff;
import dev.purppecat.purpswackystuff.loot.LuckyBlockVariant;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

public class PurpsWackyStuffRegistries {
    public static final ResourceKey<Registry<LuckyBlockVariant>> LUCKY_BLOCK_VARIANT = ResourceKey.createRegistryKey(PurpsWackyStuff.modLoc("lucky_block_variant"));
}
