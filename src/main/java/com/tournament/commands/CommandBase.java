package com.tournament.commands;

import com.tournament.Main;
import com.tournament.menu.impl.TournamentsMenu;
import com.tournament.utils.ColorsUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandBase implements CommandExecutor {

    protected Main main;
    public CommandBase(final Main main) {
        this.main = main;
    }
    protected Map<String, ICommand> subCommands = new HashMap<>();

    public void registerSubCommand(String name, ICommand command) {
        subCommands.put(name.toLowerCase(), command);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            ICommand subCommand = subCommands.get(args[0].toLowerCase());
            if (subCommand != null) {
                if(!sender.hasPermission(subCommand.getPermission())){
                    sender.sendMessage(ColorsUtil.translate.apply("&cYou don't have permission to execute this command."));
                    return true;
                }
                subCommand.execute(sender, args);
                return true;
            }
            subCommands.get("help").execute(sender, args);
        }

        if(sender.hasPermission("tournament.admin") || sender.isOp()){
            new TournamentsMenu(main.getTournamentsManager()).open((Player) sender);
        }
        return false;
    }
}