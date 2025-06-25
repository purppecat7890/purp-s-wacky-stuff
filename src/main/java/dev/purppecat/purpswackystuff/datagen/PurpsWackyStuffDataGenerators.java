package dev.purppecat.purpswackystuff.datagen;

import dev.purppecat.purpswackystuff.PurpsWackyStuff;
import dev.purppecat.purpswackystuff.loot.LuckyBlockVariants;
import dev.purppecat.purpswackystuff.loot.PurpsWackyStuffLuckyBlockVariantLootTables;
import dev.purppecat.purpswackystuff.registries.PurpsWackyStuffRegistries;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class PurpsWackyStuffDataGenerators {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(PurpsWackyStuffRegistries.LUCKY_BLOCK_VARIANT, LuckyBlockVariants::bootstrap);

    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();
        boolean onServer = event.includeServer();
        DatapackBuiltinEntriesProvider builtinEntriesProvider = new DatapackBuiltinEntriesProvider(packOutput, registries, BUILDER, Set.of(PurpsWackyStuff.MOD_ID));
        generator.addProvider(onServer, builtinEntriesProvider);
        registries = builtinEntriesProvider.getRegistryProvider();
        generator.addProvider(onServer, new PurpsWackyStuffLuckyBlockVariantLootTables(packOutput, registries));
        generator.addProvider(onServer, new PurpsWackyStuffBlockStateProvider(packOutput, existingFileHelper));
    }
}
