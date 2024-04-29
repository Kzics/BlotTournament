package com.tournament.commands.tournament;

import com.tournament.Main;
import com.tournament.commands.CommandBase;
import com.tournament.commands.tournament.sub.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TournamentCommand extends CommandBase implements TabCompleter {


    public TournamentCommand(Main main) {
        super(main);
        main.getCommand("tournament").setTabCompleter(this);

        registerSubCommand("create", new CreateTournamentCommand(main));
        registerSubCommand("createkit", new CreateKitTournamentCommand(main));
        //registerSubCommand("setkit", new SetTournamentKitCommand(main));
        registerSubCommand("start", new StartTournamentCommand(main));
        registerSubCommand("setpos", new SetTournamentPositionCommand(main));
        registerSubCommand("setspectate", new SetSpectateTournamentCommand(main));
        registerSubCommand("join", new JoinTournamentCommand(main));
        registerSubCommand("leave", new LeaveTournamentCommand(main));
        registerSubCommand("end", new EndTournamentCommand(main));
        registerSubCommand("eliminate", new EliminateTournamentCommand(main));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return super.onCommand(sender, command, label, args);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> subCommands = new ArrayList<>();
            subCommands.add("create");
            subCommands.add("createkit");
            subCommands.add("start");
            subCommands.add("setpos");
            subCommands.add("setspectate");
            subCommands.add("join");
            subCommands.add("leave");
            subCommands.add("end");
            subCommands.add("eliminate");
            return subCommands;
        }
        return null;
    }
}
