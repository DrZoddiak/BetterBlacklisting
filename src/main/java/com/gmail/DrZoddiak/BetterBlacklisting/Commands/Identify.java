package com.gmail.DrZoddiak.BetterBlacklisting.Commands;


import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.data.type.HandTypes;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.inventory.ItemStack;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import net.minecraft.item.ItemBlock;

@SuppressWarnings("ALL")
public class Identify implements CommandExecutor
{

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException
    {
        Player player = (Player) src;
        String identity = "";

        if (!player.getItemInHand(HandTypes.MAIN_HAND).isPresent())
        {

            player.sendMessage(Text.of("There is nothing in your hand!"));

            return CommandResult.success();
        }
        else
        {
            ItemStack itemInHand =  player.getItemInHand(HandTypes.MAIN_HAND).get();

            if (itemInHand.getItem() instanceof ItemBlock)
            {
                ItemBlock itemBlock = (ItemBlock) itemInHand.getItem();
                net.minecraft.item.ItemStack nmsStack = (net.minecraft.item.ItemStack) (Object) itemInHand;
                BlockState blockState = ((BlockState) itemBlock.getBlock().getStateFromMeta(nmsStack.getItemDamage()));
                identity = blockState.getId();


                player.sendMessage(Text.of(identity));
            }
            else
            {
                identity = itemInHand.getItem().getId();

                player.sendMessage(Text.of(identity));
            }
        }

        return CommandResult.success();


    }



}


 /* if(src instanceof Player)
        {
            Player player = (Player) src;
            if(player.getItemInHand(HandTypes.MAIN_HAND).isPresent())
            {
                String Identity = "";
                ItemStack itemstack =  player.getItemInHand(HandTypes.MAIN_HAND).get();

                if (itemstack.getItem() instanceof ItemBlock) {
                    ItemBlock itemBlock = (ItemBlock) itemstack.getItem();
                    net.minecraft.item.ItemStack nmsStack = (net.minecraft.item.ItemStack) (Object) itemstack;
                    BlockState blockState = ((BlockState) itemBlock.getBlock().getStateFromMeta(nmsStack.getItemDamage()));
                    Identity = blockState.getId();

                    player.sendMessage(Text.of(Identity));
                }
                else {
                    Identity = itemstack.getItem().getId();

                    player.sendMessage(Text.of(Identity));
                }



            }
            else
                src.sendMessage(Text.of(TextColors.RED, "Your Main hand has nothing in it!"));
        }
        else
            throw new CommandException(Text.of("You cannot use this command from console!"));
*/