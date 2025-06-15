package dev.purppecat.purpswackystuff.datagen;

import dev.purppecat.purpswackystuff.PurpsWackyStuff;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, PurpsWackyStuff.MOD_ID);
    }

    @Override
    protected void start() {

    }
}
