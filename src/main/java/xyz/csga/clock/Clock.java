package xyz.csga.clock;

import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;
import org.apache.logging.log4j.Logger;
import xyz.csga.DaylilyMod;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class Clock {
    private static Timer timer;

    private static Logger logger;

    public static void preInit(){
        timer = new Timer();
    }
    public static void init(){
        timer.schedule(new TimerTask() {
            private Calendar calendar;
            @Override
            public void run() {
                calendar = Calendar.getInstance();
                int h = this.calendar.get(Calendar.HOUR_OF_DAY);
                if(h>12)
                    h-=12;
                int m = this.calendar.get(Calendar.MINUTE);
                int s = this.calendar.get(Calendar.SECOND);
                if(s==0) {
                    PlayerList playerList = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList();
                    if(playerList.getPlayers().size()>0){
                        if("true".equals(DaylilyMod.propertyMap.get("debug"))){
                            logger.debug(DaylilyMod.propertyMap.get("fullClock").toString().replace("{}",h+""));
                            playerList.sendMessage(new TextComponentString(
                                    DaylilyMod.propertyMap.get("fullClock").toString().replace("{}",h+"")));
                        }else{
                            if(m==0){
                                playerList.sendMessage(new TextComponentString(
                                        DaylilyMod.propertyMap.get("fullClock").toString().replace("{}",h+"")));
                            }
                        }
                    }
                }
            }
        },0,1000);
    }
}
