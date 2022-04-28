package com.thepwo.freezewand.commands;

import com.thepwo.freezewand.FreezeWand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

public class WandCommand implements CommandExecutor {
    private static final FreezeWand plugin = FreezeWand.getPlugin();

    public void register() {
        PluginCommand command = plugin.getCommand("wand");
        command.setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        player.getInventory().addItem(plugin.getWandItem());

        return false;
    }
}
