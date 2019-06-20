package xyz.csga;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {
    public static void registerCraftingRecipes(){

    }
    public static void registerSmeltingRecipes(){
        GameRegistry.addSmelting(ModItems.daylily, new ItemStack(ModItems.cooked_daylily), 1);
    }
}
