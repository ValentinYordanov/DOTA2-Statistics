package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fmi.uni.Connections.Connector;

public class ConnectorTests {

	@Test
	public void getWinrateTest() {
		String str = Connector.getWinrate(95576837);
		assertTrue("not correct json data downloaded for winrate", str.equals("{\"win\":2335,\"lose\":2281}"));
	}
	
	@Test
	public void getWinrateLastNTest() {
		String str = Connector.getWinrate(95576837, 10);
		assertTrue("not correct json data downloaded for winrate last 10", str.equals("{\"win\":2,\"lose\":8}"));
	}
	
	@Test
	public void getDataFromApiTest() {
		String data = Connector.getDataFromAPI("https://api.opendota/api/players/95576837/wl"); // missing .com
		assertTrue("value should be null", data == null);
	}
}
