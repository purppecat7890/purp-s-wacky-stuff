package dev.purppecat.purpswackystuff.registries;

import dev.purppecat.purpswackystuff.loot.LuckyBlockVariant;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

public class PurpsWackyStuffDatapackRegistries {
    public static void registerDatapackRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(PurpsWackyStuffRegistries.LUCKY_BLOCK_VARIANT, LuckyBlockVariant.CODEC);
    }
}
