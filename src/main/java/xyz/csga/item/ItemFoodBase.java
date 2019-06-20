package xyz.csga.item;

import net.minecraft.item.ItemFood;

public class ItemFoodBase extends ItemFood {

    protected String name;

    public ItemFoodBase(int amount, float saturation, boolean isWolfFood, String name) {
        super(amount, saturation, isWolfFood);
        setRegistryName(name);
        setUnlocalizedName(name);
    }
}
