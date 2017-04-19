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

import com.gmail.DrZoddiak.BetterBlacklisting.Commands.Delete;
import com.gmail.DrZoddiak.BetterBlacklisting.Commands.Help;
import com.gmail.DrZoddiak.BetterBlacklisting.Commands.Set;
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
	public void onInit(GameInitializationEvent event)   
	{  
		 CommandSpec bbSet = CommandSpec.builder().description(Text.of("bbSet")).permission("bbl.set").executor(new Set()).build();
		 CommandSpec bbHelp = CommandSpec.builder().description(Text.of("bbHelp")).permission("bbl.help").executor(new Help()).build();
		 CommandSpec bbDelete = CommandSpec.builder().description(Text.of("bbDelete")).permission("bbl.delete").executor(new Delete()).build();
		 
		 game.getCommandManager().register(this, bbSet, "bbSet");
		 game.getCommandManager().register(this, bbHelp, "bbHelp");
		 game.getCommandManager().register(this, bbDelete, "bbDelete");  
	}
}