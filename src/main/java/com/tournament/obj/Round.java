package com.tournament.obj;

import com.tournament.enums.MessageType;
import com.tournament.obj.impl.TournamentFight;
import com.tournament.obj.impl.TournamentPlayer;
import com.tournament.obj.impl.tournaments.Tournament;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Round {
    private final int round;
    private final Queue<TournamentFight> fights;
    private TournamentFight currentFight;
    private final Tournament tournament;
    public Round(int round, Map<UUID, TournamentPlayer> activePlayers, Tournament tournament){
        this.round = round;
        this.fights = new ConcurrentLinkedDeque<>();
        this.tournament = tournament;


        List<UUID> playerIds = new ArrayList<>(activePlayers.keySet());
        for (int i = 0; i < playerIds.size(); i += 2) {
            TournamentPlayer player1 = activePlayers.get(playerIds.get(i));
            TournamentPlayer player2 = i + 1 < playerIds.size() ? activePlayers.get(playerIds.get(i + 1)) : null;

            TournamentFight currentFight = new TournamentFight(player1, player2);
            fights.add(currentFight);
        }

        MessageType messageType = getStageMessage();

        for (TournamentPlayer player : activePlayers.values()) {
            player.sendMessage(messageType,true);
        }

        nextFight();
    }



    public TournamentFight nextFight(){
        currentFight = fights.poll();
        if(currentFight != null) {
            currentFight.start(tournament,-1);
        }

        return currentFight;
    }

    private MessageType getStageMessage() {
        switch (fights.size()) {
            case 1:
                return MessageType.FINAL;
            case 2:
                return MessageType.SEMI_FINAL;
            case 4:
                return MessageType.QUARTER_FINAL;
        }

        return MessageType.ROUND_START.format(getCount());
    }

    public TournamentFight getCurrentFight() {
        return currentFight;
    }

    public int getCount() {
        return round;
    }
}
