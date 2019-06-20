package xyz.csga;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;
import xyz.csga.proxy.CommonProxy;
import xyz.csga.world.ModWorldGen;

import java.util.*;

@Mod(modid = DaylilyMod.MODID, name = DaylilyMod.NAME, version = DaylilyMod.VERSION)
public class DaylilyMod {
    public static final String MODID = "daylilymod";
    public static final String NAME = "Daylily Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @SidedProxy(serverSide = "xyz.csga.proxy.CommonProxy", clientSide = "xyz.csga.proxy.ClientProxy")
    public static CommonProxy proxy;
    public static Map<String, Object> propertyMap = new HashMap<>();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 8);
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModRecipes.registerSmeltingRecipes();
    }

    @Mod.EventBusSubscriber
    public static class RegistrySubscriber{
        @SubscribeEvent
        public void onItemRegisty(RegistryEvent.Register<Item> event){
            ModItems.registerItems(event.getRegistry());
            ModItems.registerModels();
        }

        @SubscribeEvent
        public void onBlockRegistry(RegistryEvent.Register<Block> event){
            ModBlocks.registerBlocks(event.getRegistry());
        }
    }

}
