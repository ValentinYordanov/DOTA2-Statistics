package com.fmi.uni.Commands;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.json.simple.parser.ParseException;

import com.fmi.uni.Connections.Connector;
import com.fmi.uni.Parsers.JSONParsers;

public class GetWinrate extends Command {

	private int numberOfMatchesToShow;

	protected GetWinrate(long profile_id, int numberOfMatchesToShow) {

		this.numberOfMatchesToShow = numberOfMatchesToShow;
		this.profile_id = profile_id;

	}

	protected GetWinrate() {

		this.numberOfMatchesToShow = 0;

	}

	@Override
	public void execute() {
		String jsonData;

		if (numberOfMatchesToShow == 0) {
			jsonData = Connector.getWinrate(profile_id);
		} else {
			jsonData = Connector.getWinrate(profile_id, numberOfMatchesToShow);
		}
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

	@Override
	public void setProfileId(long profile_id) {
		super.profile_id = profile_id;
	}

}
