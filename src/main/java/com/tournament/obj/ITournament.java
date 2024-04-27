package com.tournament.obj;

import com.tournament.obj.impl.Kit;
import com.tournament.obj.impl.TournamentPlayer;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITournament {

    String getArenaId();
    int getMaxRound();
    int getCurrentRound();
    int nextRound();
    HashMap<UUID, TournamentPlayer> getActivePlayers();
    List<UUID> getSpectators();
    void addSpectator(UUID uuid);
    void removeSpectator(UUID uuid);
    void addActivePlayer(TournamentPlayer player);
    void removeActivePlayer(UUID uuid);
    boolean hasStarted();
    void start();
    void end();
    Optional<Kit> getKit();
    void setKit(Kit kit);

}
