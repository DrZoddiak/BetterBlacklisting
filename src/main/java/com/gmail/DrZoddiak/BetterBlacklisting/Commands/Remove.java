package com.gmail.DrZoddiak.BetterBlacklisting.Commands;  

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import com.gmail.DrZoddiak.BetterBlacklisting.Main; 
public class Remove implements CommandExecutor
{

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException 
	{ 
		String itemID = args.getOne("id").get().toString(); 
				if(Main.banned.contains(itemID)) 
				{
					Main.banned.remove(itemID);
					src.sendMessage(Text.of(TextColors.GREEN,"Sucessfully removed from blacklist!"));
				} 
				else
				{
					src.sendMessage(Text.of(TextColors.RED,"This is not blacklisted!"));
				} 
		return CommandResult.success();
	} 
}