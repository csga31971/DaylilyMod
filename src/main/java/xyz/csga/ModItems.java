package xyz.csga;

import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import xyz.csga.item.ItemCookedDaylily;
import xyz.csga.item.ItemCoolDaylily;
import xyz.csga.item.ItemDaylily;

public class ModItems {

    public static ItemDaylily daylily = new ItemDaylily();
    public static ItemCookedDaylily cooked_daylily = new ItemCookedDaylily();
    public static ItemCoolDaylily cool_daylily = new ItemCoolDaylily();

    public static void registerItems(IForgeRegistry<Item> registry) {
        registry.registerAll(
                daylily,cooked_daylily,cool_daylily
        );
    }

    public static void registerModels() {
        DaylilyMod.proxy.registerItemRenderer(daylily, 0, "daylily");
        DaylilyMod.proxy.registerItemRenderer(cooked_daylily, 0, "cooked_daylily");
        DaylilyMod.proxy.registerItemRenderer(cool_daylily, 0, "cool_daylily");
    }
}
