package com.fmi.uni.Commands;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.json.simple.parser.ParseException;

import com.fmi.uni.Connections.Connector;
import com.fmi.uni.Parsers.JSONParsers;

public class GetWinrateLastNMatches extends Command {

	private int numberOfMatchesToShow;
	
	protected GetWinrateLastNMatches() {
	}
	
	protected GetWinrateLastNMatches(int numberOfMatchesToShow) {
		this.numberOfMatchesToShow = numberOfMatchesToShow;
	}

	@Override
	public void execute() {
		
		String jsonData = Connector.getWinrate(profile_id, numberOfMatchesToShow);
		long wins = 0;
		long losses = 0;

		try {
			wins = JSONParsers.parseSingleObjectLong(jsonData, "win");
			losses = JSONParsers.parseSingleObjectLong(jsonData, "lose");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);

		System.out.println("wins: " + wins);
		System.out.println("losses: " + losses);
		double winrate = (double) wins / (wins + losses);
		System.out.println("Total winrate: " + df.format(winrate));
		
	}

}
