package com.tournament.obj;

import com.tournament.SpawnPoint;
import com.tournament.enums.MessageType;
import com.tournament.obj.impl.Kit;
import com.tournament.obj.impl.TournamentPlayer;
import org.bukkit.entity.Player;

public interface ITournamentPlayer {


    Player getPlayer();
    int getKills();
    void teleport(SpawnPoint spawnPoint);
    void sendMessage(MessageType messageType, TournamentPlayer player);

    void retrieveKit(Kit kit);
}
