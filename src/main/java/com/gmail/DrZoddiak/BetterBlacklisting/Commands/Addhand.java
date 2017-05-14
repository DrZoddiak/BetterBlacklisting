package com.gmail.DrZoddiak.BetterBlacklisting.Commands;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import com.gmail.DrZoddiak.BetterBlacklisting.Main;

public class Addhand implements CommandExecutor
{
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{
		if(src instanceof Player)
        {
            Player player = (Player) src;
            if(player.getItemInHand(HandTypes.MAIN_HAND).isPresent())
            {
                ItemStack itemInHand =  player.getItemInHand(HandTypes.MAIN_HAND).get();
                String itemID;
                if(itemInHand.supports(Keys.ITEM_BLOCKSTATE))
                	itemID = itemInHand.get(Keys.ITEM_BLOCKSTATE).get()+"";
                else
                	itemID = itemInHand.getItem().getId();
                
                if(!Main.list.getList().contains(itemID))
    			{
    				Main.list.add(itemID);
    				src.sendMessage(Text.of(TextColors.GREEN,"Successfully added ", TextColors.GRAY, itemID, TextColors.GREEN," to blacklist!"));
    			}
    			else
    			{
    				src.sendMessage(Text.of(TextColors.RED,"This is already blacklisted!"));
    			} 
            }
            else
                src.sendMessage(Text.of(TextColors.RED, "Your Main hand has nothing in it!"));
        }
        else
            throw new CommandException(Text.of("You cannot use this command from console!"));

        return CommandResult.success();
	     
    }

}
