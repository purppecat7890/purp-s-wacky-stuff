package dev.purppecat.purpswackystuff.loot;

import dev.thomasglasser.tommylib.api.tags.ConventionalItemTags;
import java.util.function.BiConsumer;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public record PurpsWackyStuffLuckyBlockVariantLoot(HolderLookup.Provider registries) implements LootTableSubProvider {
    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(
                PurpsWackyStuffLuckyBlockVariantLootKeys.PURP_LOOT,
                LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool()
                                        .setRolls(ConstantValue.exactly(1.0F))
                                        .add(TagEntry.expandTag(ConventionalItemTags.SHIELD_TOOLS)
                                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1))))));
    }
}
