package com.tournament.menu.buttons;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public abstract class Button {
    protected ItemStack button;
    protected ItemMeta meta;


    public Button(Material icon, String name, List<String> lore, int modelData) {
        this.button = new ItemStack(icon);
        this.meta = button.getItemMeta();
        if(modelData != -1){
            this.meta.setCustomModelData(modelData);
        }
        this.meta.setDisplayName(name);
        this.meta.setLore(lore);
        this.button.setItemMeta(meta);
    }

    public ItemStack getButton() {
        return this.button;
    }

    public abstract void handleClick(InventoryClickEvent event);
}