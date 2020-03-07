package rip.oxen.xeffects.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Utils {

    public static String translate(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static void sendMessage(Player player, String msg){
        player.sendMessage(translate(msg));
    }
}
