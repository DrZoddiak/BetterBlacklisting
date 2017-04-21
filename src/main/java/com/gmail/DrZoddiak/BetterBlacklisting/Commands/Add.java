package com.gmail.DrZoddiak.BetterBlacklisting.Commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import com.gmail.DrZoddiak.BetterBlacklisting.Main; 

//#Idealy the command structure should resemble /bbl set (itemID) true
//#and/or resemble /bbl set true | This of course detecting the item in hand.
public class Add implements CommandExecutor
{

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{  
		String itemID = args.getOne("id").get().toString();
		if(src instanceof Player)
		{ 
				if(!Main.banned.contains(itemID)) 
				{
					Main.banned.add(itemID);
					src.sendMessage(Text.of(TextColors.GREEN,"Sucessfully added to blacklist!"));
				} 
				else
				{
					src.sendMessage(Text.of(TextColors.RED,"This is already blacklisted!"));
				}
		}
		return CommandResult.success();
	}
	
}
