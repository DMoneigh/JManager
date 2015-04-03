package com.jmanager.command.impl;

import com.jmanager.JManager;
import com.jmanager.command.Command;

/**
 * The "quit::" command.
 * 
 * @author Desmond Jackson
 */
public class CommandQuit extends Command {

	/**
	 * Creates a new "quit::" command representation.
	 * 
	 * @param jManager The manager
	 */
	public CommandQuit(JManager jManager) {
		super(jManager, "quit");
	}

	@Override
	public boolean execute(String[] arguments) {
		System.exit(0);
		return true;
	}

	@Override
	public String getUsage() {
		return "quit::";
	}

	@Override
	public String getHelp() {
		return "Quits the IRC.";
	}

}
