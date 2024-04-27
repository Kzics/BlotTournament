package com.tournament.manager;

import com.tournament.obj.impl.tournaments.SoloTournament;

import java.util.HashMap;

public class TournamentsManager {
    HashMap<String, SoloTournament> activeTournaments;
    public TournamentsManager(){
        this.activeTournaments = new HashMap<>();
    }

    public HashMap<String, SoloTournament> getActiveTournaments() {
        return activeTournaments;
    }

    public void addTournament(SoloTournament soloTournament){
        activeTournaments.put(soloTournament.getArenaId(), soloTournament);
    }
    public void removeTournament(String arenaId){
        activeTournaments.remove(arenaId);
    }

    public SoloTournament getTournament(String arenaId){
        return activeTournaments.get(arenaId);
    }

    public boolean exists(String arenaId){
        return activeTournaments.containsKey(arenaId);
    }

    public boolean isPlaying(String arenaId){
        return activeTournaments.get(arenaId).hasStarted();
    }

    public void startTournament(String arenaId){
        if(!exists(arenaId)) return;

        SoloTournament soloTournament = getTournament(arenaId);

        if(soloTournament.hasStarted()) return;

        soloTournament.start();
    }

    public void endTournament(String arenaId){
        if(!exists(arenaId)) return;

        SoloTournament soloTournament = getTournament(arenaId);

        if(!soloTournament.hasStarted()) return;

        soloTournament.end();
    }



}
