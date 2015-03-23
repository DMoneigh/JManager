package com.jmanager.command.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.jmanager.JManager;
import com.jmanager.command.Command;

/**
 * The "download::" command.
 * 
 * @author Desmond Jackson
 */
public class CommandDownload extends Command {

	/**
	 * Creates a new "download::" command representation.
	 * 
	 * @param jManager The manager
	 */
	public CommandDownload(JManager jManager) {
		super(jManager, "download");
	}

	@Override
	public boolean execute(String[] arguments) {
		try {
			URL url = new URL(arguments[0]);
			InputStream is = url.openStream();
			OutputStream os = new FileOutputStream(arguments[1]);
			byte[] buffer = new byte[1024];
			int count;
			while ((count = is.read(buffer)) != -1)
				os.write(buffer, 0, count);
			os.close();
			is.close();
                        return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getUsage() {
		return "download::[target url] [target file]";
	}

	@Override
	public String getHelp() {
		return "Downloads a file from the internet.";
	}

}
