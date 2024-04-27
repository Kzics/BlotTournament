package com.tournament.obj.impl;

import com.tournament.obj.IKit;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Kit implements IKit {
    private final String id;
    private HashMap<Integer, SlotItem> slotItems;

    public Kit(String id) {
        this.id = id;
        this.slotItems = new HashMap<>();
    }

    @Override
    public String getId() {
        return id;
    }

    public HashMap<Integer, SlotItem> getSlotItems() {
        return slotItems;
    }

    public void addItem(int slot, ItemStack item, SlotType slotType) {
        slotItems.put(slot, new SlotItem(item, slotType));
    }
}

class SlotItem {
    private ItemStack item;
    private SlotType slotType;

    public SlotItem(ItemStack item, SlotType slotType) {
        this.item = item;
        this.slotType = slotType;
    }

    public ItemStack getItem() {
        return item;
    }

    public SlotType getSlotType() {
        return slotType;
    }
}

