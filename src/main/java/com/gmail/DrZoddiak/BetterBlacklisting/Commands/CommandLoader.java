package com.gmail.DrZoddiak.BetterBlacklisting.Commands;

import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.text.Text;

import com.gmail.DrZoddiak.BetterBlacklisting.Reference;

public class CommandLoader
{

    private CommandSpec add = CommandSpec.builder()
        .description(Text.of("Adds item to banned item list")).executor(new Add()).arguments(GenericArguments.onlyOne(GenericArguments
        .string(Text.of("id")))).permission(Reference.ADD_ITEM).build();

    private CommandSpec remove = CommandSpec.builder()
        .description(Text.of("Removes item from banned item list")).executor(new Remove()).arguments(GenericArguments.onlyOne(GenericArguments
        .string(Text.of("id")))).permission(Reference.REMOVE_ITEM).build();

    private CommandSpec list = CommandSpec.builder()
        .description(Text.of("Show banned items in a list")).executor(new BList()).permission(Reference.LIST_ITEM).build();

    private CommandSpec identify = CommandSpec.builder()
            .description(Text.of("Get item ID")).executor(new Identify()).permission(Reference.ID_ITEM).build();

    private CommandSpec reload = CommandSpec.builder()
            .description(Text.of("Reloads Plugin")).executor(new Reload()).permission(Reference.RELOAD_CONFIG).build();

        //Base Command for above commands, as commands are added, create additional children

    public CommandSpec bbl = CommandSpec.builder()
        .description(Text.of("Base command")).executor(new Help()).permission(Reference.HELP_BASE)
            .child(add, "add")
            .child(remove, "remove")
            .child(list, "list")
            .child(identify, "identify")
            .child(reload, "reload")
            .build(); 
}
