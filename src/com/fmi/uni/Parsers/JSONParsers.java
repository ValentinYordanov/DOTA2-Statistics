package com.fmi.uni.Parsers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParsers {

	public static long parseArrayOfObjectsByAttribute(String jsonData, String attribute) throws ParseException {

		JSONParser parser = new JSONParser();
		JSONArray a = (JSONArray) parser.parse(jsonData);

		for (Object o : a) {
			JSONObject match = (JSONObject) o;

			String attr = (String) match.get("field");
			if (attr.equals(attribute)) {
				return (long) match.get("sum");
			}
		}
		return 0;
	}

	public static long parseSingleObjectLongs(String jsonData, String attribute) throws ParseException {

		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(jsonData);

		return (long) obj.get(attribute);
	}

}
