package com.gmail.DrZoddiak.BetterBlacklisting;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.spongepowered.api.item.inventory.ItemStack;

import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;

public class BBlacklist 
{
	private ArrayList<String> banned = new ArrayList<String>(); 
	private Logger logger;
	private ConfigurationNode config;
	private Path defaultConfig;
	private ConfigurationLoader<CommentedConfigurationNode> loader;

	public BBlacklist(ConfigurationNode config, Path defaultConfig, ConfigurationLoader<CommentedConfigurationNode> loader)
	{   
			this.config = config;
			this.defaultConfig = defaultConfig;
			this.loader = loader;  
			setup();
	}


	
	@SuppressWarnings("unchecked")
	public void setup( ) 
	{    
		try 
		{
			config = loader.load();
			if (!defaultConfig.toFile().exists())
			{   
				config.getNode("Banned").setValue(banned);
				loader.save(config);   
			}
			else
			{
				//Read data and save into banned arraylist
				banned = (ArrayList<String>) config.getNode("Banned").getValue(); 
			} 
		} 
		catch (IOException e)
		{
			logger.warn("File not found!");
		} 
	}
	
	
	public ArrayList<String> getList()
	{
		return banned;
	} 
	
	public void add(String s)
	{
		banned.add(s); 
		config.getNode("Banned").setValue(banned);
		try 
		{
			loader.save(config);
		} 
		catch (IOException e)
		{ 
			e.printStackTrace();
		} 
	}
	
	public void remove(String s)
	{
		banned.remove(s); 
		try 
		{
			loader.save(config);
		} 
		catch (IOException e)
		{ 
			e.printStackTrace();
		} 
	} 
	
	@SuppressWarnings("unchecked")
	public void reload()
	{ 
		try {
			config = loader.load();
			banned = (ArrayList<String>) config.getNode("Banned").getValue(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
}

//This file is to change config item blacklist
