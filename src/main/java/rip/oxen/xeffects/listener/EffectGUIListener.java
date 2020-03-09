package rip.oxen.xeffects.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import rip.oxen.xeffects.utils.Utils;
import rip.oxen.xeffects.xEffects;


public class EffectGUIListener implements Listener {

    @EventHandler
    public void onEffectGUIClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();

        if(!event.getInventory().getName().contains(ChatColor.stripColor("Effects"))) return;

            if (slot == xEffects.getInstance().getConfig().getInt("Effects.SPEED.slot") && xEffects.getInstance().getConfig().getBoolean("Effects.SPEED.enabled")) {
                if (player.hasPotionEffect(PotionEffectType.SPEED)) {
                    player.removePotionEffect(PotionEffectType.SPEED);
                    Utils.sendMessage(player, "&cDisabled Speed");
                } else {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                    Utils.sendMessage(player, "&aEnabled Speed");
                }
            }

            if (slot == xEffects.getInstance().getConfig().getInt("Effects.FIRE.slot") && xEffects.getInstance().getConfig().getBoolean("Effects.FIRE.enabled")) {
                if (player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                    player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                    Utils.sendMessage(player, "&cDisabled Fire Resistance");
                } else {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 1));
                    Utils.sendMessage(player, "&aEnabled Fire Resistance");
                }
            }

            if (slot == xEffects.getInstance().getConfig().getInt("Effects.INVIS.slot") && xEffects.getInstance().getConfig().getBoolean("Effects.INVIS.enabled")) {
                if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                    player.removePotionEffect(PotionEffectType.INVISIBILITY);
                    Utils.sendMessage(player, "&cDisabled Invisibility");
                } else {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
                    Utils.sendMessage(player, "&aEnabled Invisibility");
                }
            }

            event.setCancelled(true);
    }
}
