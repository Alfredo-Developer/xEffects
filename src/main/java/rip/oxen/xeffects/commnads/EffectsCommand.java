package rip.oxen.xeffects.commnads;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rip.oxen.xeffects.inventory.EffectsInventory;
import rip.oxen.xeffects.utils.Utils;
import rip.oxen.xeffects.xEffects;

public class EffectsCommand implements CommandExecutor {

    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        if(!(cs instanceof Player)){
            cs.sendMessage(Utils.translate("&cThis can only be used by players silly goose."));
            return true;
        }

        Player player = (Player) cs;
        if(!(player.hasPermission("xeffects.gui"))){
            Utils.sendMessage(player, "&cNo Permission.");
            return true;
        }

        EffectsInventory effectsInventory = new EffectsInventory(player, xEffects.getInstance());
        effectsInventory.openInventory();
        return false;
    }
}
