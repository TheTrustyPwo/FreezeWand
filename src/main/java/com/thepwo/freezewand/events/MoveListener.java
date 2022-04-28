package com.thepwo.freezewand.events;

import com.thepwo.freezewand.FreezeWand;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveListener implements Listener {
    private static final FreezeWand plugin = FreezeWand.getPlugin();

    public void register() {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        if (plugin.isFrozen(e.getPlayer().getUniqueId())) {
            e.setCancelled(true);
        }
    }
}
