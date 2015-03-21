package com.jmanager.command.impl;

import com.jmanager.JManager;
import com.jmanager.command.Command;

/**
 * The "homedirectory::" command.
 * 
 * @author Desmond Jackson
 */
public class CommandHomeDirectory extends Command {

	/**
	 * Creates the "homedirectory::" command representation.
	 * 
	 * @param jManager The manager
	 */
	public CommandHomeDirectory(JManager jManager) {
		super(jManager, "homedirectory");
	}

	@Override
	public boolean execute(String[] arguments) {
		jManager.reply(System.getProperty("user.home"));
		return true;
	}

	@Override
	public String getUsage() {
		return "homedirectory::";
	}

	@Override
	public String getHelp() {
		return "Gets the bot's home directory.";
	}

}
