package com.jmanager.command.impl;

import java.io.File;

import com.jmanager.JManager;
import com.jmanager.command.Command;

/**
 * The "list::" command.
 * 
 * @author Desmond
 */
public class CommandList extends Command {

	/**
	 * Creates a new "list::" command representation.
	 * 
	 * @param jManager The manager.
	 */
	public CommandList(JManager jManager) {
		super(jManager, "list");
	}

	@Override
	public boolean execute(String[] arguments) {
		File file = new File(arguments[0]);
		if (!file.exists())
			return false;
		for (File f : file.listFiles())
			jManager.reply(f.getName());
		return true;
	}

	@Override
	public String getUsage() {
		return "list::[directory]";
	}

	@Override
	public String getHelp() {
		return "Lists files in a specified directory.";
	}

}
