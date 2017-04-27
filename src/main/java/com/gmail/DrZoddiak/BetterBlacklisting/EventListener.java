package com.gmail.DrZoddiak.BetterBlacklisting;

import java.util.Iterator;
import java.util.Optional;

import org.spongepowered.api.entity.Item;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.item.inventory.ChangeInventoryEvent;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.ItemStack;

public class EventListener 
{
//Hi there, I am as useful as a screen door on a submarine right now! but I do indeed promise to be useful soon... }
	 
		@Listener()
		public void onPickUp(ChangeInventoryEvent.Pickup event)
		{
			ItemType item = event.getTargetEntity().getItemType();
			if(Main.list.getList().contains(item.getId()))
			{
				event.setCancelled(true);
				event.getTargetEntity().remove(); 
				System.out.println(item.getId());
			}
		}
		//Want to store a banned item? too bad!
}
