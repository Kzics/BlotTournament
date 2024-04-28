package com.tournament.obj;

import com.tournament.obj.impl.TournamentFight;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Round {

    private final int round;
    private final Queue<TournamentFight> fights;
    private TournamentFight currentFight;
    public Round(int round){
        this.round = round;
        this.fights = new ConcurrentLinkedDeque<>();
    }


    public TournamentFight nextFight(){
        currentFight = fights.poll();

        return currentFight;
    }

    public TournamentFight getCurrentFight() {
        return currentFight;
    }

    public int getCount() {
        return round;
    }
}
