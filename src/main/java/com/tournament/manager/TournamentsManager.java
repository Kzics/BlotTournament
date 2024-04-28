package com.tournament.manager;

import com.tournament.obj.impl.tournaments.SoloTournament;

import java.util.HashMap;
import java.util.Map;

public class TournamentsManager {
    private final HashMap<String, SoloTournament> tournaments;

    public TournamentsManager(){
        this.tournaments = new HashMap<>();
    }

    public HashMap<String, SoloTournament> getTournaments() {
        return tournaments;
    }

    public HashMap<String, SoloTournament> getActiveTournaments() {
        HashMap<String, SoloTournament> activeTournaments = new HashMap<>();
        for (Map.Entry<String, SoloTournament> entry : tournaments.entrySet()) {
            if (entry.getValue().hasStarted()) {
                activeTournaments.put(entry.getKey(), entry.getValue());
            }
        }
        return activeTournaments;
    }

    public HashMap<String, SoloTournament> getPendingTournaments() {
        HashMap<String, SoloTournament> pendingTournaments = new HashMap<>();
        for (Map.Entry<String, SoloTournament> entry : tournaments.entrySet()) {
            if (!entry.getValue().hasStarted()) {
                pendingTournaments.put(entry.getKey(), entry.getValue());
            }
        }
        return pendingTournaments;
    }

    public void addTournament(SoloTournament soloTournament){
        tournaments.put(soloTournament.getArenaId(), soloTournament);
    }

    public void removeTournament(String arenaId){
        tournaments.remove(arenaId);
    }

    public SoloTournament getTournament(String arenaId){
        return tournaments.get(arenaId);
    }

    public boolean exists(String arenaId){
        return tournaments.containsKey(arenaId);
    }

    public boolean isPlaying(String arenaId){
        return tournaments.containsKey(arenaId) && tournaments.get(arenaId).hasStarted();
    }

    public void startTournament(String arenaId, int maxPlayers, int maxRound){
        if(!tournaments.containsKey(arenaId)) return;

        SoloTournament soloTournament = tournaments.get(arenaId);
        soloTournament.start(maxPlayers, maxRound);
    }

    public void endTournament(String arenaId){
        if(!tournaments.containsKey(arenaId)) return;

        SoloTournament soloTournament = tournaments.get(arenaId);
        soloTournament.end();
    }
}