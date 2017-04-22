package com.gmail.DrZoddiak.BetterBlacklisting.Commands;


import com.gmail.DrZoddiak.BetterBlacklisting.Main;
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
        if(Main.banned.isEmpty())
        	src.sendMessage(Text.of(TextColors.RED, "Blacklist is empty!"));
        else
        {
        	String list="";
        	for(int i=0; i<Main.banned.size();i++)
        	{
        		if(i==0)
        			list = Main.banned.get(i);
        		else
        			list = list + ", "+ Main.banned.get(i); 
        	} 
        	src.sendMessage(Text.of(list));
        }
        return CommandResult.success();
    }

}