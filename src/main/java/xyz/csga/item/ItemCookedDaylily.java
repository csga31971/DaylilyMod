package xyz.csga.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xyz.csga.ModItems;

public class ItemCookedDaylily extends ItemFoodBase {

    private int tickCount = 0;
    private int cooldown = 30;
    public ItemCookedDaylily() {
        super(6, 3, true, "cooked_daylily");
        setCreativeTab(CreativeTabs.FOOD);
        setMaxStackSize(1);
    }

    @Override
    public void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player){
        super.onFoodEaten(stack,worldIn,player);
        if(!worldIn.isRemote){
            player.addExperience(4);
        }
    }

    @Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
        tickCount++;
        if(tickCount > cooldown){
            entityIn.replaceItemInInventory(itemSlot, new ItemStack(ModItems.cool_daylily, 1));
        }
    }
}
