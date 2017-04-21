package com.gmail.DrZoddiak.BetterBlacklisting;


import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import org.slf4j.Logger;

import com.gmail.DrZoddiak.BetterBlacklisting.Commands.CommandLoader;

import org.spongepowered.api.Game;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStoppingServerEvent;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;



@Plugin(id = "betterblacklisting", name = "BetterBlacklisting",
		version = "0.2.0",
		description = "A betterblacklisting plugin",
		authors = {"DrZoddiak & Burpingdog1"})

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
	Game game;

	private ConfigurationNode config;

	public static ArrayList<String> banned = new ArrayList<>();

	@Inject
	private Logger logger;

	public Logger getLogger()
	{
		return logger;
	}

	@Listener
	public void onPreInit(GamePreInitializationEvent event)
	{
		getLogger().info(String.format("betterblacklisting - Version:0.2.1 - Initializing..."));

		try 
		{
			config = loader.load();

			if (!defaultConfig.toFile().exists()) 
			{
				loader.save(config);
			} 
		}
		catch (IOException e) 
		{
			logger.warn("File not found!");
		}
	}

	@Listener
	public void onInit(GameInitializationEvent event)
	{
		Sponge.getCommandManager().register(this, new CommandLoader().bbl, "BetterBlacklisting","bbl");
		getLogger().info(String.format("Initialized! - Your glorified stop sign has been delivered!"));
	}

	@Listener
	public void gameStop(GameStoppingServerEvent event)
	{
		getLogger().info(String.format("BetterBlacklisting - Server stopping? I guess we can too. - Saving..."));
		//insert save for banned items
	}

}