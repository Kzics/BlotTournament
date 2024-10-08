package com.tournament.commands.tournament.sub;

import com.tournament.Main;
import com.tournament.commands.ICommand;
import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LeaveTournamentCommand implements ICommand {

    private final Main main;
    public LeaveTournamentCommand(final Main main) {
        this.main = main;
    }

    @Override
    public String getName() {
        return "leave";
    }

    @Override
    public String getDescription() {
        return "Leave the tournament";
    }

    @Override
    public String getPermission() {
        return "tournament.leave";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(args.length != 2){
            sender.sendMessage("Usage: /tournament leave <arena name>");
            return;
        }

        if(!(sender instanceof Player)) return;

        final Player player = (Player) sender;

        Tournament tournament = main.getTournamentsManager().getTournament(args[1]);

        if(tournament == null){
            player.sendMessage("Tournament not found.");
            return;
        }

        tournament.removeActivePlayer(player.getUniqueId());

        player.sendMessage("You have left the tournament.");
    }
}
