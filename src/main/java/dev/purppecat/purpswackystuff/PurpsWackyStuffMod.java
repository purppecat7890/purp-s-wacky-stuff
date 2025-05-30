package dev.purppecat.purpswackystuff;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(PurpsWackyStuffMod.MOD_ID)
public class PurpsWackyStuffMod {
    public static final String MOD_ID = "purpswackystuff";
    public static final String MOD_NAME = "Purp's Wacky Stuff";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public PurpsWackyStuffMod(IEventBus modEventBus) {}

    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }
}
