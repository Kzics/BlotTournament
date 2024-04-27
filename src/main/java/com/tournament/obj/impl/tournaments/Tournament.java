package com.tournament.obj.impl.tournaments;

import com.tournament.obj.ITournament;
import com.tournament.obj.impl.Kit;
import com.tournament.obj.impl.TournamentPlayer;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public abstract class Tournament implements ITournament {
    protected final String arenaId;
    protected int maxRound;
    protected int currentRound;
    protected final HashMap<UUID, TournamentPlayer> activePlayers;
    protected final List<UUID> spectators;
    protected boolean isPlaying;
    protected Kit kit;
    protected int maxPlayers;

    protected Tournament(String arenaId) {
        this.arenaId = arenaId;
        this.activePlayers = new HashMap<>();
        this.spectators = new java.util.ArrayList<>();
    }

    @Override
    public void addSpectator(UUID uuid) {
        spectators.add(uuid);
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
    public void removeSpectator(UUID uuid) {
        spectators.remove(uuid);
    }

    @Override
    public void start() {
        isPlaying = true;
    }
}
