package dev.footer.general_silicon.extensions;

import dev.footer.general_silicon.init.Blocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;

public class SilicaBuddingBlock extends BuddingAmethystBlock {

    private static final Direction[] DIRECTIONS = Direction.values();
    public SilicaBuddingBlock(Properties properties) {
        super(Properties.of(Material.AMETHYST)
                .strength(1.5f, 1.5f)
                .randomTicks()
                .requiresCorrectToolForDrops()
        );
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        if (source.nextInt(5) == 0) {
            Direction dir = DIRECTIONS[source.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = pos.relative(dir);
            BlockState blockState = level.getBlockState(blockpos);
            Block block = null;
            if (canClusterGrowAtState(blockState)) {
                block = Blocks.SMALL_SILICA_BUD.get();
            } else if (blockState.is(Blocks.SMALL_SILICA_BUD.get()) && blockState.getValue(AmethystClusterBlock.FACING) == dir) {
                block = Blocks.MEDIUM_SILICA_BUD.get();
            } else if (blockState.is(Blocks.MEDIUM_SILICA_BUD.get()) && blockState.getValue(AmethystClusterBlock.FACING) == dir) {
                block = Blocks.LARGE_SILICA_BUD.get();
            } else if (blockState.is(Blocks.LARGE_SILICA_BUD.get()) && blockState.getValue(AmethystClusterBlock.FACING) == dir) {
                block = Blocks.SILICA_CLUSTER.get();
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState().setValue(AmethystClusterBlock.FACING, dir).setValue(AmethystClusterBlock.WATERLOGGED, Boolean.valueOf(blockState.getFluidState().getType() == Fluids.WATER));
                level.setBlockAndUpdate(blockpos, blockstate1);
            }
        }
    }
}
