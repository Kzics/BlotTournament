package com.tournament.listeners;

import com.tournament.Main;
import com.tournament.listeners.events.TournamentFightEndEvent;
import com.tournament.manager.TournamentsManager;
import com.tournament.obj.impl.tournaments.SoloTournament;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerListeners implements Listener {


    private final TournamentsManager tournamentsManager;
    private final Main main;
    public PlayerListeners(Main main){
        this.tournamentsManager = main.getTournamentsManager();
        this.main = main;
    }


    @EventHandler
    public void onKill(EntityDamageByEntityEvent event){
        final Player player = (Player) event.getEntity();

        if(event.getDamager() instanceof Player) {
            final Player damager = (Player) event.getDamager();

            if(player.getHealth() - event.getFinalDamage() <= 0){
                event.setCancelled(true);
                for (SoloTournament tournament : tournamentsManager.getTournaments().values()){
                    if(tournament.getCurrentRound().getCurrentFight().getFighters().contains(player.getUniqueId())
                            && tournament.getCurrentRound().getCurrentFight().getFighters().contains(damager.getUniqueId())){
                        TournamentFightEndEvent endEvent = new TournamentFightEndEvent(tournament, tournament.getCurrentRound().getCurrentFight()
                                , damager.getUniqueId(), player.getUniqueId());
                        main.getServer().getPluginManager().callEvent(endEvent);
                        return;
                    }
                }
                damager.sendMessage("You killed " + player.getName());
            }
        }
    }
}
