package xyz.csga.item;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSeedFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import xyz.csga.ModBlocks;
import xyz.csga.ModItems;

public class ItemDaylily extends ItemSeedFood {


    public ItemDaylily() {
        super(3, 1, ModBlocks.daylily, Blocks.DIRT);
        setUnlocalizedName("daylily");
        setRegistryName("daylily");
        setCreativeTab(CreativeTabs.FOOD);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
        super.onFoodEaten(stack,worldIn,player);
        if(!worldIn.isRemote){
            player.addExperience(1);
        }
    }
}
