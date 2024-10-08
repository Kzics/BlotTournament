package com.tournament.obj.impl.tournaments;
import com.tournament.obj.Round;
import com.tournament.obj.impl.Kit;
import com.tournament.obj.impl.TournamentPlayer;

import java.util.*;

public class SoloTournament extends Tournament {
    public SoloTournament(String arenaId, int players, int maxRound){
        super(arenaId);
        this.maxRound = maxRound;
        this.maxPlayers = players;
    }
    public SoloTournament(String arenaId){
        super(arenaId);
        this.maxRound = 2;
        this.maxPlayers = 2;
    }

    @Override
    public String getArenaId() {
        return this.arenaId;
    }

    @Override
    public int getMaxRound() {
        return this.maxRound;
    }

    @Override
    public Round getCurrentRound() {
        return this.currentRound;
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
    public Optional<Kit> getKit() {
        return Optional.of(kit);
    }

    @Override
    public void setKit(Kit kit) {
        this.kit = kit;
    }

}
