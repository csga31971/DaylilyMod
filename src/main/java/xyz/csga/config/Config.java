package xyz.csga.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Config {

    private static Logger logger;

    private static Configuration configuration;
    public static Map<String, Object> propertyMap = new HashMap<>();

    public static void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        try {
            configuration = new Configuration(event.getSuggestedConfigurationFile());
            configuration.load();
            Property timeFormatProp = configuration.get(Configuration.CATEGORY_GENERAL, // What category will it be saved to, can be any string
                    "commandTime", // Property name
                    "yyyy-MM-dd HH:mm:ss", // Default value
                    "command /tm response format"); // Comment
            propertyMap.put("commandTime", timeFormatProp.getString());
            Property fullClockProp = configuration.get(Configuration.CATEGORY_GENERAL,
                    "fullCLock",
                    "{} 点 le !!!!!11!!11111",
                    "{} = hour");
            propertyMap.put("fullClock", fullClockProp.getString());
            Property debugProp = configuration.get(Configuration.CATEGORY_GENERAL,
                    "debug",
                    "false",
                    "true=每分钟报时");
            propertyMap.put("debug", debugProp.getString());
            if("true".equals(propertyMap.get("debug"))){
                logger.info("***running in debug mode***");
                logger.info(timeFormatProp.getString());
                logger.info(fullClockProp.getString());
                logger.info(debugProp.getString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (configuration.hasChanged()) configuration.save();
        }
    }
}
