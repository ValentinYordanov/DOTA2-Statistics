package tests;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.fmi.uni.Connections.Connector;
import com.fmi.uni.Parsers.Parser;

public class ParserTests {

	@Test
	public void parseSingleObjectLongTest() throws ParseException {
		
		String jsonData = Connector.getWinrate(95576837);
		JSONObject object = Parser.getJSONObject(jsonData);
		
		long wins = Parser.parseSingleObjectLong(object, "win");
		
		assertTrue("parsing single object not working right", wins == 2335);
		
	}
	
	@Test
	public void parseSingleObjectStringTest() throws ParseException {
		
		JSONObject object = Parser.getJSONObject("{\"win\":\"PASSED\",\"lose\":2281}");
		
		String wins = Parser.parseSingleObjectString(object, "win");
		
		assertTrue("parsing single object not working right", wins.equals("PASSED"));
		
	}

}
