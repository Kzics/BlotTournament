package com.tournament.menu.impl;

import com.tournament.menu.GUI;
import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class TournamentInfoMenu extends GUI {
    private final Tournament tournament;
    public TournamentInfoMenu(Tournament tournament) {
        super(54, tournament.getArenaId());
        this.tournament = tournament;
    }

    @Override
    public void open(Player player) {
        super.open(player);

        player.openInventory(inventory);
    }

    @Override
    public void handle(InventoryClickEvent event) {

    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
