package com.tournament.menu;

import com.tournament.menu.buttons.Button;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public abstract class GUI implements InventoryHolder {
    protected final Inventory inventory;
    protected final HashMap<ItemStack, Button> buttons = new HashMap<>();

    public GUI( int size, String title) {
        this.inventory = Bukkit.createInventory(this, size,  title);
    }

    public void open(Player player){
    }


    public abstract void handle(InventoryClickEvent event);

    public void onClose(Player player, InventoryView view) {
    }
}
