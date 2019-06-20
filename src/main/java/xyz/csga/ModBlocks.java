package xyz.csga;

import net.minecraft.block.Block;
import net.minecraftforge.registries.IForgeRegistry;
import xyz.csga.block.BlockDaylily;

public class ModBlocks {
    public static final BlockDaylily daylily = new BlockDaylily();

    public static void registerBlocks(IForgeRegistry<Block> registry){
        registry.registerAll(
                daylily
        );
    }
}
