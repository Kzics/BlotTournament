package com.tournament.obj.impl;

import com.tournament.obj.ITournament;
import it.unimi.dsi.fastutil.Hash;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Tournament implements ITournament {


    private final String arenaId;
    private int maxRound;
    private int currentRound;
    private HashMap<UUID, TournamentPlayer> activePlayers;

    public Tournament(String arenaId){
        this.arenaId = arenaId;
        this.activePlayers = new HashMap<>();
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
        return 0;
    }

    @Override
    public HashMap<UUID,TournamentPlayer> getActivePlayers() {
        return activePlayers;
    }

    @Override
    public List<UUID> getSpectators() {
        return null;
    }

    @Override
    public void addSpectator(UUID uuid) {

    }

    @Override
    public void removeSpectator(UUID uuid) {

    }

    @Override
    public void addActivePlayer(TournamentPlayer player) {
        activePlayers.put(player.getPlayer().getUniqueId(), player);
    }

    @Override
    public void removeActivePlayer(UUID uuid) {
        activePlayers.remove(uuid);
    }
}
