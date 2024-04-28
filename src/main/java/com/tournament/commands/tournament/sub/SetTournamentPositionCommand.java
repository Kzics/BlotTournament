package com.tournament.commands.tournament.sub;

import com.tournament.Main;
import com.tournament.SpawnPoint;
import com.tournament.commands.ICommand;
import com.tournament.obj.impl.tournaments.SoloTournament;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetTournamentPositionCommand implements ICommand {

    private final Main main;

    public SetTournamentPositionCommand(final Main main) {
        this.main = main;
    }

    @Override
    public String getName() {
        return "setpos";
    }

    @Override
    public String getDescription() {
        return "Set the position of the tournament";
    }

    @Override
    public String getPermission() {
        return "tournament.setpos";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length != 3){
            sender.sendMessage("Usage: /tournament setpos <arena name> <1 or 2>");
            return;
        }

        Location playerLocation = ((Player) sender).getLocation();

        String tournamentName = args[1];
        int position = Integer.parseInt(args[2]);

        SpawnPoint spawnPoint = new SpawnPoint(playerLocation);

        SoloTournament tournament = main.getTournamentsManager().getTournament(tournamentName);

        tournament.setSpawnPoint(position, spawnPoint);

        sender.sendMessage("Position set");
    }
}
