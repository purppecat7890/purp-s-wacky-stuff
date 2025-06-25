package dev.purppecat.purpswackystuff;

import dev.purppecat.purpswackystuff.blocks.PurpsWackyStuffBlocks;
import dev.purppecat.purpswackystuff.datagen.PurpsWackyStuffDataGenerators;
import dev.purppecat.purpswackystuff.items.PurpsWackyStuffItems;
import dev.purppecat.purpswackystuff.loot.PurpsWackyStuffLuckyBlockVariantLootContextParamSets;
import dev.purppecat.purpswackystuff.registries.PurpsWackyStuffDatapackRegistries;
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
        PurpsWackyStuffBlocks.init();
        PurpsWackyStuffItems.init();
        PurpsWackyStuffLuckyBlockVariantLootContextParamSets.init();

        modEventBus.addListener(PurpsWackyStuffDatapackRegistries::registerDatapackRegistries);
        modEventBus.addListener(PurpsWackyStuffDataGenerators::gatherData);
    }

    public static ResourceLocation modLoc(String s) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, s);
    }
}
