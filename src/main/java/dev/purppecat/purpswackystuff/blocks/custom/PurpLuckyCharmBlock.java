package dev.purppecat.purpswackystuff.blocks.custom;

import dev.purppecat.purpswackystuff.loot.LuckyBlockVariant;
import dev.purppecat.purpswackystuff.registries.ModRegistries;
import net.minecraft.core.BlockPos;

import net.minecraft.core.Holder;

import net.minecraft.server.level.ServerLevel;

import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;

import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.Optional;
public class PurpLuckyCharmBlock extends Block {
    public PurpLuckyCharmBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) return InteractionResult.SUCCESS;

        ServerLevel serverLevel = (ServerLevel) level;

        Optional<Holder.Reference<LuckyBlockVariant>> randomOption =
                serverLevel.registryAccess().registryOrThrow(ModRegistries.LUCKY_BLOCK_VARIANTS).getRandom(serverLevel.random);

        boolean doVariantExist = randomOption.isPresent();
        if(doVariantExist) {
            LuckyBlockVariant variant = randomOption.get().value();
            if (serverLevel.random.nextFloat() < variant.chanceToDropNothing()) {
                serverLevel.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                return InteractionResult.CONSUME;
            }

            LootTable lootTable = serverLevel.getServer()
                    .reloadableRegistries()
                    .getLootTable(variant.lootTable());

            LootParams lootParams = new LootParams.Builder(serverLevel)
                    .withParameter(LootContextParams.ORIGIN, player.position())
                    .withOptionalParameter(LootContextParams.THIS_ENTITY, player)
                    .withLuck(player.getLuck())
                    .create(lootTable.getParamSet());

            List<ItemStack> items = lootTable.getRandomItems(lootParams);

            for (ItemStack stack : items) {
                Containers.dropItemStack(serverLevel, pos.getX(), pos.getY(), pos.getZ(), stack);
            }

            serverLevel.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);

        } else {
            return InteractionResult.CONSUME;
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (level.isClientSide()) return;

        if (level.hasNeighborSignal(pos)) {
            ServerLevel serverLevel = (ServerLevel) level;

            Optional<Holder.Reference<LuckyBlockVariant>> randomOption =
                    serverLevel.registryAccess().registryOrThrow(ModRegistries.LUCKY_BLOCK_VARIANTS).getRandom(serverLevel.random);

            boolean doVariantExist = randomOption.isPresent();
            if (doVariantExist) {
                LuckyBlockVariant variant = randomOption.get().value();

                if (serverLevel.random.nextFloat() < variant.chanceToDropNothing()) {
                    serverLevel.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                    return;
                }

                LootTable lootTable = serverLevel.getServer()
                        .reloadableRegistries()
                        .getLootTable(variant.lootTable());

                LootParams lootParams = new LootParams.Builder(serverLevel)
                        .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                        .create(lootTable.getParamSet());

                List<ItemStack> items = lootTable.getRandomItems(lootParams);

                for (ItemStack stack : items) {
                    Containers.dropItemStack(serverLevel, pos.getX(), pos.getY(), pos.getZ(), stack);
                }

                serverLevel.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
            } else {
                serverLevel.setBlock(pos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
            }
        }
    }
}
