package dev.purppecat.purpswackystuff.events;

import dev.purppecat.purpswackystuff.loot.LuckyBlockVariant;
import dev.purppecat.purpswackystuff.registries.PurpsWackyStuffRegistries;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

public class PurpsWackyStuffCoreEvents {
    public static void registerDatapackRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(PurpsWackyStuffRegistries.LUCKY_BLOCK_VARIANT, LuckyBlockVariant.CODEC);
    }
}
