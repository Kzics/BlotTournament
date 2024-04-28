package com.tournament.obj.impl.tournaments;

import com.tournament.obj.Round;
import com.tournament.obj.impl.Kit;
import com.tournament.obj.impl.Team;
import com.tournament.obj.impl.TournamentPlayer;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TeamTournament extends Tournament{

    private final HashMap<String, Team> teams = new HashMap<>();

    public TeamTournament(String arenaId){
        super(arenaId);
    }
    @Override
    public String getArenaId() {
        return arenaId;
    }

    @Override
    public int getMaxRound() {
        return maxRound;
    }

    @Override
    public Round getCurrentRound() {
        return currentRound;
    }

    @Override
    public void nextRound() {
        currentRound = new Round(currentRound.getCount() + 1);
    }

    @Override
    public HashMap<UUID, TournamentPlayer> getActivePlayers() {
        return activePlayers;
    }

    @Override
    public List<UUID> getSpectators() {
        return spectators;
    }

    @Override
    public boolean hasStarted() {
        return isPlaying;
    }

    @Override
    public void start(int maxPlayers, int maxRound) {
        this.isPlaying = true;
    }

    @Override
    public void end() {
        this.isPlaying = false;
    }

    @Override
    public Optional<Kit> getKit() {
        return Optional.empty();
    }

    @Override
    public void setKit(Kit kit) {

    }

    public void joinTeam(UUID player, String name){
        Team team = teams.get(name);
        team.getMembers().add(player);
    }

    public void leaveTeam(UUID player, String name){
        Team team = teams.get(name);
        team.getMembers().remove(player);
    }

    public boolean createTeam(String name){
        if(teams.containsKey(name)) return false;

        teams.put(name, new Team(name));

        return true;
    }

    public void addTeam(Team team){
        teams.put(team.getName(), team);
    }
}
