package com.gmail.DrZoddiak.BetterBlacklisting;

import java.util.Optional;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.item.inventory.crafting.CraftingOutput;
import org.spongepowered.api.item.inventory.entity.PlayerInventory;

public class EventHandler 
{
//Hi there, I am as useful as a screen door on a submarine right now! but I do indeed promise to be useful soon...
	@Listener
	public void onCraft(CraftingOutput output)
	{   
		//Want to craft a banned item? too bad!
	}
	
	@Listener()
		public void invCheck(PlayerInventory inv)
	{    
		while(inv.slots().iterator().hasNext())
		{
			Optional<ItemStack> temp = inv.slots().iterator().next().peek();
			if(Main.list.getList().contains(temp.toString()))
				inv.iterator().remove();
		}
			
		//Want to store a banned item? too bad!
	}
}
