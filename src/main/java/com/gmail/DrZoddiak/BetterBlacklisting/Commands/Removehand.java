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

public class Removehand implements CommandExecutor
{
	@Override
	public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
	{
	    String itemToUnban;

		if(src instanceof Player)
        {
            Player player = (Player) src;
            if(player.getItemInHand(HandTypes.MAIN_HAND).isPresent())
            {
                ItemStack itemInHand = player.getItemInHand(HandTypes.MAIN_HAND).get();

                if (itemInHand.getItem() instanceof ItemBlock) {
                    ItemBlock itemBlock = (ItemBlock) itemInHand.getItem();
                    net.minecraft.item.ItemStack metadata = (net.minecraft.item.ItemStack) (Object) itemInHand;
                    BlockState blockState = ((BlockState) itemBlock.getBlock().getStateFromMeta(metadata.getItemDamage()));
                    itemToUnban = blockState.getId();

                    player.sendMessage(Text.of(itemToUnban));

                    removeFromConfig(itemToUnban, player);
                } else {
                    itemToUnban = itemInHand.getItem().getId();

                    removeFromConfig(itemToUnban, player);
                }
            }
            else
                src.sendMessage(Text.of(TextColors.RED, "Your Main hand has nothing in it!"));
        }
        else
            throw new CommandException(Text.of("You cannot use this command from console!"));

        return CommandResult.success();
	     
    }
    private void removeFromConfig(String itemToUnban, Player src)
    {
        if(Main.list.getList().contains(itemToUnban))
        {
            Main.list.remove(itemToUnban);
            src.sendMessage(Text.of(TextColors.GREEN,"Successfully removed ", TextColors.GRAY, itemToUnban, TextColors.GREEN," from the blacklist!"));
        }
        else
        {
            src.sendMessage(Text.of(TextColors.RED,"This isn't blacklisted!"));
        }
    }
}
