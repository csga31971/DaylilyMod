package xyz.csga.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import xyz.csga.ModBlocks;

import java.util.Random;

public class ModWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) {
            int x1 = chunkX*16 + random.nextInt(16);
            int z1 = chunkZ*16 + random.nextInt(16);
            BlockPos blockPos;
            for (blockPos = new BlockPos(x1, world.getSeaLevel(), z1); !world.isAirBlock(blockPos.up()); blockPos = blockPos.up())
            {
                ; // loop until blockPos is ground above sealevel
            }
            for (int i = 0; i < 7; i++) {
                BlockPos pos = blockPos.add(x1 + random.nextInt(16), random.nextInt(4) - random.nextInt(4), z1 + random.nextInt(16));

                if (world.isAirBlock(blockPos) && (!world.provider.isNether() || blockPos.getY() < 255))
                {
                    world.setBlockState(pos, ModBlocks.daylily.getDefaultState(), 2);
                }
            }
        }
    }
}
