package com.tournament.obj.impl;

import com.tournament.obj.ITournament;
import com.tournament.obj.ITournamentPlayer;
import org.bukkit.entity.Player;

public class TournamentPlayer implements ITournamentPlayer {


    private final Player player;
    public TournamentPlayer(Player player) {
        this.player = player;
    }
    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public int getKills() {
        return 0;
    }
}
