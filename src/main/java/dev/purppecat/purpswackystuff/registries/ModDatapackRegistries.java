package dev.purppecat.purpswackystuff.registries;

import dev.purppecat.purpswackystuff.loot.LuckyBlockVariant;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.IModBusEvent;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

public class ModDatapackRegistries implements IModBusEvent {
    public static void registerDatapackRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(ModRegistries.LUCKY_BLOCK_VARIANTS, LuckyBlockVariant.CODEC);
    }

}
