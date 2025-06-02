package dev.purppecat.purpswackystuff.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import cpw.mods.modlauncher.api.ITransformationService;
import dev.purppecat.purpswackystuff.PurpsWackyStuffMod;
import dev.purppecat.purpswackystuff.blocks.custom.PurpLuckyCharmBlock;
import dev.purppecat.purpswackystuff.registries.ModRegistries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.neoforge.event.level.BlockDropsEvent;

import java.util.List;

public record LuckyBlockVariant(ResourceKey<LootTable> lootTable, float chanceToDropNothing) {
    public static final Codec<LuckyBlockVariant> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("loot_table").forGetter(LuckyBlockVariant::lootTable),
                    Codec.FLOAT.fieldOf("chance_to_drop_nothing").forGetter(LuckyBlockVariant::chanceToDropNothing)
            ).apply(instance, LuckyBlockVariant::new)
    );


    private static void register(BootstrapContext<LuckyBlockVariant> context, ResourceKey<LuckyBlockVariant> key, ResourceKey<LootTable> lootTable, float chanceToDropNothing) {
        context.register(key, new LuckyBlockVariant(lootTable, chanceToDropNothing));
    }

    public static void bootstrap(BootstrapContext<LuckyBlockVariant> context) {
        register(
                context,
                ResourceKey.create(ModRegistries.LUCKY_BLOCK_VARIANTS, ResourceLocation.fromNamespaceAndPath(PurpsWackyStuffMod.MOD_ID, "basic")),
                ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("minecraft", "chests/simple_dungeon")),
                0.2f
        );
        register(
                context,
                ResourceKey.create(ModRegistries.LUCKY_BLOCK_VARIANTS,ResourceLocation.fromNamespaceAndPath(PurpsWackyStuffMod.MOD_ID, "custom_loot")),
                ResourceKey.create(Registries.LOOT_TABLE,ResourceLocation.fromNamespaceAndPath(PurpsWackyStuffMod.MOD_ID, "chests/my_custom_chest_loot")),
                0.0f
        );
    }
}
