package dev.purppecat.purpswackystuff.datagen;

import dev.purppecat.purpswackystuff.PurpsWackyStuff;
import dev.purppecat.purpswackystuff.blocks.ModBlocks;
import dev.thomasglasser.tommylib.api.data.blockstates.ExtendedBlockStateProvider;
import dev.thomasglasser.tommylib.api.registration.DeferredBlock;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends ExtendedBlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PurpsWackyStuff.MOD_ID, exFileHelper);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PURP_LUCKY_BLOCK);
    }
}
