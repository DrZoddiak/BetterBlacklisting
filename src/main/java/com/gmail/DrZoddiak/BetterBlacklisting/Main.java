package com.gmail.DrZoddiak.BetterBlacklisting;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

import org.spongepowered.api.Game;
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

		CommandSpec set = CommandSpec.builder()
				.description(Text.of("Adds item to banned item list")).executor(new Set()).permission(Permissions.ADD_ITEM).build();
		CommandSpec delete = CommandSpec.builder()
				.description(Text.of("Deletes item from banned item list")).executor(new Delete()).permission(Permissions.DELETE_ITEM).build();
		//Base Command for above commands, as commands are added, create additional children
		CommandSpec bbl = CommandSpec.builder()
				.description(Text.of("Base command")).executor(new Help()).child(set, "add").child(set, "delete").build();

		game.getCommandManager().register(this, set, "bbl set");
		game.getCommandManager().register(this, delete, "bbl delete");
		game.getCommandManager().register(this, bbl, "bbl help");
	}

}