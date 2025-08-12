package dev.purppecat.purpswackystuff.blocks.custom;

import dev.purppecat.purpswackystuff.loot.LuckyBlockVariant;
import dev.purppecat.purpswackystuff.loot.PurpsWackyStuffLuckyBlockVariantLootContextParamSets;
import dev.purppecat.purpswackystuff.registries.PurpsWackyStuffRegistries;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
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

public class PurpLuckyBlock extends Block {
    public PurpLuckyBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level instanceof ServerLevel serverLevel) {
            serverLevel.removeBlock(pos, false);
            serverLevel.sendParticles(ParticleTypes.END_ROD, (pos.getX() + .5), (pos.getY() + .5), (pos.getZ() + .5), 15, 0, 0, 0, 0.0001);
            RegistryAccess registryAccess = serverLevel.registryAccess();
            Registry<LuckyBlockVariant> registry = registryAccess.registryOrThrow(PurpsWackyStuffRegistries.LUCKY_BLOCK_VARIANT);
            Optional<Holder.Reference<LuckyBlockVariant>> variants = registry.getRandom(serverLevel.random);
            if (variants.isEmpty()) return InteractionResult.FAIL;
            LuckyBlockVariant randomVariant = variants.get().value();
            float chance = randomVariant.chanceToDropNothing();
            float roll = serverLevel.getRandom().nextFloat();
            if (roll >= chance) {
                LootTable lootTable = serverLevel.getServer().reloadableRegistries().getLootTable(randomVariant.lootTable());

                LootParams.Builder builder = new LootParams.Builder(serverLevel).withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                        .withParameter(LootContextParams.BLOCK_STATE, state)
                        .withParameter(LootContextParams.THIS_ENTITY, player);

                LootParams lootparams = builder.create(PurpsWackyStuffLuckyBlockVariantLootContextParamSets.LUCKY_BLOCK);
                lootTable.getRandomItems(lootparams, itemStack -> {
                    Block.popResource(level, pos, itemStack);
                });
            } else {
                if (!player.level().isClientSide())
                    player.displayClientMessage(Component.translatable("chat.purpswackystuff.ugotnothing"), false);
            }

        }
        level.playSound(player, pos, SoundEvents.AMETHYST_BLOCK_PLACE, SoundSource.BLOCKS, 1, 1);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
