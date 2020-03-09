package rip.oxen.xeffects;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import rip.oxen.xeffects.commnads.*;
import rip.oxen.xeffects.license.AdvancedLicense;
import rip.oxen.xeffects.listener.EffectGUIListener;

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
        System.out.println("Reloading Config...");
        reloadConfig();
        System.out.println("Config Reloaded");
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
        getCommand("sp").setExecutor(new SpeedEffectCommand());
        getCommand("fr").setExecutor(new FireResEffectCommand());
        getCommand("inv").setExecutor(new InvEffectCommand());
        getCommand("effects").setExecutor(new EffectsCommand());
        getCommand("xeffects").setExecutor(new xEffectsCommand());
    }

    private void registerListeners(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EffectGUIListener(), this);
    }

    private void checkLicense(){
        if(!new AdvancedLicense(this.getConfig().getString("license_key"), "https://oxendevelopment.000webhostapp.com/verify.php", this).setSecurityKey("YecoF0I6M05thxLeokoHuW8iUhTdIUInjkfF").register()) return;
    }
}
