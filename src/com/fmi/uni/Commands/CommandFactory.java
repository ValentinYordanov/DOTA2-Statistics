package com.fmi.uni.Commands;

import java.util.HashMap;
import java.util.Map;

import com.fmi.uni.Parsers.CommandParser;

public abstract class CommandFactory {

	private static Map<String, Command> mapOfCommands = new HashMap<>();

	private static void putInfomationIntoMapOfCommands(String inputFromUser) {

		mapOfCommands.put("totals", new Totals());
		mapOfCommands.put("winrate", new GetWinrate());
		mapOfCommands.put("winrate last", new GetWinrateLastNMatches(Integer.parseInt(CommandParser.getNumberOfMatchesToShowInGetWinrateFromInput(inputFromUser))));

	}

	public static Command getCommandInstance(String inputFromUser, long profile_id) {

		putInfomationIntoMapOfCommands(inputFromUser);
		String parsedCommand = CommandParser.parseCommand(inputFromUser);
		Command commandInstance = mapOfCommands.get(parsedCommand);
		commandInstance.setProfileId(profile_id);
		return commandInstance;
		
	}

}
