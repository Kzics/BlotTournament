package com.tournament.obj.impl;

import com.tournament.SpawnPoint;
import com.tournament.enums.MessageType;
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

    @Override
    public void teleport(SpawnPoint spawnPoint) {
        player.teleport(spawnPoint.getLocation());
    }

    @Override
    public void sendMessage(MessageType messageType, TournamentPlayer player) {
        player.getPlayer().sendMessage(messageType.getMessage()
                .replace("{player}", player.getPlayer().getName()));
    }

    public void sendMessage(MessageType messageType, boolean action) {
        player.sendMessage(messageType.getMessage());

        if(action) {
            player.sendActionBar(messageType.getMessage());
            player.sendTitle(messageType.getMessage(), null, 10, 70, 20);
        }
    }

    @Override
    public void retrieveKit(Kit kit) {
        kit.apply(player);
    }
}
