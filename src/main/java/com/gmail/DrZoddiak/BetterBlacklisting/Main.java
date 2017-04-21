package com.gmail.DrZoddiak.BetterBlacklisting;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.spongepowered.api.Game;
import org.spongepowered.api.command.args.GenericArguments;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

import com.gmail.DrZoddiak.BetterBlacklisting.Commands.*;

import com.google.inject.Inject;

import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;

@Plugin(id = "betterblacklisting", name = "BetterBlacklisting", version = "1.0")
public class Main
{
	@Inject
	@DefaultConfig(sharedRoot = true)
	private Path defaultConfig;
	
	@Inject
	@DefaultConfig(sharedRoot = true)
	private ConfigurationLoader<CommentedConfigurationNode> loader;
	
	@Inject
	@DefaultConfig(sharedRoot = true)
	private Path configDir; 
	
	@Inject
	private Logger logger;
	
	@Inject
	Game game;   
	
	private ConfigurationNode config;
	public static ArrayList<String> banned = new ArrayList<String>();
	
	@Listener
	public	void onPreInit(GamePreInitializationEvent event)
	{
		try
		{
			config = loader.load();

			if(!defaultConfig.toFile().exists())
			{
				loader.save(config);
			}
			else
			{  
			}
		}
		catch (IOException e)
		{
			logger.warning("File not found!");
		}
	}
	
	@Listener
	public void Init(GameInitializationEvent event)
	{  
		commandLoad();
	}

	private void commandLoad()
	{

		CommandSpec add = CommandSpec.builder()
				.description(Text.of("Adds item to banned item list")).executor(new Add())
				.arguments(GenericArguments.onlyOne(GenericArguments.string(Text.of("id")))).permission(Permissions.ADD_ITEM).build();
		CommandSpec remove = CommandSpec.builder()
				.description(Text.of("Deletes item from banned item list")).executor(new Remove())
				.arguments(GenericArguments.onlyOne(GenericArguments.string(Text.of("id")))).permission(Permissions.DELETE_ITEM).build();
		//Base Command for above commands, as commands are added, create additional children
		CommandSpec bbl = CommandSpec.builder()
				.description(Text.of("Base command")).executor(new Help()).child(add, "add").child(remove, "remove").build();

		game.getCommandManager().register(this, add, "bbladd");
		game.getCommandManager().register(this, remove, "bblremove");
		game.getCommandManager().register(this, bbl, "bbl help");
	}

}