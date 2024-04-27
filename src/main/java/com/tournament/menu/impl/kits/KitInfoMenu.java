package com.tournament.menu.impl.kits;

import com.tournament.enums.WatchType;
import com.tournament.menu.GUI;
import com.tournament.obj.impl.Kit;
import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class KitInfoMenu extends GUI {

    private final Kit kit;
    private final WatchType watchType;
    public KitInfoMenu(Kit kit, WatchType watchType) {
        super(54, "Edit Kit");
        this.kit = kit;
        this.watchType = watchType;
    }

    @Override
    public void open(Player player) {
        super.open(player);

        ItemStack glass = new ItemStack(Material.BARRIER);
        for (int i = 4; i < 17; i++) {
            inventory.setItem(i, glass);
        }

        if (kit != null) {
            kit.getSlotItems().forEach(inventory::setItem);
        }

        player.openInventory(inventory);
    }

    @Override
    public void handle(InventoryClickEvent event) {
        final Player player = (Player) event.getWhoClicked();
        ItemStack itemStack = event.getCurrentItem();
        if(itemStack == null) return;

        if(watchType == WatchType.SHOW) {
            event.setCancelled(true);
            return;
        }

        if(itemStack.getType() == Material.BARRIER) {
            event.setCancelled(true);
        }

    }

    @Override
    public void onClose(Player player, InventoryView view) {
        if(watchType == WatchType.SHOW) return;

        if (player.hasPermission("tournament.admin")) {
            for (int i = 0; i < 36; i++) {
                ItemStack itemStack = view.getItem(i);
                if (itemStack != null) {
                    if (i < 5) {
                        kit.addArmorItem(itemStack);
                    } else {
                        kit.addItem(i, itemStack);
                    }
                }
            }
        }
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
