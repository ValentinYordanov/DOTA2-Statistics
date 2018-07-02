package tests;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.fmi.uni.Connections.Connector;
import com.fmi.uni.Parsers.DataParser;

public class WinrateLastNMatchesTests {

	@Test
	public void executeWinrateLastNMatchesTest() throws ParseException {
		String jsonData = Connector.getWinrate(95576837, 10);
		JSONObject object = DataParser.getJSONObject(jsonData);

		long wins = 0;
		long losses = 0;

		wins = DataParser.parseSingleObjectLong(object, "win");
		losses = DataParser.parseSingleObjectLong(object, "lose");
		
		assertTrue("wins should be 2", wins == 2);
		assertTrue("losses should be 8", losses == 8);
	}
	
	@Test
	public void executeWinrateLastNMatchesTest2() throws ParseException {
		String jsonData = Connector.getWinrate(1, 10); // invalid profile ID
		JSONObject object = DataParser.getJSONObject(jsonData);

		long wins = 0;
		long losses = 0;

		wins = DataParser.parseSingleObjectLong(object, "win");
		losses = DataParser.parseSingleObjectLong(object, "lose");
		
		assertTrue("wins should be 0", wins == 0);
		assertTrue("losses should be 0", losses == 0);
	}

}
