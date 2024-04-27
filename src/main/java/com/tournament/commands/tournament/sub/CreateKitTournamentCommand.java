package com.tournament.commands.tournament.sub;

import com.tournament.commands.ICommand;
import com.tournament.enums.WatchType;
import com.tournament.menu.impl.kits.KitInfoMenu;
import com.tournament.obj.impl.Kit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateKitTournamentCommand implements ICommand {
    @Override
    public String getName() {
        return "createkit";
    }

    @Override
    public String getDescription() {
        return "Create a new kit tournament";
    }

    @Override
    public String getPermission() {
        return "tournament.createkit";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(args.length != 2){
            sender.sendMessage("Usage: /tournament createkit <kit name>");
            return;
        }

        String kitName = args[0];
        Kit kit = new Kit(kitName);

        new KitInfoMenu(kit, WatchType.EDITOR).open((Player) sender);
    }
}
