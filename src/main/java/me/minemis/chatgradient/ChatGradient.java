package me.minemis.chatgradient;

import me.minemis.chatgradient.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatGradient extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("gradient").setExecutor(new TestCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
