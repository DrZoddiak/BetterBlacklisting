package com.gmail.DrZoddiak.BetterBlacklisting;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.item.inventory.ChangeInventoryEvent;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public class EventListener 
{
//Hi there, I am as useful as a screen door on a submarine right now! but I do indeed promise to be useful soon... }
	 
		@Listener()
		public void onPickUp(ChangeInventoryEvent.Pickup event, @First Player player)
		{
			ItemType item = event.getTargetEntity().getItemType();  
			if(Main.list.getList().contains(item.getId()))
			{
				event.setCancelled(true);
				event.getTargetEntity().remove();  
				System.out.println(item.getName());  
				player.sendMessage(Text.of(TextColors.RED, "The item you currently are trying to pick up is banned")); 
			}
		}
		//Want to store a banned item? too bad!
} 