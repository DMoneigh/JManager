package com.jmanager.command.impl;

import java.io.File;

import com.jmanager.JManager;
import com.jmanager.command.Command;

/**
 * The "delete::" command.
 * 
 * @author Desmond Jackson
 */
public class CommandDelete extends Command {

	/**
	 * Creates a new "delete::" command representation.
	 * 
	 * @param jManager The manager
	 */
	public CommandDelete(JManager jManager) {
		super(jManager, "delete");
	}

	@Override
	public boolean execute(String[] arguments) {
		return new File(arguments[0]).delete();
	}

	@Override
	public String getUsage() {
		return "delete::[file path]";
	}

	@Override
	public String getHelp() {
		return "Deletes a specified file.";
	}

}
