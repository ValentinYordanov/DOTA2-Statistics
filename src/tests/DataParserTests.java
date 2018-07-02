package tests;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.fmi.uni.Connections.Connector;
import com.fmi.uni.Parsers.DataParser;

public class DataParserTests {

	@Test
	public void parseSingleObjectLongTest() throws ParseException {
		
		JSONObject object = DataParser.getJSONObject("{\"win\":2335,\"lose\":2281}");
		
		long wins = DataParser.parseSingleObjectLong(object, "win");
		
		assertTrue("parsing single object not working right", wins == 2335);
		
	}
	
	@Test(expected=NullPointerException.class)
	public void parseSingleObjectLongThrowsNullTest() throws ParseException {
		
		JSONObject object = DataParser.getJSONObject("{\"win\":2335,\"losses\":2281}");
		
		long losses = DataParser.parseSingleObjectLong(object, "lose"); //should be losses
		
		assertTrue("parsing single object not working right", losses == 2281);
		
	}
	
	@Test
	public void parseSingleObjectStringTest() throws ParseException {
		
		JSONObject object = DataParser.getJSONObject("{\"win\":\"PASSED\",\"lose\":2281}");
		
		String wins = DataParser.parseSingleObjectString(object, "win");
		
		assertTrue("parsing single object not working right", wins.equals("PASSED"));
		
	}
	
	
}
