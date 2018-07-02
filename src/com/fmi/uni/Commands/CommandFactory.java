package com.fmi.uni.Commands;

import java.util.HashMap;
import java.util.Map;

import com.fmi.uni.Parsers.CommandParser;

public abstract class CommandFactory {

	private static Map<String, Command> mapOfCommands = new HashMap<>();

	private static void putInfomationIntoMapOfCommands(String inputFromUser) {

		mapOfCommands.put("totals", new Totals());
		mapOfCommands.put("winrate", new Winrate());
		mapOfCommands.put("winrate last", new WinrateLastNMatches(
				Integer.parseInt(CommandParser.getNumberOfMatchesToShowInGetWinrate(inputFromUser))));

	}

	public static Command getCommandInstance(String inputFromUser, long profile_id) {

		putInfomationIntoMapOfCommands(inputFromUser);
		String parsedCommand = CommandParser.parseCommand(inputFromUser);
		Command commandInstance = mapOfCommands.get(parsedCommand);
		if (commandInstance != null) {
			commandInstance.setProfileId(profile_id);
		}
		return commandInstance;

	}

}
