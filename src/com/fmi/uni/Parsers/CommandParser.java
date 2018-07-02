package com.fmi.uni.Parsers;

public class CommandParser {

	public static String parseCommand(String inputFromUser) {

		String result = null;

		String[] wordsInCommand = inputFromUser.toLowerCase().split(" ");

		String command = wordsInCommand[0];

		if (wordsInCommand.length == 1) {
			if (command.equals("winrate")) {
				return "winrate";
			} else if (command.equals("totals")) {
				return "totals";
			}
		} else if (wordsInCommand.length == 3) {
			if (command.equals("winrate")) {
				String parameter = wordsInCommand[1];
				if (parameter.equals("last")) {
					return "winrate last";
				}
			}
		}

		return result;

	}

	public static String getNumberOfMatchesToShowInGetWinrate(String inputFromUser) {

		String[] wordsInUserInput = inputFromUser.toLowerCase().split(" ");

		if (wordsInUserInput.length != 3) {
			return "0";
		}
		return wordsInUserInput[2];

	}

}
