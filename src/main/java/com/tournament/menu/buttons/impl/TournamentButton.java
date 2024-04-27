package com.tournament.menu.buttons.impl;

import com.tournament.manager.TournamentsManager;
import com.tournament.menu.buttons.Button;
import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

public class TournamentButton extends Button {
    private final Tournament tournament;
    public TournamentButton(String name, List<String> lore, Tournament tournament) {
        super(Material.GOLD_BLOCK, name, lore,0);
        this.tournament = tournament;
    }

    @Override
    public void handleClick(InventoryClickEvent event) {

    }
}
