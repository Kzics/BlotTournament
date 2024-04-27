package com.tournament.commands.tournament;

import com.tournament.Main;
import com.tournament.commands.CommandBase;
import com.tournament.commands.tournament.sub.CreateTournamentCommand;
import com.tournament.commands.tournament.sub.SetTournamentKitCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TournamentCommand extends CommandBase {


    public TournamentCommand(Main main) {
        registerSubCommand("create", new CreateTournamentCommand(main));
        registerSubCommand("createkit", new CreateTournamentCommand(main));
        registerSubCommand("setkit", new SetTournamentKitCommand(main));
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return super.onCommand(sender, command, label, args);
    }
}
