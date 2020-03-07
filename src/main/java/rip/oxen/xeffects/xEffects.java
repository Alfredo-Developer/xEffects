package rip.oxen.xeffects;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import rip.oxen.xeffects.commnads.EffectsCommand;
import rip.oxen.xeffects.license.AdvancedLicense;

public class xEffects extends JavaPlugin {

    @Getter
    private static xEffects instance;

    @Override
    public void onEnable() {
        instance = this;
        System.out.println("[xEffects] xEffects has been Enabled.");
        System.out.println("-----------------------");
        System.out.println("Loading Config...");
        loadConfig();
        System.out.println("Config Loaded");
        System.out.println("-----------------------");
        System.out.println("Checking License...");
        checkLicense();
        System.out.println("Completed");
        System.out.println("-----------------------");
        System.out.println("Registering Commands...");
        registerCommands();
        System.out.println("Registered Commands");
        System.out.println("-----------------------");
        System.out.println("Register Listeners...");
        registerListeners();
        System.out.println("Registered Listeners");
    }

    @Override
    public void onDisable() {
        System.out.println("[xEffects] xEffects has been Disabled.");
    }

    private void loadConfig(){
        saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }

    private void registerCommands(){
        getCommand("effects").setExecutor(new EffectsCommand());
    }

    private void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
    }

    private void checkLicense(){
        if(!new AdvancedLicense(this.getConfig().getString("license_key"), "http://oxendevelopment.000webhost.com/verify.php", this).register()) return;
    }
}
