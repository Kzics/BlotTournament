package com.tournament.listeners;

import com.tournament.listeners.events.TournamentFightEndEvent;
import com.tournament.obj.impl.TournamentFight;
import com.tournament.obj.impl.tournaments.SoloTournament;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TournamentListeners implements Listener {

    @EventHandler
    public void onEnd(TournamentFightEndEvent event){
        final SoloTournament tournament = event.getTournament();
        final TournamentFight fight = event.getFight();

        fight.setWinner(event.getWinner());

        if(fight.getWinner() != null){
            TournamentFight nextFight = tournament.getCurrentRound().nextFight();
            if(nextFight == null){
                tournament.nextRound();
            }
        }
    }
}
