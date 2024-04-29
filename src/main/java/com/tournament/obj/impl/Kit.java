package com.tournament.obj.impl;

import com.tournament.obj.IKit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class Kit implements IKit {
    private final String id;
    private final HashMap<Integer, ItemStack> slotItems;
    private final List<ItemStack> armorItems;
    public Kit(String id) {
        this.id = id;
        this.slotItems = new HashMap<>();
        this.armorItems = new java.util.ArrayList<>();
    }

    @Override
    public String getId() {
        return id;
    }

    public HashMap<Integer, ItemStack> getSlotItems() {
        return slotItems;
    }

    public List<ItemStack> getArmorItems() {
        return armorItems;
    }

    public void addArmorItem(ItemStack item) {
        armorItems.add(item);
    }

    public void addItem(int slot, ItemStack item) {
        slotItems.put(slot, item);
    }

    @Override
    public void apply(Player player) {
        player.getInventory().clear();
        slotItems.forEach(player.getInventory()::setItem);
        player.getInventory().setArmorContents(armorItems.toArray(new ItemStack[0]));
    }
}


