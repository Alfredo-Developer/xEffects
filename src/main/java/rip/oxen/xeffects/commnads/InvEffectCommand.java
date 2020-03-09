package rip.oxen.xeffects.commnads;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import rip.oxen.xeffects.utils.Utils;

public class InvEffectCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if(!(cs instanceof Player)){
            cs.sendMessage(Utils.translate("&cThis can only be used by players silly goose."));
            return true;
        }

        Player player = (Player) cs;
        if(!(player.hasPermission("xeffects.invis"))){
            Utils.sendMessage(player, "&cNo Permission.");
            return true;
        }

        if(player.hasPotionEffect(PotionEffectType.INVISIBILITY)){
            player.removePotionEffect(PotionEffectType.INVISIBILITY);
            Utils.sendMessage(player, "&cDisabled Invisibility");
        }else{
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
            Utils.sendMessage(player, "&aEnabled Invisibility");
        }
        return false;
    }
}
