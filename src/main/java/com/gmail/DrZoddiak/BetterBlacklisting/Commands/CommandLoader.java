package com.gmail.DrZoddiak.BetterBlacklisting.Commands;

import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

import com.gmail.DrZoddiak.BetterBlacklisting.Permissions;

public class CommandLoader
{


    private CommandSpec add = CommandSpec.builder()
        .description(Text.of("Adds item to banned item list")).executor(new Add()).arguments(GenericArguments.onlyOne(GenericArguments
        .string(Text.of("id")))).permission(Permissions.ADD_ITEM).build();

    private CommandSpec remove = CommandSpec.builder()
        .description(Text.of("Removes item from banned item list")).executor(new Remove()).arguments(GenericArguments.onlyOne(GenericArguments
        .string(Text.of("id")))).permission(Permissions.REMOVE_ITEM).build();

    private CommandSpec list = CommandSpec.builder()
        .description(Text.of("Show banned items in a list")).executor(new BList()).permission(Permissions.LIST_ITEM).build();

    private CommandSpec reload = CommandSpec.builder()
            .description(Text.of("Reloads Plugin")).executor(new Reload()).permission(Permissions.RELOAD_CONFIG).build();

        //Base Command for above commands, as commands are added, create additional children

    public CommandSpec bbl = CommandSpec.builder()
        .description(Text.of("Base command")).executor(new Help()).permission(Permissions.HELP_BASE)
            .child(add, "add")
            .child(remove, "remove")
            .child(list, "list")
            .child(reload, "reload")
            .build();


}
