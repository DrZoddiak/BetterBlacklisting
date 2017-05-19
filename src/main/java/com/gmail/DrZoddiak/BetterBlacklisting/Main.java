package com.gmail.DrZoddiak.BetterBlacklisting;

 
import java.nio.file.Path;
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

import static com.gmail.DrZoddiak.BetterBlacklisting.Reference.*;



@Plugin(id = ID, name = NAME,
		version = VERSION,
		description = DESCRIPTION,
		authors = {AUTHORS})

public class Main
{
	@Inject
	@DefaultConfig(sharedRoot = false)
	private Path defaultConfig;

	@Inject
	@DefaultConfig(sharedRoot = false)
	private ConfigurationLoader<CommentedConfigurationNode> loader;

	@Inject
	@DefaultConfig(sharedRoot = false)
	private Path configDir;

	@Inject
	Game game;

	private ConfigurationNode config;

	public static BBlacklist list;

	@Inject
	private Logger logger;

	public Logger getLogger()
	{
		return logger;
	}

	@Listener
	public void onPreInit(GamePreInitializationEvent event)
	{
		getLogger().info(String.format("%s - Version:%s - Initializing...",NAME,VERSION));

		list = new BBlacklist(config, defaultConfig, loader);
	}

	@Listener
	public void onInit(GameInitializationEvent event)
	{
		Sponge.getCommandManager().register(this, new CommandLoader().bbl, "BetterBlacklisting","bbl");
		getLogger().info(String.format("Initialized! - Your glorified stop sign has been delivered!"));
		Sponge.getEventManager().registerListeners(this, new EventListener());
	}

	@Listener
	public void gameStop(GameStoppingServerEvent event)
	{
		getLogger().info(String.format("%s - Server stopping? I guess we can too. - Saving...",NAME));
		//insert save for banned items
	}

}
