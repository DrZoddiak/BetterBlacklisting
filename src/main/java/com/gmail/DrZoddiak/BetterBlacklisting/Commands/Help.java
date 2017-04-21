package com.gmail.DrZoddiak.BetterBlacklisting.Commands;

import java.util.List;

import com.google.common.collect.Lists;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.service.pagination.PaginationList;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColors;

public class Help implements CommandExecutor
{

	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{
		List<Text> helpText = Lists.newArrayList(); 
			helpText.add(Text.of(TextColors.GREEN, Text.builder("/bbl add").onClick(TextActions.suggestCommand("/bbl add modID:itemID")),TextColors.GRAY," modID:itemID",TextColors.DARK_GRAY," - ",TextColors.DARK_AQUA,"Is used to add items to banned item list"));
			helpText.add(Text.of(TextColors.GREEN, Text.builder("/bbl remove").onClick(TextActions.suggestCommand("/bbl remove modID:itemID")),TextColors.GRAY," modID:itemID",TextColors.DARK_GRAY," - ",TextColors.DARK_AQUA,"Is used to add items to banned item list"));
			helpText.add(Text.of(TextColors.GREEN, Text.builder("/bbl reload").onClick(TextActions.runCommand("/bbl reload")),TextColors.DARK_GRAY," - ",TextColors.DARK_AQUA,"Reloads files"));
			helpText.add(Text.of(TextColors.GREEN, Text.builder("/bbl list").onClick(TextActions.runCommand("/bbl list")),TextColors.DARK_GRAY," - ",TextColors.DARK_AQUA,"Shows items that are currently on the banned item list"));

			PaginationList.builder()
					.title(Text.of(TextColors.GREEN, " BetterBlacklisting Help")).padding(Text.of(TextColors.YELLOW, "=")).contents(helpText).sendTo(src);
 
		return CommandResult.success();

	}

}
