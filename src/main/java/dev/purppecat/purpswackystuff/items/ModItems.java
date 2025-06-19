package dev.purppecat.purpswackystuff.items;

import dev.purppecat.purpswackystuff.PurpsWackyStuff;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PurpsWackyStuff.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
