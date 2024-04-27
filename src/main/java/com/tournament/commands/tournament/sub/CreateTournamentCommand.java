package com.tournament.commands.tournament.sub;

import com.tournament.Main;
import com.tournament.commands.ICommand;
import com.tournament.obj.impl.Kit;
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
        return "Create a new tournament";
    }

    @Override
    public String getPermission() {
        return "tournament.create";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length != 4){
            sender.sendMessage("Usage: /tournament create <arena name> <kit name> <# players> <rounds>");
            return;
        }

        String arenaName = args[0];
        String kitName = args[1];
        int players = Integer.parseInt(args[2]);
        int rounds = Integer.parseInt(args[3]);


        SoloTournament tournament = new SoloTournament(arenaName, players, rounds);
        Kit kit = main.getKitsManager().getKit(kitName);
        if(kit == null){
            sender.sendMessage("Kit not found");
            return;
        }
        tournament.setKit(kit);

        main.getTournamentsManager().addTournament(tournament);

        sender.sendMessage("Tournament created");
    }
}
