package com.jmanager.command.impl;

import com.jmanager.JManager;
import com.jmanager.command.Command;

/**
 * The "ping::" command.
 * 
 * @author Desmond Jackson
 */
public class CommandPing extends Command {

	/**
	 * Creates a new "ping::" command representation.
	 * 
	 * @param jManager The manager
	 */
	public CommandPing(JManager jManager) {
		super(jManager, "ping");
	}

	@Override
	public boolean execute(String[] arguments) {
		jManager.reply("pong");
		return true;
	}

	@Override
	public String getUsage() {
		return "ping::";
	}

	@Override
	public String getHelp() {
		return "Replies to you with the word \"pong\".";
	}

}
