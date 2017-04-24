package com.gmail.DrZoddiak.BetterBlacklisting.Commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import com.gmail.DrZoddiak.BetterBlacklisting.Main;  

public class Reload implements CommandExecutor
{
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
    { 
    	src.sendMessage(Text.of(TextColors.GREEN, "Reloading files..." ));
    	Main.list.reload();
    	src.sendMessage(Text.of(TextColors.GREEN, "Reload complete!" ));
        return CommandResult.success();
    }

}
