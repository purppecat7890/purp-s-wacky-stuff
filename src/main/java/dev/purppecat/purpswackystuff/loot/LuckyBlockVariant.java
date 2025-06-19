package dev.purppecat.purpswackystuff.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.purppecat.purpswackystuff.PurpsWackyStuff;
import dev.purppecat.purpswackystuff.registries.ModRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

public record LuckyBlockVariant(ResourceKey<LootTable> lootTable, float chanceToDropNothing) {
    public static final Codec<LuckyBlockVariant> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("loot_table").forGetter(LuckyBlockVariant::lootTable),
            Codec.FLOAT.fieldOf("chance_to_drop_nothing").forGetter(LuckyBlockVariant::chanceToDropNothing)).apply(instance, LuckyBlockVariant::new));

    private static void register(BootstrapContext<LuckyBlockVariant> context, ResourceKey<LuckyBlockVariant> key, ResourceKey<LootTable> lootTable, float chanceToDropNothing) {
        context.register(key, new LuckyBlockVariant(lootTable, chanceToDropNothing));
    }

    public static void bootstrap(BootstrapContext<LuckyBlockVariant> context) {
        register(
                context,
                ResourceKey.create(ModRegistries.LUCKY_BLOCK_VARIANTS, ResourceLocation.fromNamespaceAndPath(PurpsWackyStuff.MOD_ID, "basic")),
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("minecraft", "chests/simple_dungeon")),
                0.2f);
        register(
                context,
                ResourceKey.create(ModRegistries.LUCKY_BLOCK_VARIANTS, ResourceLocation.fromNamespaceAndPath(PurpsWackyStuff.MOD_ID, "custom_loot")),
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(PurpsWackyStuff.MOD_ID, "purpswackystuff/lucky_block_variants/lucky_block_v")),
                0f);
    }
}
