package com.fmi.uni.Commands;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.fmi.uni.Connections.Connector;
import com.fmi.uni.Parsers.Parser;

public class WinrateLastNMatches extends Winrate {

	private int numberOfMatchesToShow;

	protected WinrateLastNMatches() {
	}

	protected WinrateLastNMatches(int numberOfMatchesToShow) {
		this.numberOfMatchesToShow = numberOfMatchesToShow;
	}

	@Override
	public void execute() {

		String jsonData = Connector.getWinrate(profile_id, numberOfMatchesToShow);
		JSONObject object = null;
		try {
			object = Parser.getJSONObject(jsonData);
		} catch (ParseException e1) {
			System.err.println("problem with getting json object in winrate last N");
		}
		long wins = 0;
		long losses = 0;

		try {
			wins = Parser.parseSingleObjectLong(object, "win");
			losses = Parser.parseSingleObjectLong(object, "lose");
		} catch (ParseException e) {
			System.err.println("problem with parsing in winrate last N");
		}

		printWinrate(wins, losses);

	}

}
