package com.tournament.listeners;

import com.tournament.Main;
import com.tournament.enums.MessageType;
import com.tournament.listeners.events.TournamentFightEndEvent;
import com.tournament.obj.impl.TournamentFight;
import com.tournament.obj.impl.TournamentPlayer;
import com.tournament.obj.impl.tournaments.SoloTournament;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

public class TournamentListeners implements Listener {

    @EventHandler
    public void onEnd(TournamentFightEndEvent event){
        final SoloTournament tournament = event.getTournament();
        final TournamentFight fight = event.getFight();
        final UUID winner = event.getWinner();

        fight.setWinner(event.getWinner());

        for (TournamentPlayer player : tournament.getActivePlayers().values()){
            player.sendMessage(MessageType.FIGHTING_RESULT.format(Bukkit.getPlayer(event.getWinner()).getName()
                    , Bukkit.getPlayer(event.getLoser()).getName())
                    ,false);
        }

        event.getTournament().addSpectator(Bukkit.getPlayer(event.getLoser()));

        if(fight.getWinner() != null){
            TournamentFight nextFight = tournament.getCurrentRound().nextFight();
            if(nextFight == null){
                Bukkit.getScheduler().runTaskLater(Main.getInstance(), ()->{
                    event.getTournament().addSpectator(Bukkit.getPlayer(event.getWinner()));


                    if(fight.getRound() >= tournament.getMaxRound()) {
                        event.getTournament().removeActivePlayer(fight.getScore(1) > fight.getScore(2) ? fight.getParticipant2().getPlayer().getUniqueId() : fight.getParticipant1().getPlayer().getUniqueId());

                        tournament.nextRound();
                    }else{
                        tournament.broadcastMessage(MessageType.FIGHT_SCORE.format(fight.getParticipant1().getPlayer().getName(),fight.getScore(1),
                                fight.getParticipant2().getPlayer().getName(),fight.getScore(2)));
                        Bukkit.getScheduler().runTaskLater(Main.getInstance(), ()->{
                            fight.start(tournament,winner.equals(fight.getParticipant1().getPlayer().getUniqueId()) ? 1 : 2);
                        },20*5);
                    }
                },20);
            }
        }
    }
}
