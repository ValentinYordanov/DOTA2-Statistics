package com.fmi.uni.Commands;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.fmi.uni.Connections.Connector;
import com.fmi.uni.Parsers.JSONParsers;

public class Totals extends Command {

	private Map<String, Long> mapOfValues = new HashMap<>();

	protected Totals() {

	}

	private void iterateJSONArray(JSONArray array) {
		for (Object object : array) {

			JSONObject match = (JSONObject) object;
			try {
				populateMapOfValues(match);
			} catch (ClassCastException ex) {
				continue;
			} catch (ParseException e) {
				System.err.println("problem with populating map of values");
			}
		}

	}

	private void populateMapOfValues(JSONObject match) throws ParseException {
		mapOfValues.put(JSONParsers.parseSingleObjectString(match, "field"),
				JSONParsers.parseSingleObjectLong(match, "sum"));
	}

	private void printMapEntries(Map<String, Long> map) {
		for (Map.Entry<String, Long> entry : mapOfValues.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	
	@Override
	public void execute() {

		String jsonData = Connector.getTotals(profile_id);

		JSONArray array;
		try {
			array = JSONParsers.getJSONArray(jsonData);
			iterateJSONArray(array);
		} catch (ParseException e) {
			System.out.println("Problem with parsing totals");
		}

		printMapEntries(mapOfValues);
	}

}
