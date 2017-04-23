package com.gmail.DrZoddiak.BetterBlacklisting.Commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;

import com.gmail.DrZoddiak.BetterBlacklisting.Main;  

public class Reload implements CommandExecutor
{
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
    { 
    	Main.list.reload();
        return CommandResult.success();
    }

}
