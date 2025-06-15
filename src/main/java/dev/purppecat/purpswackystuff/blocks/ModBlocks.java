package dev.purppecat.purpswackystuff.blocks;

import dev.purppecat.purpswackystuff.PurpsWackyStuff;
import dev.purppecat.purpswackystuff.blocks.custom.PurpLuckyCharmBlock;
import dev.purppecat.purpswackystuff.items.ModItems;

import dev.thomasglasser.tommylib.api.registration.DeferredBlock;
import dev.thomasglasser.tommylib.api.registration.DeferredRegister;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;


import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PurpsWackyStuff.MOD_ID);

    public static final DeferredBlock<PurpLuckyCharmBlock> PURP_LUCKY_BLOCK = registerBlock("purp_lucky_block",
            () -> new PurpLuckyCharmBlock(BlockBehaviour.Properties.of()
                    .strength(0.2f).sound(SoundType.AMETHYST)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void init() {}
}
