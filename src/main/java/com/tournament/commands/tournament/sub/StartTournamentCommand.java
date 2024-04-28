package com.tournament.commands.tournament.sub;

import com.tournament.Main;
import com.tournament.commands.ICommand;
import com.tournament.obj.impl.Kit;
import com.tournament.obj.impl.tournaments.SoloTournament;
import org.bukkit.command.CommandSender;

public class StartTournamentCommand implements ICommand {

    private final Main main;
    public StartTournamentCommand(final Main main) {
        this.main = main;
    }

    @Override
    public String getName() {
        return "start";
    }

    @Override
    public String getDescription() {
        return "Start a new tournament";
    }

    @Override
    public String getPermission() {
        return "tournament.start";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length != 5){
            sender.sendMessage("Usage: /tournament start <arena name> <kit name> <# players> <rounds>");
            return;
        }

        String arenaName = args[1];
        String kitName = args[2];
        int players = Integer.parseInt(args[3]);
        int rounds = Integer.parseInt(args[4]);


        Kit kit = main.getKitsManager().getKit(kitName);
        if(kit == null){
            sender.sendMessage("Kit not found");
            return;
        }

        main.getTournamentsManager().startTournament(arenaName, players, rounds);
    }
}
