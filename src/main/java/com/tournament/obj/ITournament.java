package com.tournament.obj;

import com.tournament.SpawnPoint;
import com.tournament.obj.impl.Kit;
import com.tournament.obj.impl.TournamentFight;
import com.tournament.obj.impl.TournamentPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ITournament {

    String getArenaId();
    int getMaxRound();
    Round getCurrentRound();
    void nextRound();
    HashMap<UUID, TournamentPlayer> getActivePlayers();
    List<UUID> getSpectators();
    void addSpectator(Player player);
    void removeSpectator(UUID uuid);
    void addActivePlayer(TournamentPlayer player);
    void removeActivePlayer(UUID uuid);
    boolean hasStarted();
    void start(int maxPlayers, int maxRound);
    boolean hasPointSet();
    void eliminate(TournamentPlayer player);
    void end();
    Optional<Kit> getKit();
    void setKit(Kit kit);
    void setSpawnPoint(int position, SpawnPoint spawnPoint);
    SpawnPoint getSpawnPoint(int position);

}
