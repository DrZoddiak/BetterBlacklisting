package com.gmail.DrZoddiak.BetterBlacklisting.Commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player; 

//#Idealy the command structure should resemble /bbl set (itemID) true
//#and/or resemble /bbl set true | This of course detecting the item in hand.
public class Add implements CommandExecutor
{

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{  
		if(src instanceof Player)
		{
			
		}
		return null;
	}
	
}
