package moe.myuuiii.simplefly;

import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public final class SimpleFly extends JavaPlugin {

    public static String Prefix = ChatColor.GRAY + "[" + ChatColor.GOLD + "Fly" + ChatColor.GRAY + "]"
            + ChatColor.RESET;
    public static String FlyPermission = "flying.allow";
    public static String FlyForOthersPermission = "flying.allowOthers";
    public static String NoPermission = Prefix + " You do not have permission to turn on and off flight for yourself";
    public static String NoPermissionForOthers = Prefix
            + " You do not have permission to turn on and off flight for others";

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fly").setExecutor(new FlyCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
