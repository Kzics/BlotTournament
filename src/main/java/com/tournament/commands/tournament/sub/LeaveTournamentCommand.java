package com.tournament.commands.tournament.sub;

import com.tournament.commands.ICommand;
import org.bukkit.command.CommandSender;

public class LeaveTournamentCommand implements ICommand {
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

    }
}
