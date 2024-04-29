package com.tournament.commands.tournament.sub;

import com.tournament.Main;
import com.tournament.commands.ICommand;
import com.tournament.obj.impl.TournamentPlayer;
import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EliminateTournamentCommand implements ICommand {

    private final Main main;
    public EliminateTournamentCommand(final Main main) {
        this.main = main;
    }

    @Override
    public String getName() {
        return "eliminate";
    }

    @Override
    public String getDescription() {
        return "Eliminates a player from the tournament";
    }

    @Override
    public String getPermission() {
        return "tournament.eliminate";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length != 3) {
            sender.sendMessage("Invalid usage! /tournament eliminate <arena name> <player>");
            return;
        }

        Tournament tournament = main.getTournamentsManager().getTournament(args[1]);

        if(tournament == null) {
            sender.sendMessage("Tournament not found!");
            return;
        }

        if(!tournament.hasStarted()){
            sender.sendMessage("Tournament has not started yet!");
            return;
        }

        final Player target = main.getServer().getPlayer(args[2]);

        if(target == null) {
            sender.sendMessage("Player not found!");
            return;
        }

        TournamentPlayer player = tournament.getActivePlayers().get(target.getUniqueId());

        tournament.eliminate(player);
    }
}
