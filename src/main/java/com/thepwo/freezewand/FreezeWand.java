package com.thepwo.freezewand;

import com.thepwo.freezewand.commands.WandCommand;
import com.thepwo.freezewand.events.FreezeListener;
import com.thepwo.freezewand.events.MoveListener;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class FreezeWand extends JavaPlugin {
    private static FreezeWand plugin;
    private List<UUID> frozenPlayers;

    @Override
    public void onEnable() {
        plugin = this;
        this.frozenPlayers = new ArrayList<>();
        registerCommands();
        registerEvents();
        getLogger().info("FreezeWand Disabled!");
    }

    public ItemStack getWandItem() {
        ItemStack itemStack = new ItemStack(Material.STICK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("Freeze Wand");
        itemMeta.addEnchant(Enchantment.RIPTIDE, 1, true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    private void registerCommands() {
        (new WandCommand()).register();
    }

    private void registerEvents() {
        (new FreezeListener()).register();
        (new MoveListener()).register();
    }

    @Override
    public void onDisable() {
        getLogger().info("FreezeWand Enabled!");
    }

    public static FreezeWand getPlugin() {
        return plugin;
    }

    public boolean isFrozen(UUID uuid) {
        return this.frozenPlayers.contains(uuid);
    }

    public void freeze(UUID uuid) {
        this.frozenPlayers.add(uuid);
    }

    public void unfreeze(UUID uuid) {
        this.frozenPlayers.remove(uuid);
    }
}
