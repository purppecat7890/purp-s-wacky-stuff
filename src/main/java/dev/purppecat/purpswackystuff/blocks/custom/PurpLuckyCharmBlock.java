package dev.purppecat.purpswackystuff.blocks.custom;

import dev.purppecat.purpswackystuff.PurpsWackyStuff;
import dev.purppecat.purpswackystuff.loot.LuckyBlockVariant;
import dev.purppecat.purpswackystuff.loot.ModLootContextParamSets;
import dev.purppecat.purpswackystuff.registries.ModRegistries;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class PurpLuckyCharmBlock extends Block {
    public PurpLuckyCharmBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level instanceof ServerLevel serverLevel) {
            serverLevel.removeBlock(pos, false);
            serverLevel.sendParticles(ParticleTypes.END_ROD, (pos.getX() + .5), (pos.getY() + .5), (pos.getZ() + .5), 15, 0, 0, 0, 0.0001);
            RegistryAccess registryAccess = serverLevel.registryAccess();
            Registry<LuckyBlockVariant> registry = registryAccess.registryOrThrow(ModRegistries.LUCKY_BLOCK_VARIANTS);
            List<LuckyBlockVariant> variants = registry.stream().toList();
            if (variants.isEmpty()) return null;
            LuckyBlockVariant randomVariant = variants.get(serverLevel.getRandom().nextInt(variants.size()));
            float chance = randomVariant.chanceToDropNothing();
            float roll = serverLevel.getRandom().nextFloat();
            PurpsWackyStuff.LOGGER.info("Chance: " + chance);
            PurpsWackyStuff.LOGGER.info("Roll: " + roll);
            if (roll >= chance) {
                LootTable lootTable = serverLevel.getServer().reloadableRegistries().getLootTable(randomVariant.lootTable());

                LootParams.Builder builder = new LootParams.Builder(serverLevel);

                builder.withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                        .withParameter(LootContextParams.BLOCK_STATE, state)
                        .withParameter(LootContextParams.THIS_ENTITY, player)
                        .create(ModLootContextParamSets.CUSTOM_LUCKY_VARIANT);

                LootParams lootparams = builder.create(ModLootContextParamSets.CUSTOM_LUCKY_VARIANT);
                lootTable.getRandomItems(lootparams, itemStack -> {
                    Block.popResource(level, pos, itemStack);
                });
            } else {
                if (player instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("u got nothing"), false);
            }

        }
        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1, 1);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
