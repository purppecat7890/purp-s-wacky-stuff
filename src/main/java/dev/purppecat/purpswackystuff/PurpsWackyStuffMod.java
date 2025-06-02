package dev.purppecat.purpswackystuff;

import dev.purppecat.purpswackystuff.blocks.ModBlocks;
import dev.purppecat.purpswackystuff.datagen.DataGenerators;
import dev.purppecat.purpswackystuff.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(PurpsWackyStuffMod.MOD_ID)
public class PurpsWackyStuffMod {
    public static final String MOD_ID = "purpswackystuff";
    public static final String MOD_NAME = "Purp's Wacky Stuff";
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public PurpsWackyStuffMod(IEventBus modEventBus) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(DataGenerators::gatherData);
    }

    public static ResourceLocation modLoc(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
