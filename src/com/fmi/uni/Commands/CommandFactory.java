package com.fmi.uni.Commands;

public interface CommandFactory {

	static Command getCommand(String command, long profile_id) {
		String[] words = command.toLowerCase().split(" ");
//TO DO: Refactor this
		if (words.length == 1) {
			if (words[0].equals("winrate")) {
				GetWinrate getWinrateLastMatches = new GetWinrate();
				getWinrateLastMatches.setProfileId(profile_id);
				return getWinrateLastMatches;
			} else if (words[0].equals("totals")) {
				Totals totals = new Totals();
				totals.setProfileId(profile_id);
				return totals;
			}
		} else {
			try {
				if (words[0].equals("winrate")) {
					if (words[1].equals("last")) {
						return new GetWinrate(profile_id, Integer.parseInt(words[2]));
					}
				}
			} catch (ArrayIndexOutOfBoundsException ex) {
				GetWinrate getWinrateLastNMatches = new GetWinrate();
				getWinrateLastNMatches.setProfileId(profile_id);
				return getWinrateLastNMatches;
			}
		}

		return null;
	}

}
