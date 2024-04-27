package com.tournament.menu.impl;

import com.tournament.manager.TournamentsManager;
import com.tournament.menu.GUI;
import com.tournament.menu.buttons.Button;
import com.tournament.menu.buttons.impl.TournamentButton;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TournamentsMenu extends GUI {

    private final TournamentsManager manager;
    public TournamentsMenu(int size, String title, TournamentsManager manager) {
        super(size, title);
        this.manager = manager;
    }


    @Override
    public void open(Player player) {
        super.open(player);

        manager.getActiveTournaments().values().forEach(tournament -> {
            TournamentButton tournamentButton = new TournamentButton(tournament.getArenaId(),
                    List.of(), manager);
            ItemStack itemStack = tournamentButton.getButton();

            inventory.addItem(itemStack);
            buttons.put(itemStack, tournamentButton);
        });
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
