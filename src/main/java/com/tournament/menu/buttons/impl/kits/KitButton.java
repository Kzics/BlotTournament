package com.tournament.menu.buttons.impl.kits;

import com.tournament.enums.WatchType;
import com.tournament.menu.buttons.Button;
import com.tournament.menu.impl.kits.KitInfoMenu;
import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.List;

public class KitButton extends Button {
    private final Tournament tournament;
    public KitButton(String name, List<String> lore, Tournament tournament) {
        super(Material.DIAMOND_SWORD, name, lore, 0);
        this.tournament = tournament;
    }

    @Override
    public void handleClick(InventoryClickEvent event) {
        new KitInfoMenu(tournament.getKit().get(), WatchType.SHOW).open((Player) event.getWhoClicked());
    }
}
