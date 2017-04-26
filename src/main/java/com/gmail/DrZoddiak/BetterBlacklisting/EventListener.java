package com.gmail.DrZoddiak.BetterBlacklisting;

import java.util.Iterator;
import java.util.Optional;

import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.item.inventory.ChangeInventoryEvent;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;

public class EventListener 
{
//Hi there, I am as useful as a screen door on a submarine right now! but I do indeed promise to be useful soon... }
	
	@Listener()
		public void invCheck(ChangeInventoryEvent event)
	{  
		Iterator<Inventory> ite = event.getTargetInventory().slots().iterator();
		while (ite.hasNext())
		{
			Optional<ItemStack> test = ite.next().peek();
			if(test.isPresent())
			{
				String item = test.get().getItem().getName(); 
				System.out.println(item);
				if(Main.list.getList().contains(item))   
					System.out.println("banned");
 			} 
		}
		//Want to store a banned item? too bad!
	} 
}
