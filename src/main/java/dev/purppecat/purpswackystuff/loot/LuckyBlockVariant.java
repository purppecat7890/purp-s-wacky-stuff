package dev.purppecat.purpswackystuff.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public record LuckyBlockVariant(ResourceKey<LootTable> lootTable, float chanceToDropNothing) {
    public static final Codec<LuckyBlockVariant> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("loot_table").forGetter(LuckyBlockVariant::lootTable),
            Codec.FLOAT.fieldOf("chance_to_drop_nothing").forGetter(LuckyBlockVariant::chanceToDropNothing)).apply(instance, LuckyBlockVariant::new));
}
