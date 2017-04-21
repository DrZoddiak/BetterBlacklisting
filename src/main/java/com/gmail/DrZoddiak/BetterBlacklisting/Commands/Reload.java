package com.gmail.DrZoddiak.BetterBlacklisting.Commands;

import com.gmail.DrZoddiak.BetterBlacklisting.Permissions;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class Reload implements CommandExecutor
{
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
    {
        if(src.hasPermission(Permissions.RELOAD_CONFIG))
        {

        }
        else
        {
            src.sendMessage(Text.of(TextColors.RED,"You do not have permission to use this command!"));
        }
        return CommandResult.success();
    }

}
