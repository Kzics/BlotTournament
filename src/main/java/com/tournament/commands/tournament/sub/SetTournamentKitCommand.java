package com.tournament.commands.tournament.sub;

import com.tournament.Main;
import com.tournament.commands.ICommand;
import com.tournament.obj.impl.Kit;
import com.tournament.obj.impl.tournaments.SoloTournament;
import org.bukkit.command.CommandSender;

public class SetTournamentKitCommand implements ICommand {


    private final Main main;
    public SetTournamentKitCommand(final Main main) {
        this.main = main;

    }
    @Override
    public String getName() {
        return "setkit";
    }

    @Override
    public String getDescription() {
        return "Set the kit for the tournament";
    }

    @Override
    public String getPermission() {
        return "tournament.setkit";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length != 2){
            sender.sendMessage("Usage: /tournament setkit <arena name> <kit name>");
            return;
        }

        String tournamentName = args[0];
        String kitName = args[1];

        SoloTournament tournament = main.getTournamentsManager().getTournament(tournamentName);
        if(tournament == null){
            sender.sendMessage("Tournament not found");
            return;
        }

        Kit kit = main.getKitsManager().getKit(kitName);
        if(kit == null){
            sender.sendMessage("Kit not found");
            return;
        }

        tournament.setKit(kit);


    }
}
