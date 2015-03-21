package com.jmanager.command;

import com.jmanager.JManager;

/**
 * Represents a command.
 * 
 * @author Desmond Jackson
 */
public abstract class Command extends Object {
	
	/**
	 * The manager.
	 */
	protected JManager jManager;
	
	/**
	 * The name of the command.
	 */
	private String name;
	
	/**
	 * Creates a new command representation.
	 * 
	 * @param jManager The manager
	 * 
	 * @param name The name of the command
	 */
	public Command(JManager jManager, String name) {
		super();
		this.jManager = jManager;
		this.name = name;
	}
	
	/**
	 * Gets the name of the command.
	 * 
	 * @return The name of the command
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Executes the command with the specified arguments.
	 * 
	 * @param arugments The specified arguments
	 * 
	 * @return true if command is completed successfully
	 */
	public abstract boolean execute(String[] arguments);
	
	/**
	 * Gets the usage of this command.
	 * 
	 * @return The usage of this command
	 */
	public abstract String getUsage();
	
	/**
	 * Gets the help for this command.
	 * 
	 * @return The help for this command
	 */
	public abstract String getHelp();
	
}
