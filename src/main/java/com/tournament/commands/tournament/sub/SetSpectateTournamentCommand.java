package com.tournament.commands.tournament.sub;

import com.tournament.Main;
import com.tournament.commands.ICommand;
import com.tournament.obj.impl.tournaments.SoloTournament;
import com.tournament.obj.impl.tournaments.Tournament;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpectateTournamentCommand implements ICommand {

    private final Main main;
    public SetSpectateTournamentCommand(final Main main) {
        this.main = main;
    }

    @Override
    public String getName() {
        return "setspectate";
    }

    @Override
    public String getDescription() {
        return "Set the spectator position for the tournament.";
    }

    @Override
    public String getPermission() {
        return "tournament.setspectate";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length != 2){
            sender.sendMessage("Usage: /tournament setspectate <arena name>");
            return;
        }

        if(!(sender instanceof Player)) return;

        final Player player = (Player) sender;

        SoloTournament tournament = main.getTournamentsManager().getTournament(args[1]);

        tournament.addSpectator(player);
        player.sendMessage("Spectator position set for the tournament.");
    }
}
