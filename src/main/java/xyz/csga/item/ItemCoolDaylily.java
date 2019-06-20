package xyz.csga.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Timer;
import java.util.TimerTask;

public class ItemCoolDaylily extends ItemFoodBase {

    public ItemCoolDaylily() {
        super(2, 0, false, "cool_daylily");
        setCreativeTab(CreativeTabs.FOOD);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
        super.onFoodEaten(stack,worldIn,player);
        if(!worldIn.isRemote){
            player.addExperience(2);
        }
    }
}
