package com.tournament.obj.impl.tournaments;

import com.tournament.SpawnPoint;
import com.tournament.enums.MessageType;
import com.tournament.obj.ITournament;
import com.tournament.obj.Round;
import com.tournament.obj.impl.Kit;
import com.tournament.obj.impl.TournamentFight;
import com.tournament.obj.impl.TournamentPlayer;
import org.bukkit.GameMode;
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
    public void eliminate(TournamentPlayer player) {
        activePlayers.remove(player.getPlayer().getUniqueId());
        player.getPlayer().setGameMode(GameMode.SPECTATOR);

        player.getPlayer().teleport(getSpawnPoint(1).getLocation());
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

        System.out.println("wsh");
        nextRound();
    }

    @Override
    public void end() {
        isPlaying = false;
        TournamentPlayer winner = activePlayers.values().stream().findFirst().orElse(null);
        if(winner != null){
            winner.sendMessage(MessageType.WINNER, false);
        }

        activePlayers.clear();
        spectators.clear();
        fights.clear();
        currentRound = null;
    }

    @Override
    public boolean hasPointSet() {
        return spawnLocations[0] != null && spawnLocations[1] != null;
    }

    @Override
    public void nextRound() {
        if(getActivePlayers().values().size() <= 1){
            end();
            return;
        }

        currentRound = new Round(currentRound == null ? 1 :currentRound.getCount() + 1, activePlayers, this);


        //fight.getParticipant1().sendMessage(MessageType.PREROUND, fight.getParticipant2());
        //fight.getParticipant2().sendMessage(MessageType.PREROUND, fight.getParticipant1());
    }

    public void broadcastMessage(MessageType type){
        for (TournamentPlayer player : activePlayers.values()) {
            player.sendMessage(type, false);
        }
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
