package com.gmail.DrZoddiak.BetterBlacklisting.Commands;

import net.minecraft.item.ItemBlock;
import org.spongepowered.api.block.BlockState;
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
	    String itemToBan;

		if(src instanceof Player)
        {
            Player player = (Player) src;
            if(player.getItemInHand(HandTypes.MAIN_HAND).isPresent())
            {

                ItemStack itemInHand = player.getItemInHand(HandTypes.MAIN_HAND).get();

                if (itemInHand.getItem() instanceof ItemBlock)
                {
                    ItemBlock itemBlock = (ItemBlock) itemInHand.getItem();
                    net.minecraft.item.ItemStack metadata = (net.minecraft.item.ItemStack) (Object) itemInHand;
                    BlockState blockState = ((BlockState) itemBlock.getBlock().getStateFromMeta(metadata.getItemDamage())); 
                    itemToBan = blockState.getId();

                    player.sendMessage(Text.of(itemToBan));

                    addToConfig(itemToBan,player);
                }
                else
                {
                	
                    itemToBan = itemInHand.getItem().getId();
                    if(itemInHand.supports(Keys.DYE_COLOR)) 
						itemToBan+="[color="+itemInHand.get(Keys.DYE_COLOR).get()+"]";
                    addToConfig(itemToBan,player);

                }
            }
            else
                src.sendMessage(Text.of(TextColors.RED, "Your Main hand has nothing in it!"));
        }
        else
            throw new CommandException(Text.of("You cannot use this command from console!"));

        return CommandResult.success();
	     
    }

    private void addToConfig(String itemToBan, Player player)
    {
        if(!Main.list.getList().contains(itemToBan))
        {
            Main.list.add(itemToBan);
            player.sendMessage(Text.of(TextColors.GREEN,"Successfully added ", TextColors.GRAY, itemToBan, TextColors.GREEN," to blacklist!"));
        }
        else
        {
            player.sendMessage(Text.of(TextColors.RED,"This is already blacklisted!"));
        }
    }
}
