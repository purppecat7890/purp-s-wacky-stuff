package dev.purppecat.purpswackystuff.loot;

import dev.purppecat.purpswackystuff.PurpsWackyStuff;
import dev.purppecat.purpswackystuff.registries.PurpsWackyStuffRegistries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;

public class LuckyBlockVariants {
    public static final ResourceKey<LuckyBlockVariant> BASIC = create("basic");
    public static final ResourceKey<LuckyBlockVariant> CUSTOM_LOOT = create("custom_loot");

    private static ResourceKey<LuckyBlockVariant> create(String name) {
        return ResourceKey.create(PurpsWackyStuffRegistries.LUCKY_BLOCK_VARIANT, PurpsWackyStuff.modLoc(name));
    }

    private static void register(BootstrapContext<LuckyBlockVariant> context, ResourceKey<LuckyBlockVariant> key, ResourceKey<LootTable> lootTable, float chanceToDropNothing) {
        context.register(key, new LuckyBlockVariant(lootTable, chanceToDropNothing));
    }

    public static void bootstrap(BootstrapContext<LuckyBlockVariant> context) {
        register(
                context,
                BASIC,
                BuiltInLootTables.SIMPLE_DUNGEON,
                0.2f);
        register(
                context,
                CUSTOM_LOOT,
                PurpsWackyStuffLuckyBlockVariantLootKeys.PURP_LOOT,
                0f);
    }
}
