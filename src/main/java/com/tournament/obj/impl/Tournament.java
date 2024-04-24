package com.tournament.obj.impl;

import com.tournament.obj.ITournament;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Tournament implements ITournament {

    private final String arenaId;
    private int maxRound;
    private int currentRound;
    private final HashMap<UUID, TournamentPlayer> activePlayers;
    private final List<UUID> spectators;
    private boolean isPlaying;

    public Tournament(String arenaId){
        this.arenaId = arenaId;
        this.activePlayers = new HashMap<>();
        this.spectators = new ArrayList<>();
    }

    @Override
    public String getArenaId() {
        return arenaId;
    }

    @Override
    public int getMaxRound() {
        return this.maxRound;
    }

    @Override
    public int getCurrentRound() {
        return this.currentRound;
    }

    @Override
    public int nextRound() {
        return ++this.currentRound;
    }

    @Override
    public HashMap<UUID,TournamentPlayer> getActivePlayers() {
        return activePlayers;
    }

    @Override
    public List<UUID> getSpectators() {
        return spectators;
    }

    @Override
    public void addSpectator(UUID uuid) {
        spectators.add(uuid);
    }

    @Override
    public void removeSpectator(UUID uuid) {
        spectators.remove(uuid);
    }

    @Override
    public void addActivePlayer(TournamentPlayer player) {
        activePlayers.put(player.getPlayer().getUniqueId(), player);
    }

    @Override
    public void removeActivePlayer(UUID uuid) {
        activePlayers.remove(uuid);
    }

    @Override
    public boolean hasStarted() {
        return this.isPlaying;
    }

    @Override
    public void start() {
        this.isPlaying = true;
    }

    @Override
    public void end() {
        this.isPlaying = false;

    }
}
