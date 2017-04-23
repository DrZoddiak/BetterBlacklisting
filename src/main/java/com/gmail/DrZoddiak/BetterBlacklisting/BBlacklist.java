package com.gmail.DrZoddiak.BetterBlacklisting;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import org.slf4j.Logger;

import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;

public class BBlacklist 
{
	private ArrayList<String> banned = new ArrayList<String>();

	public BBlacklist(Logger logger, ConfigurationNode config, Path defaultConfig, ConfigurationLoader<CommentedConfigurationNode> loader) 
	{  
		try
		{
			 config = loader.load();

			if (!defaultConfig.toFile().exists())
			{   
				loader.save(config);  
			}
			else
			{
				//Read data and save into banned arraylist
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
		
		//save change through configs
	}
	
	public void remove(String s)
	{
		banned.remove(s);
		//save change through config
	}
}

//This file is to change config item blacklist
