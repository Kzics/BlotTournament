package com.tournament.commands.tournament.sub;

import com.tournament.Main;
import com.tournament.commands.ICommand;
import com.tournament.obj.impl.TournamentPlayer;
import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JoinTournamentCommand implements ICommand {


    private final Main main;
    public JoinTournamentCommand(final Main main) {
        this.main = main;
    }

    @Override
    public String getName() {
        return "join";
    }

    @Override
    public String getDescription() {
        return "Join the tournament";
    }

    @Override
    public String getPermission() {
        return "tournament.join";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if(args.length != 2){
            sender.sendMessage("Usage: /tournament join <arena name>");
            return;
        }

        if(!(sender instanceof Player)) return;

        final Player player = (Player) sender;

        Tournament tournament = main.getTournamentsManager().getTournament(args[1]);

        if(tournament == null){
            player.sendMessage("Tournament not found.");
            return;
        }

        tournament.addActivePlayer(new TournamentPlayer(player));

        player.sendMessage("You have joined the tournament.");
    }
}
