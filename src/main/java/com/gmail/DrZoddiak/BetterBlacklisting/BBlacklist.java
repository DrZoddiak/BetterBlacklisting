package com.gmail.DrZoddiak.BetterBlacklisting;

import java.io.IOException;
import java.util.ArrayList;

public class BBlacklist 
{
	private ArrayList<String> banned = new ArrayList<String>();
	
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
