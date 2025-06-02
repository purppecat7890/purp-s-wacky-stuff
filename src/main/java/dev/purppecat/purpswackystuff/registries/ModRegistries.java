package dev.purppecat.purpswackystuff.registries;

import dev.purppecat.purpswackystuff.PurpsWackyStuffMod;
import dev.purppecat.purpswackystuff.loot.LuckyBlockVariant;
import dev.thomasglasser.tommylib.TommyLib;
import dev.thomasglasser.tommylib.TommyLibNeoForge;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import dev.thomasglasser.tommylib.impl.data.TommyLibDataGenerators;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class ModRegistries {
    public static final ResourceKey<Registry<LuckyBlockVariant>> LUCKY_BLOCK_VARIANTS =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(PurpsWackyStuffMod.MOD_ID, "lucky_block_variants"));
}
