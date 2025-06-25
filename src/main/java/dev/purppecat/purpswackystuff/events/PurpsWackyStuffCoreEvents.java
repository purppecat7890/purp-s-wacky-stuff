package dev.purppecat.purpswackystuff.events;

import dev.purppecat.purpswackystuff.PurpsWackyStuff;
import dev.thomasglasser.tommylib.api.network.NeoForgeNetworkUtils;
import dev.thomasglasser.tommylib.impl.core.TommyLibNeoForgeCoreEvents;
import dev.thomasglasser.tommylib.impl.network.TommyLibPayloads;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class PurpsWackyStuffCoreEvents extends TommyLibNeoForgeCoreEvents {
    // for future use ig? it was asked by the pull request comment
    // and yes I left this comment here in purpose.
    public static void onRegisterPackets(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(PurpsWackyStuff.MOD_ID);
        TommyLibPayloads.PAYLOADS.forEach((info) -> NeoForgeNetworkUtils.register(registrar, info));
    }
}
