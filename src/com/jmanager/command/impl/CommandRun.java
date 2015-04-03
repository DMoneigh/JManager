package com.jmanager.command.impl;

import java.io.IOException;

import com.jmanager.JManager;
import com.jmanager.command.Command;

/**
 * The "run::" command.
 * 
 * @author Desmond Jackson
 */
public class CommandRun extends Command {

	/**
	 * Creates a new "run::" command representation.
	 * 
	 * @param jManager The manager
	 */
	public CommandRun(JManager jManager) {
		super(jManager, "run");
	}

	@Override
	public boolean execute(String[] arguments) {
		try {
			Runtime.getRuntime().exec(arguments);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public String getUsage() {
		return "run::[arg1] [arg2] [arg3] [arg...";
	}

	@Override
	public String getHelp() {
		return "Runs a command on this bots native terminal.";
	}

}
