package com.gmail.DrZoddiak.BetterBlacklisting;

import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

import com.gmail.DrZoddiak.BetterBlacklisting.Commands.Set;

@Plugin(id = "betterblacklisting", name = "BetterBlacklisting", version = "1.0")
public class Main
{
	 @Listener
	 public void onInit(GameInitializationEvent event) 
	 { 
		 CommandSpec bbSet = CommandSpec.builder().description(Text.of("bbSet")).executor(new Set()).build();
		 CommandSpec bbHelp = CommandSpec.builder().description(Text.of("bbHelp")).executor(new Set()).build();
		 CommandSpec bbDelete = CommandSpec.builder().description(Text.of("bbDelete")).executor(new Set()).build();
	 }
}