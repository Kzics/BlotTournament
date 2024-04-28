package com.tournament.listeners;

import com.tournament.menu.GUI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class InventoryListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();

        if(inv.getHolder() instanceof GUI){
            GUI gui = (GUI) inv.getHolder();
            gui.handle(event);
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent event){
        Inventory inv = event.getInventory();
        Player player = (Player) event.getPlayer();

        if(inv.getHolder() instanceof GUI){
            GUI gui = (GUI) inv.getHolder();
            gui.onClose(player, event.getView());
        }
    }
}
