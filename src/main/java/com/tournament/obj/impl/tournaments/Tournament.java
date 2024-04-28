package com.tournament.obj.impl.tournaments;

import com.tournament.SpawnPoint;
import com.tournament.obj.ITournament;
import com.tournament.obj.Round;
import com.tournament.obj.impl.Kit;
import com.tournament.obj.impl.TournamentFight;
import com.tournament.obj.impl.TournamentPlayer;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public abstract class Tournament implements ITournament {
    protected final String arenaId;
    protected int maxRound;
    protected Round currentRound;
    protected final HashMap<UUID, TournamentPlayer> activePlayers;
    protected final List<UUID> spectators;
    protected Queue<TournamentFight> fights;
    protected boolean isPlaying;
    protected Kit kit;
    protected int maxPlayers;
    protected SpawnPoint[] spawnLocations;

    protected Tournament(String arenaId) {
        this.arenaId = arenaId;
        this.activePlayers = new HashMap<>();
        this.spectators = new java.util.ArrayList<>();
        this.spawnLocations = new SpawnPoint[2];
        this.fights = new ConcurrentLinkedDeque<>();
    }

    @Override
    public void addSpectator(Player player) {
        spectators.add(player.getUniqueId());

        player.setGameMode(GameMode.SPECTATOR);

        player.teleport(getSpawnPoint(1).getLocation());
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
    public void start(int maxPlayers, int maxRound) {
        isPlaying = true;
        this.maxPlayers = maxPlayers;
        this.maxRound = maxRound;
    }

    @Override
    public SpawnPoint getSpawnPoint(int position) {
        return spawnLocations[position];
    }
    @Override
    public void setSpawnPoint(int position, SpawnPoint spawnPoint) {
        spawnLocations[position] = spawnPoint;
    }
}
