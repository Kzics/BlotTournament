package com.tournament.obj.impl;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TournamentFight {
    private UUID participant1;
    private UUID participant2;
    private UUID winner;
    private final List<UUID> fighters;

    public TournamentFight(UUID participant1, UUID participant2) {
        this.participant1 = participant1;
        this.participant2 = participant2;
        this.fighters = new ArrayList<>();
    }

    public UUID getParticipant1() {
        return participant1;
    }

    public UUID getParticipant2() {
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