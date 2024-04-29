package com.tournament.commands.tournament.sub;

import com.tournament.Main;
import com.tournament.commands.ICommand;
import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.command.CommandSender;

public class EndTournamentCommand implements ICommand {

    private final Main main;
    public EndTournamentCommand(final Main main) {
        this.main = main;
    }

    @Override
    public String getName() {
        return "end";
    }

    @Override
    public String getDescription() {
        return "Ends the current tournament";
    }

    @Override
    public String getPermission() {
        return "tournament.end";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length != 2) {
            sender.sendMessage("Invalid usage! /tournament end <arena name>");
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

        tournament.end();

        sender.sendMessage("Tournament ended!");
    }
}
