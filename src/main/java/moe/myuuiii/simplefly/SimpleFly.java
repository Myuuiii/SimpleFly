package moe.myuuiii.simplefly;

import java.awt.Color;

import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public final class SimpleFly extends JavaPlugin {

    public static String Prefix = ChatColor.GRAY + "[" + ChatColor.GOLD + "Fly" + ChatColor.GRAY + "]"
            + ChatColor.RESET;

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
