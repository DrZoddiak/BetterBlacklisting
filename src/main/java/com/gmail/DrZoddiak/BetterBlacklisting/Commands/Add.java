package com.gmail.DrZoddiak.BetterBlacklisting.Commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import com.gmail.DrZoddiak.BetterBlacklisting.Main;


public class Add implements CommandExecutor
{

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{

	    String itemID = args.getOne("id").get().toString();

		if(itemID.indexOf((":")) == -1)
			src.sendMessage(Text.of(TextColors.RED, "Incorrect format!"));
		else
		{
			if(!Main.list.getList().contains(itemID))
			{
				Main.list.add(itemID);
				src.sendMessage(Text.of(TextColors.GREEN,"Successfully added ", TextColors.GRAY, itemID, TextColors.GREEN," to blacklist!"));
			}
			else
			{
				src.sendMessage(Text.of(TextColors.RED,"This is already blacklisted!"));
			}
		}


        return CommandResult.success();
    }




}
