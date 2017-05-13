package com.gmail.DrZoddiak.BetterBlacklisting.Commands;


import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.command.CommandException;

import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.key.Keys;
import org.spongepowered.api.data.manipulator.mutable.item.DurabilityData;

import org.spongepowered.api.data.value.BaseValue;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.data.value.mutable.MutableBoundedValue;
import org.spongepowered.api.entity.Item;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.data.value.mutable.Value;

public class Identify implements CommandExecutor
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

                String Identity = itemInHand.getItem().getId();
                if(itemInHand.supports(Keys.ITEM_BLOCKSTATE))
                player.sendMessage(Text.of(Identity));

                if(!itemInHand.supports(Keys.ITEM_BLOCKSTATE))
                    player.sendMessage(Text.of(Identity + ":" + itemInHand.get(Keys.ITEM_BLOCKSTATE)));


            }
            else
                src.sendMessage(Text.of(TextColors.RED, "Your Main hand has nothing in it!"));
        }
        else
            throw new CommandException(Text.of("You cannot use this command from console!"));

        return CommandResult.success();


    }



}
