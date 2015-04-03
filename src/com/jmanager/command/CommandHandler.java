package com.jmanager.command;

import java.util.ArrayList;
import java.util.List;

import com.jmanager.JManager;
import com.jmanager.command.impl.CommandDelete;
import com.jmanager.command.impl.CommandDownload;
import com.jmanager.command.impl.CommandHomeDirectory;
import com.jmanager.command.impl.CommandList;
import com.jmanager.command.impl.CommandOSName;
import com.jmanager.command.impl.CommandPing;
import com.jmanager.command.impl.CommandQuit;
import com.jmanager.command.impl.CommandRun;

/**
 * Handles commands.
 * 
 * @author Desmond Jackson
 */
public class CommandHandler extends Object {
	
	/**
	 * The manager of this command handler.
	 */
	private JManager jManager;
	
	/**
	 * A list of all commands.
	 */
	private List<Command> commands;
	
	/**
	 * Creates a new command handler for a manager.
	 * 
	 * @param jManager The manager of this command handler
	 */
	public CommandHandler(JManager jManager) {
		super();
		this.jManager = jManager;
		this.commands = new ArrayList<Command>();
		commands.add(new CommandDelete(jManager));
		commands.add(new CommandDownload(jManager));
		commands.add(new CommandHomeDirectory(jManager));
		commands.add(new CommandList(jManager));
		commands.add(new CommandOSName(jManager));
		commands.add(new CommandPing(jManager));
		commands.add(new CommandQuit(jManager));
		commands.add(new CommandRun(jManager));
	}
	
	/**
	 * Handles a command and its arguments.
	 * 
	 * @param name The name of the command
	 * 
	 * @param arguments The arguments
	 */
	public void handle(String name, String[] arguments) {
		if (name.equalsIgnoreCase("?") || name.equalsIgnoreCase("help")) {
			for (Command command : commands)
				jManager.reply(command.getName() + ":: - " + command.getHelp());
			return;
		}
		for (Command command : commands)
			if (command.getName().equalsIgnoreCase(name)) {
				if (command.execute(arguments))
					jManager.reply("Command completed successfully!");
				else
					jManager.reply("Usage - " + command.getUsage());
				return;
			}
		jManager.reply("Unknown Command.. Type \"?::\" or \"help::\" for help");
	}

}
