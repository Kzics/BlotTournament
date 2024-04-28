package com.tournament;

import com.tournament.commands.tournament.TournamentCommand;
import com.tournament.listeners.InventoryListener;
import com.tournament.listeners.PlayerListeners;
import com.tournament.listeners.TournamentListeners;
import com.tournament.manager.KitsManager;
import com.tournament.manager.TournamentsManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    private KitsManager kitsManager;
    private TournamentsManager tournamentsManager;
    @Override
    public void onEnable() {
        kitsManager = new KitsManager();
        tournamentsManager = new TournamentsManager();

        getServer().getPluginManager().registerEvents(new PlayerListeners(this), this);
        getServer().getPluginManager().registerEvents(new TournamentListeners(), this);
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);

        getCommand("tournament").setExecutor(new TournamentCommand(this));
    }

    public KitsManager getKitsManager() {
        return kitsManager;
    }

    public TournamentsManager getTournamentsManager() {
        return tournamentsManager;
    }
}
