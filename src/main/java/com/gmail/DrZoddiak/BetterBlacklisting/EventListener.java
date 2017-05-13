package com.gmail.DrZoddiak.BetterBlacklisting;

import com.sun.org.apache.regexp.internal.RE;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.First;
import org.spongepowered.api.event.item.inventory.ChangeInventoryEvent;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.event.item.inventory.*;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.data.type.*;
import org.spongepowered.api.text.format.TextColors;


public class EventListener 
{
//Hi there, I am as useful as a screen door on a submarine right now! but I do indeed promise to be useful soon... }

	//Removes items from players MAIN hand
	public void removeMain(Player player)
	{
		player.setItemInHand(HandTypes.MAIN_HAND, null);
	}
	//removes items from Off-hand
	public void removeOff(Player player)
	{
		player.setItemInHand(HandTypes.OFF_HAND, null);
	}


	@Listener()
	public void onPickUp(ChangeInventoryEvent.Pickup event, @First Player player)
	{
		ItemType item = event.getTargetEntity().getItemType();
		//if(!player.hasPermission(Reference.BYPASS)) //TODO Uncomment on production!
		{
			if (Main.list.getList().contains(item.getId()))
			{
				event.setCancelled(true);
				event.getTargetEntity().remove();
				//TODO debug message -Remove in production
				System.out.println(item.getName());
				player.sendMessage(Text.of(TextColors.RED, "The item you currently are trying to pick up is banned"));

			}
		}
	}

	@Listener()
	public void onUsePriMain(InteractItemEvent.Primary.MainHand event, @First Player player)
	{
		ItemType item = event.getItemStack().getType();
		//if(!player.hasPermission(Reference.BYPASS))
		{
			if (Main.list.getList().contains(item.getId()))
			{
				event.setCancelled(true);
				removeMain(player);
				//debug message -Remove in production
				System.out.println(item.getName());
				player.sendMessage(Text.of(TextColors.RED, "The item you currently are trying to use is banned"));
			}
		}
	}

	@Listener()
	public void onUseSecMain(InteractItemEvent.Secondary.MainHand event, @First Player player)
	{
		ItemType item = event.getItemStack().getType();
		//if(!player.hasPermission(Reference.BYPASS))
		{
			if (Main.list.getList().contains(item.getId()))
			{
				event.setCancelled(true);
				removeMain(player);
				//debug message -Remove in production
				System.out.println(item.getName());
				player.sendMessage(Text.of(TextColors.RED, "The item you currently are trying to use is banned"));

			}
		}
	}


	@Listener()
	public void onUsePriOff(InteractItemEvent.Primary.OffHand event, @First Player player)
	{
		ItemType item = event.getItemStack().getType();
		//if(!player.hasPermission(Reference.BYPASS))
		{
			if (Main.list.getList().contains(item.getId()))
			{
				event.setCancelled(true);
				removeOff(player);
				//debug message -Remove in production
				System.out.println(item.getName());
				player.sendMessage(Text.of(TextColors.RED, "The item you currently are trying to use is banned"));

			}
		}
	}

	@Listener()
	public void onUseSecOff(InteractItemEvent.Secondary.OffHand event, @First Player player)
	{
		ItemType item = event.getItemStack().getType();
		//if(!player.hasPermission(Reference.BYPASS))
		{
			if (Main.list.getList().contains(item.getId()))
			{
				event.setCancelled(true);
				removeOff(player);
				//debug message -Remove in production
				System.out.println(item.getName());
				player.sendMessage(Text.of(TextColors.RED, "The item you currently are trying to use is banned"));

			}
		}
	}




	//Want to store a banned item? too bad!

} 