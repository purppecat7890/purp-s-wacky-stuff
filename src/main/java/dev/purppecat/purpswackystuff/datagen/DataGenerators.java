package dev.purppecat.purpswackystuff.datagen;

import dev.purppecat.purpswackystuff.loot.ModLootTables;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();
        boolean onServer = event.includeServer();
        generator.addProvider(onServer, new ModLootTables(packOutput, event.getLookupProvider()));
        generator.addProvider(onServer, new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(onServer, new ModDatapackProvider(packOutput, registries));
    }
}
