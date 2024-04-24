package com.tournament.manager;

import com.tournament.obj.impl.Tournament;

import java.util.HashMap;

public class TournamentsManager {
    HashMap<String, Tournament> activeTournaments;
    public TournamentsManager(){
        this.activeTournaments = new HashMap<>();
    }

    private HashMap<String, Tournament> getActiveTournaments() {
        return activeTournaments;
    }

    public void addTournament(Tournament tournament){
        activeTournaments.put(tournament.getArenaId(), tournament);
    }

    public void removeTournament(String arenaId){
        activeTournaments.remove(arenaId);
    }

    public Tournament getTournament(String arenaId){
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

        Tournament tournament = getTournament(arenaId);

        if(tournament.hasStarted()) return;

        tournament.start();
    }

    public void endTournament(String arenaId){
        if(!exists(arenaId)) return;

        Tournament tournament = getTournament(arenaId);

        if(!tournament.hasStarted()) return;

        tournament.end();
    }



}
