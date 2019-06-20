package xyz.csga.registry;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import xyz.csga.ModItems;

@Mod.EventBusSubscriber
public class RecipesRegistry {
    public static void init(){
        GameRegistry.addSmelting(ModItems.daylily, new ItemStack(ModItems.cooked_daylily),1);
    }
}
