package dev.purppecat.purpswackystuff;

import dev.purppecat.purpswackystuff.blocks.ModBlocks;
import dev.purppecat.purpswackystuff.datagen.DataGenerators;
import dev.purppecat.purpswackystuff.items.ModItems;
import dev.purppecat.purpswackystuff.loot.ModLootContextParamSets;
import dev.purppecat.purpswackystuff.registries.ModDatapackRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(PurpsWackyStuff.MOD_ID)
public class PurpsWackyStuff {
    public static final String MOD_ID = "purpswackystuff";
    public static final String MOD_NAME = "Purp's Wacky Stuff";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public PurpsWackyStuff(IEventBus modEventBus) {
        ModBlocks.init();
        ModItems.register(modEventBus);
        ModLootContextParamSets.init();
        modEventBus.addListener(ModDatapackRegistries::registerDatapackRegistries);
        modEventBus.addListener(DataGenerators::gatherData);
    }

    public static ResourceLocation modLoc(String s) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, s);
    }
}
