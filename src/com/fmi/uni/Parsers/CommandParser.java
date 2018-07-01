package com.fmi.uni.Parsers;

public class CommandParser {
	
	public static String parseCommand(String inputFromUser) {
		
		String result = null;
		
		String[] wordsInCommand = inputFromUser.split(" ");
		
		String command = wordsInCommand[0];
		
		if (wordsInCommand.length == 1) {
			if (wordsInCommand[0].equals("winrate")) {
				return "winrate";
			} else if (wordsInCommand[0].equals("totals")) {
				return "totals";
			}
		}
		
		return result;
		
	}
	
}
