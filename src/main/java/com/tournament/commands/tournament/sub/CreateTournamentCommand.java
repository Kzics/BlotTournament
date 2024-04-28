package com.tournament.commands.tournament.sub;

import com.tournament.Main;
import com.tournament.commands.ICommand;
import com.tournament.obj.impl.tournaments.SoloTournament;
import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.command.CommandSender;

public class CreateTournamentCommand implements ICommand {

    private final Main main;
    public CreateTournamentCommand(final Main main) {
        this.main = main;
    }
    @Override
    public String getName() {
        return "create";
    }

    @Override
    public String getDescription() {
        return "Create a tournament";
    }

    @Override
    public String getPermission() {
        return "tournament.create";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length != 2){
            sender.sendMessage("Usage: /tournament create <arena name>");
            return;
        }

        // Create the tournament
        SoloTournament tournament = new SoloTournament(args[1]);
        main.getTournamentsManager().addTournament(tournament);

        sender.sendMessage("Tournament created");
    }
}
