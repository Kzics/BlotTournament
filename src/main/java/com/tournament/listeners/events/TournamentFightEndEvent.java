package com.tournament.listeners.events;

import com.tournament.obj.impl.TournamentFight;
import com.tournament.obj.impl.tournaments.SoloTournament;
import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class TournamentFightEndEvent extends Event implements Cancellable {

    public static HandlerList hList = new HandlerList();
    private final SoloTournament tournament;
    private final TournamentFight fight;
    private final UUID winner;
    private final UUID loser;

    public TournamentFightEndEvent(SoloTournament tournament, TournamentFight fight, UUID winner, UUID loser) {
        this.tournament = tournament;
        this.fight = fight;
        this.winner = winner;
        this.loser = loser;
    }


    public UUID getLoser() {
        return loser;
    }

    public UUID getWinner() {
        return winner;
    }

    public TournamentFight getFight() {
        return fight;
    }

    public SoloTournament getTournament() {
        return tournament;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean b) {

    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return hList;
    }
    public static HandlerList getHandlerList() {
        return hList;
    }

}
