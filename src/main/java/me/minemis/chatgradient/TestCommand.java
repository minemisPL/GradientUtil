package me.minemis.chatgradient;

import me.minemis.chatgradient.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class TestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;

        Color color = new Color(255,255,0);
        Color color2 = new Color(255,0,255);

        player.sendMessage(ChatUtils.gradient("Siemka", color, color2));
        player.sendMessage(ChatUtils.gradient("Siemka hejka cześć", color, color2));
        player.sendMessage(ChatUtils.gradient("Żydzi do gazu", color, color2));
        return false;
    }
}
