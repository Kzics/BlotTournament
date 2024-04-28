package com.tournament.menu.impl;

import com.tournament.menu.GUI;
import com.tournament.menu.buttons.Button;
import com.tournament.menu.buttons.impl.kits.KitButton;
import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TournamentInfoMenu extends GUI {
    private final Tournament tournament;
    public TournamentInfoMenu(Tournament tournament) {
        super(54, tournament.getArenaId());
        this.tournament = tournament;
    }

    @Override
    public void open(Player player) {
        super.open(player);

        KitButton kitButton = new KitButton("Kit Info", List.of(),tournament);

        buttons.put(kitButton.getButton(), kitButton);

        inventory.setItem(10, kitButton.getButton());

        player.openInventory(inventory);
    }

    @Override
    public void handle(InventoryClickEvent event) {
        event.setCancelled(true);

        ItemStack itemStack = event.getCurrentItem();

        Button button = buttons.get(itemStack);
        if (button != null) {
            button.handleClick(event);
        }
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
