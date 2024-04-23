package com.tournament.manager;

import com.tournament.obj.impl.Tournament;

import java.util.HashMap;

public class TournamentsManager {

    HashMap<String, Tournament> activeTournaments;
    public TournamentsManager(){
        this.activeTournaments = new HashMap<>();
    }

    public HashMap<String, Tournament> getActiveTournaments() {
        return activeTournaments;
    }
}
