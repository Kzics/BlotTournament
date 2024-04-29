package com.tournament.obj.impl;

import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.GameMode;

import java.util.*;

public class TournamentFight {
    private TournamentPlayer participant1;
    private TournamentPlayer participant2;
    private UUID winner;
    private final List<UUID> fighters;
    private int round;
    private final HashMap<TournamentPlayer,Integer> score;

    public TournamentFight(TournamentPlayer participant1, TournamentPlayer participant2) {
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.fighters = new ArrayList<>();
        this.round = 0;
        this.score = new HashMap<>();

        this.fighters.add(participant1.getPlayer().getUniqueId());
        if(participant2 != null) this.fighters.add(participant2.getPlayer().getUniqueId());
    }

    public int getRound() {
        return round;
    }

    public void start(Tournament tournament, int winner){
        round ++;
        if(winner != -1) {
            score.put(winner == 1 ? participant1 : participant2, score.getOrDefault(winner == 1 ? participant1 : participant2, 0) + 1);
        }
        participant1.retrieveKit(tournament.getKit().get());
        if(participant2 != null) participant2.retrieveKit(tournament.getKit().get());

        getParticipant1().getPlayer().setGameMode(GameMode.SURVIVAL);
        getParticipant2().getPlayer().setGameMode(GameMode.SURVIVAL);

        getParticipant1().teleport(tournament.getSpawnPoint(0));
        getParticipant2().teleport(tournament.getSpawnPoint(1));
    }

    public int getScore(int participant){
        return score.getOrDefault(participant == 1 ? participant1 : participant2,0);
    }


    public TournamentPlayer getParticipant1() {
        return participant1;
    }

    public TournamentPlayer getParticipant2() {
        return participant2;
    }

    public UUID getWinner() {
        return winner;
    }

    public void setWinner(UUID winner) {
        this.winner = winner;
    }

    public List<UUID> getFighters() {
        return fighters;
    }
}