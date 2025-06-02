package dev.purppecat.purpswackystuff.loot;

import dev.purppecat.purpswackystuff.PurpsWackyStuffMod;
import dev.purppecat.purpswackystuff.registries.ModRegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.data.loot.packs.VanillaChestLoot;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.EnchantWithLevelsFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public class ModChestLootTables implements LootTableSubProvider{
    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        LootPool.Builder pool = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(Items.DIAMOND)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))))
                .add(LootItem.lootTableItem(Items.GOLD_INGOT)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 5))));

        LootTable.Builder table = LootTable.lootTable()
                .withPool(pool);

        ResourceKey<LootTable> key = ResourceKey.create(Registries.LOOT_TABLE,ResourceLocation.fromNamespaceAndPath(PurpsWackyStuffMod.MOD_ID, "chests/my_custom_chest_loot"));
        output.accept(key, table);
    }

}
