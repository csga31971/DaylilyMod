package xyz.csga.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.csga.ModItems;

import java.util.Random;

public class BlockDaylily extends BlockCrops {

    public BlockDaylily(){
        setUnlocalizedName("crop_daylily");
        setRegistryName("crop_daylily");
    }

    @Override
    protected Item getSeed() {
        return ModItems.daylily;
    }

    @Override
    public Item getCrop() {
        return ModItems.daylily;
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient){
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state){
        return true;
    }
}
