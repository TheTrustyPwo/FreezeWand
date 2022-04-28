package com.thepwo.freezewand.events;

import com.thepwo.freezewand.FreezeWand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

public class FreezeListener implements Listener {
    private static final FreezeWand plugin = FreezeWand.getPlugin();

    public void register() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent e) {
        if (!(e.getRightClicked() instanceof Player player) ||
                player.getInventory().getItemInMainHand() != plugin.getWandItem() ||
                e.getHand() != EquipmentSlot.HAND) {
            return;
        }

        boolean frozen = plugin.isFrozen(player.getUniqueId());
        if (frozen) {
            plugin.unfreeze(player.getUniqueId());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou have been unfrozen!"));
        }
        else {
            plugin.freeze(player.getUniqueId());
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou have been frozen!"));
        }
    }
}
