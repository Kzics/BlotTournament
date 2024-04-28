package com.tournament.commands.tournament;

import com.tournament.Main;
import com.tournament.commands.CommandBase;
import com.tournament.commands.tournament.sub.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class TournamentCommand extends CommandBase {


    public TournamentCommand(Main main) {
        super(main);

        registerSubCommand("create", new CreateTournamentCommand(main));
        registerSubCommand("createkit", new CreateKitTournamentCommand(main));
        registerSubCommand("setkit", new SetTournamentKitCommand(main));
        registerSubCommand("start", new StartTournamentCommand(main));
        registerSubCommand("setpos", new SetTournamentPositionCommand(main));
        registerSubCommand("setspectate", new SetSpectateTournamentCommand(main));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return super.onCommand(sender, command, label, args);
    }
}
