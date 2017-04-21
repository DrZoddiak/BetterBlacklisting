package com.gmail.DrZoddiak.BetterBlacklisting.Commands;


import com.gmail.DrZoddiak.BetterBlacklisting.Permissions;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class BList implements CommandExecutor
{
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
    {
        if(src.hasPermission(Permissions.LIST_ITEM))
        {
            //We need storage before this can really be done
        }
        else
        {
            src.sendMessage(Text.of(TextColors.RED,"You do not have permission to use this command!"));
        }
        return CommandResult.success();
    }

}
