package rip.oxen.xeffects.commnads;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import rip.oxen.xeffects.utils.Utils;
import rip.oxen.xeffects.xEffects;

public class xEffectsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        if(cs.hasPermission("xeffects.admin")){
           cs.sendMessage(Utils.translate("&axEffects &fby &cOxen Development"));
           cs.sendMessage(Utils.translate("&fVersion: &a" + xEffects.getInstance().getDescription().getVersion()));
           cs.sendMessage(Utils.translate("&f&m---------------------------------------"));
           cs.sendMessage(Utils.translate("&fReloading Config"));
           xEffects.getInstance().reloadConfig();
           cs.sendMessage(Utils.translate("&aConfig Reloaded"));
           cs.sendMessage(Utils.translate("&f&m---------------------------------------"));

        }
        return false;
    }
}
