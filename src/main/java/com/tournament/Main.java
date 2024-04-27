package com.tournament;

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
    }

    public KitsManager getKitsManager() {
        return kitsManager;
    }

    public TournamentsManager getTournamentsManager() {
        return tournamentsManager;
    }
}
