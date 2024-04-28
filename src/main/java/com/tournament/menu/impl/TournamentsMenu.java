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
    public TournamentsMenu(TournamentsManager manager) {
        super(54, "Tournaments");
        this.manager = manager;
    }


    @Override
    public void open(Player player) {
        super.open(player);

        manager.getTournaments().values().forEach(tournament -> {
            TournamentButton tournamentButton = new TournamentButton(tournament.getArenaId(),
                    List.of(), tournament);
            ItemStack itemStack = tournamentButton.getButton();

            inventory.addItem(itemStack);

            this.buttons.put(itemStack, tournamentButton);
        });

        player.openInventory(inventory);
    }

    @Override
    public void handle(InventoryClickEvent event) {
        event.setCancelled(true);
        ItemStack itemStack = event.getCurrentItem();
        System.out.println("Here");

        Button button = buttons.get(itemStack);
        buttons.values().forEach(b-> System.out.println(b.getButton().getType()));
        System.out.println(itemStack.getType());
        if (button != null) {
            button.handleClick(event);
            System.out.println("handling");
        }else{
            System.out.println("not handling");

        }
    }

    @Override
    public @NotNull Inventory getInventory() {
        return inventory;
    }
}
