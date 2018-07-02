package com.fmi.uni.Parsers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParsers {
//TO DO : Rename
	public static JSONArray getJSONArray(String jsonData) throws ParseException {

		JSONParser parser = new JSONParser();
		JSONArray resultArray = (JSONArray) parser.parse(jsonData);

		return resultArray;
	}

	public static JSONObject getJSONObject(String jsonData) throws ParseException {
		
		JSONParser parser = new JSONParser();
		JSONObject object = (JSONObject) parser.parse(jsonData);
		
		return object;
		
	}
	
	public static long parseSingleObjectLong(JSONObject object, String key) throws ParseException {
		return (long) object.get(key);
	}
	
	public static String parseSingleObjectString(JSONObject object, String key) {
		return (String) object.get(key);
	}

}
