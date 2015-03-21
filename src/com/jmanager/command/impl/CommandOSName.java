package com.jmanager.command.impl;

import com.jmanager.JManager;
import com.jmanager.command.Command;

/**
 * The "osname::" command.
 * 
 * @author Desmond Jackson
 */
public class CommandOSName extends Command {

	/**
	 * Creates the "osname::" command representation.
	 * 
	 * @param jManager The manager
	 */
	public CommandOSName(JManager jManager) {
		super(jManager, "osname");
	}

	@Override
	public boolean execute(String[] arguments) {
		jManager.reply(System.getProperty("os.name"));
		return true;
	}

	@Override
	public String getUsage() {
		return "osname::";
	}

	@Override
	public String getHelp() {
		return "Gets the bot's operating system name.";
	}

}
