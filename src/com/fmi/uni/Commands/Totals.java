package com.fmi.uni.Commands;

import org.json.simple.parser.ParseException;

import com.fmi.uni.Connections.Connector;
import com.fmi.uni.Parsers.JSONParsers;

public class Totals extends Command {

	protected Totals() {

	}

	@Override
	public void execute() {

		long kills = 0;
		long deaths = 0;
		long assists = 0;
		long hero_damage = 0;
		long tower_kills = 0;

		String jsonData = Connector.getTotals(profile_id);
		try {
			kills = JSONParsers.parseArrayOfObjectsByAttribute(jsonData, "kills");
			deaths = JSONParsers.parseArrayOfObjectsByAttribute(jsonData, "deaths");
			assists = JSONParsers.parseArrayOfObjectsByAttribute(jsonData, "assists");
			hero_damage = JSONParsers.parseArrayOfObjectsByAttribute(jsonData, "hero_damage");
			tower_kills = JSONParsers.parseArrayOfObjectsByAttribute(jsonData, "tower_kills");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("kills: " + kills);
		System.out.println("deaths: " + deaths);
		System.out.println("assists: " + assists);
		System.out.println("hero_damage: " + hero_damage);
		System.out.println("tower_kills: " + tower_kills);

	}

}
