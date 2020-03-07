package rip.oxen.xeffects.inventory;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import rip.oxen.xeffects.utils.ItemBuilder;
import rip.oxen.xeffects.utils.Utils;
import rip.oxen.xeffects.xEffects;

import java.util.ArrayList;
import java.util.List;

public class EffectsInventory {

    private Inventory inv;
    private Player player;
    private xEffects plugin;

    public EffectsInventory(Player player, xEffects plugin){
        this.player = player;
        this.plugin = plugin;
        this.inv = Bukkit.createInventory(null, plugin.getConfig().getInt("Inventory.size"), Utils.translate(plugin.getConfig().getString("Inventory.title")));

        // SPEED

        List<String> speedLore = new ArrayList<>();
        for(String lores : plugin.getConfig().getStringList("Effects.SPEED.item.lore")){
            speedLore.add(Utils.translate(lores));
        }
        if(!(player.hasPermission("xeffects.speed"))){
            speedLore.add(" ");
            speedLore.add("&cYou do not have permission to use this effect.");
        }
        ItemStack speedItem = new ItemBuilder(Material.matchMaterial(plugin.getConfig().getString("Effects.SPEED.item.material"))).setName(Utils.translate(plugin.getConfig().getString("Effects.SPEED.item.name"))).setLore(speedLore).toItemStack();

        // FIRE RES

        List<String> fireresLore = new ArrayList<>();
        for(String lores : plugin.getConfig().getStringList("Effects.FIRE.item.lore")){
            speedLore.add(Utils.translate(lores));
        }
        if(!(player.hasPermission("xeffects.fireres"))){
            speedLore.add(" ");
            speedLore.add("&cYou do not have permission to use this effect.");
        }
        ItemStack fireresItem = new ItemBuilder(Material.matchMaterial(plugin.getConfig().getString("Effects.FIRE.item.material"))).setName(Utils.translate(plugin.getConfig().getString("Effects.FIRE.item.name"))).setLore(fireresLore).toItemStack();

        // INVIS

        List<String> invisLore = new ArrayList<>();
        for(String lores : plugin.getConfig().getStringList("Effects.INVIS.item.lore")){
            speedLore.add(Utils.translate(lores));
        }
        if(!(player.hasPermission("xeffects.invis"))){
            speedLore.add(" ");
            speedLore.add("&cYou do not have permission to use this effect.");
        }
        ItemStack invisItem = new ItemBuilder(Material.matchMaterial(plugin.getConfig().getString("Effects.INVIS.item.material"))).setName(Utils.translate(plugin.getConfig().getString("Effects.INVIS.item.name"))).setLore(invisLore).toItemStack();

        // CHECKING IF THE ITEMS ARE ENABLED OR NOT AND PUTTING THEM IN THE GUI

        if(plugin.getConfig().getBoolean("Effects.SPEED.enabled")){
            inv.setItem(plugin.getConfig().getInt("Effects.SPEED.slot"), speedItem);
        }

        if(plugin.getConfig().getBoolean("Effects.FIRE.enabled")){
            inv.setItem(plugin.getConfig().getInt("Effects.FIRE.slot"), fireresItem);
        }

        if(plugin.getConfig().getBoolean("Effects.INVIS.enabled")){
            inv.setItem(plugin.getConfig().getInt("Effects.INVIS.slot"), invisItem);
        }


    }

    public void openInventory(){
        player.openInventory(inv);
    }
}
