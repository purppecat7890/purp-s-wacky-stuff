package dev.purppecat.purpswackystuff.registries;

import dev.purppecat.purpswackystuff.PurpsWackyStuffMod;
import dev.purppecat.purpswackystuff.loot.LuckyBlockVariant;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DataPackRegistryEvent;

@EventBusSubscriber(modid = PurpsWackyStuffMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModDatapackRegistries {
    @SubscribeEvent
    public static void registerDatapackRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(ModRegistries.LUCKY_BLOCK_VARIANTS, LuckyBlockVariant.CODEC);
    }
}
