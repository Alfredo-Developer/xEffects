package rip.oxen.xeffects.commnads;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import rip.oxen.xeffects.utils.Utils;

public class FireResEffectCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if(!(cs instanceof Player)){
            cs.sendMessage(Utils.translate("&cThis can only be used by players silly goose."));
            return true;
        }

        Player player = (Player) cs;
        if(!(player.hasPermission("xeffects.fireres"))){
            Utils.sendMessage(player, "&cNo Permission.");
            return true;
        }

        if(player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)){
            player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
            Utils.sendMessage(player, "&cDisabled Fire Resistance");
        }else{
            player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
            Utils.sendMessage(player, "&aEnabled Fire Resistance");
        }
        return false;
    }
}
